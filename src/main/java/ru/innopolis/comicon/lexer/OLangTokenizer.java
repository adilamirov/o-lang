package ru.innopolis.comicon.lexer;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;
import ru.innopolis.comicon.parser.MySymbol;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OLangTokenizer implements java_cup.runtime.Scanner {

    private Reader reader = null;

    private char buf[] = new char[20];

    /**
     * The next character to be considered by the nextToken method.  May also
     * be NEED_CHAR to indicate that a new character should be read, or SKIP_LF
     * to indicate that a new character should be read and, if it is a '\n'
     * character, it should be discarded and a second new character should be
     * read.
     */
    private int peekc = NEED_CHAR;

    private static final int NEED_CHAR = Integer.MAX_VALUE;
    private static final int SKIP_LF = Integer.MAX_VALUE - 1;

    /** The line number of the last token read */
    private int LINENO = 1;

    private byte ctype[] = new byte[256];
    private static final byte CT_WHITESPACE = 1;
    private static final byte CT_DIGIT = 2;
    private static final byte CT_ALPHA = 4;
    private static final byte CT_QUOTE = 8;
    private static final byte CT_COMMENT = 16;

    public int ttype = TT_NOTHING;
    public static final int TT_EOF = -228;
    public static final int TT_EOL = '\n';

    public static final int TT_NUMBER = -2;
    public static final int TT_WORD = -3;
    public static final int TT_NOTHING = -4;

    public static final int TT_IDENTIFIER = -5;
    public static final int TT_COLON = -6;
    public static final int TT_ASSIGN = -7;
    public static final int TT_DOT = -8;
    public static final int TT_COMMA = -9;

    public static final int TT_KW_CLASS = -10;
    public static final int TT_KW_EXTENDS = -11;
    public static final int TT_KW_IS = -12;
    public static final int TT_KW_END = -13;
    public static final int TT_KW_VAR = -14;
    public static final int TT_KW_METHOD = -15;
    public static final int TT_KW_THIS = -16;
    public static final int TT_KW_WHILE = -17;
    public static final int TT_KW_LOOP = -18;
    public static final int TT_KW_IF = -19;
    public static final int TT_KW_THEN = -20;
    public static final int TT_KW_ELSE = -21;
    public static final int TT_KW_RETURN = -22;

    public static final int TT_BRACKET_ROUND_OP = -23;
    public static final int TT_BRACKET_ROUND_CL = -24;
    public static final int TT_BRACKET_SQUARE_OP = -25;
    public static final int TT_BRACKET_SQUARE_CL = -26;

    public static final int TT_MINUS_SIGN = -27;
    public static final int TT_PLUS_SIGN = -28;

    private static final Map<String, Integer> KEYWORDS = new HashMap<String, Integer>()
    {{
        put("class", TT_KW_CLASS);
        put("extends", TT_KW_EXTENDS);
        put("is", TT_KW_IS);
        put("end", TT_KW_END);
        put("var", TT_KW_VAR);
        put("method", TT_KW_METHOD);
        put("this", TT_KW_THIS);
        put("while", TT_KW_WHILE);
        put("loop", TT_KW_LOOP);
        put("if", TT_KW_IF);
        put("then", TT_KW_THEN);
        put("else", TT_KW_ELSE);
        put("return", TT_KW_RETURN);
    }};

    private static final Map<Character, Integer> BRACKETS = new HashMap<Character, Integer>()
    {{
        put('(', TT_BRACKET_ROUND_OP);
        put(')', TT_BRACKET_ROUND_CL);
        put('[', TT_BRACKET_SQUARE_OP);
        put(']', TT_BRACKET_SQUARE_CL);
    }};

    public String sval;

    public double nval;

    /** Private constructor that initializes everything except the streams. */
    private OLangTokenizer() {
        wordChars('a', 'z');
        wordChars('A', 'Z');
        whitespaceChars(0, ' ');
        parseNumbers();
    }

    public void init() throws java.io.IOException {
        wordChars('a', 'z');
        wordChars('A', 'Z');
        whitespaceChars(0, ' ');
        parseNumbers();
    }

    /**
     * Create a tokenizer that parses the given character stream.
     *
     * @param r  a Reader object providing the input stream.
     */
    public OLangTokenizer(Reader r) {
        this();
        if (r == null) {
            throw new NullPointerException();
        }
        reader = r;
    }

    /**
     * Specifies that all characters <i>c</i> in the range
     * <code>low&nbsp;&lt;=&nbsp;<i>c</i>&nbsp;&lt;=&nbsp;high</code>
     * are word constituents. A word token consists of a word constituent
     * followed by zero or more word constituents or number constituents.
     *
     * @param   low   the low end of the range.
     * @param   hi    the high end of the range.
     */
    public void wordChars(int low, int hi) {
        if (low < 0)
            low = 0;
        if (hi >= ctype.length)
            hi = ctype.length - 1;
        while (low <= hi)
            ctype[low++] |= CT_ALPHA;
    }

    /**
     * Specifies that all characters <i>c</i> in the range
     * <code>low&nbsp;&lt;=&nbsp;<i>c</i>&nbsp;&lt;=&nbsp;high</code>
     * are white space characters. White space characters serve only to
     * separate tokens in the input stream.
     *
     * <p>Any other attribute settings for the characters in the specified
     * range are cleared.
     *
     * @param   low   the low end of the range.
     * @param   hi    the high end of the range.
     */
    public void whitespaceChars(int low, int hi) {
        if (low < 0)
            low = 0;
        if (hi >= ctype.length)
            hi = ctype.length - 1;
        while (low <= hi)
            ctype[low++] = CT_WHITESPACE;
    }

    /**
     * Specifies that numbers should be parsed by this tokenizer. The
     * syntax table of this tokenizer is modified so that each of the twelve
     * characters:
     * <blockquote><pre>
     *      0 1 2 3 4 5 6 7 8 9 . -
     * </pre></blockquote>
     * <p>
     * has the "numeric" attribute.
     * <p>
     * When the parser encounters a word token that has the format of a
     * double precision floating-point number, it treats the token as a
     * number rather than a word, by setting the {@code ttype}
     * field to the value {@code TT_NUMBER} and putting the numeric
     * value of the token into the {@code nval} field.
     *
     * @see     java.io.StreamTokenizer#nval
     * @see     java.io.StreamTokenizer#TT_NUMBER
     * @see     java.io.StreamTokenizer#ttype
     */
    public void parseNumbers() {
        for (int i = '0'; i <= '9'; i++)
            ctype[i] |= CT_DIGIT;
        ctype['-'] |= CT_DIGIT;
    }

    /** Read the next character */
    private int read() throws IOException {
        if (reader != null)
            return reader.read();
        throw new IllegalStateException();
    }

    /**
     * Parses the next token from the input stream of this tokenizer.
     * The type of the next token is returned in the {@code ttype}
     * field. Additional information about the token may be in the
     * {@code nval} field or the {@code sval} field of this
     * tokenizer.
     * <p>
     * Typical clients of this
     * class first set up the syntax tables and then sit in a loop
     * calling nextToken to parse successive tokens until TT_EOF
     * is returned.
     *
     * @return     the value of the {@code ttype} field.
     * @exception  IOException  if an I/O error occurs.
     * @see        StreamTokenizer#nval
     * @see        StreamTokenizer#sval
     * @see        StreamTokenizer#ttype
     */
    private SymbolFactory sf = new ComplexSymbolFactory();
    public Symbol next_token() throws java.lang.Exception {
        this.nextToken();
        if (this.ttype == TT_IDENTIFIER) {
            return sf.newSymbol(this.toString(), this.toMySymbol(), sval);
        }
        return sf.newSymbol(this.toString(), this.toMySymbol());
    }

    private int nextToken() throws IOException {
        byte ct[] = ctype;
        sval = null;

        int c = peekc;
        if (c < 0)
            c = NEED_CHAR;
        if (c == SKIP_LF) {
            c = read();
            if (c < 0)
                return ttype = TT_EOF;
            if (c == '\n')
                c = NEED_CHAR;
        }
        if (c == NEED_CHAR) {
            c = read();
            if (c < 0)
                return ttype = TT_EOF;
        }
        ttype = c;              /* Just to be safe */

        /* Set peekc so that the next invocation of nextToken will read
         * another character unless peekc is reset in this invocation
         */
        peekc = NEED_CHAR;

        int ctype = c < 256 ? ct[c] : CT_ALPHA;
        while ((ctype & CT_WHITESPACE) != 0) {
            if (c == '\r') {
                LINENO++;
                c = read();
                if (c == '\n')
                    c = read();
            } else {
                if (c == '\n') {
                    LINENO++;
                }
                c = read();
            }
            if (c < 0)
                return ttype = TT_EOF;
            ctype = c < 256 ? ct[c] : CT_ALPHA;
        }

        if ((ctype & CT_DIGIT) != 0) {
            boolean neg = false;
            if (c == '-') {
                c = read();
                if (c != '.' && (c < '0' || c > '9')) {
                    peekc = c;
                    return ttype = TT_MINUS_SIGN;
                }
                neg = true;
            }
            if (c == '.') {
                c = read();
                if (c < '0' || c > '9') {
                    peekc = c;
                    return ttype = TT_DOT;
                }
            }
            double v = 0;
            int decexp = 0;
            int seendot = 0;
            while (true) {
                if (c == '.' && seendot == 0)
                    seendot = 1;
                else if ('0' <= c && c <= '9') {
                    v = v * 10 + (c - '0');
                    decexp += seendot;
                } else
                    break;
                c = read();
            }
            peekc = c;
            if (decexp != 0) {
                double denom = 10;
                decexp--;
                while (decexp > 0) {
                    denom *= 10;
                    decexp--;
                }
                /* Do one division of a likely-to-be-more-accurate number */
                v = v / denom;
            }
            nval = neg ? -v : v;
            return ttype = TT_NUMBER;
        }

        if ((ctype & CT_ALPHA) != 0) {
            int i = 0;
            do {
                if (i >= buf.length) {
                    buf = Arrays.copyOf(buf, buf.length * 2);
                }
                buf[i++] = (char) c;
                c = read();
                ctype = c < 0 ? CT_WHITESPACE : c < 256 ? ct[c] : CT_ALPHA;
            } while ((ctype & (CT_ALPHA | CT_DIGIT)) != 0);
            peekc = c;
            sval = String.copyValueOf(buf, 0, i);
            if (KEYWORDS.containsKey(sval)) {
                return ttype = KEYWORDS.get(sval);
            }
            return ttype = TT_IDENTIFIER;
        }

        if (BRACKETS.containsKey((char) c)) {
            return ttype = BRACKETS.get((char) c);
        }

        if ((char) c == ':') {
            c = this.read();
            if (c != '=') {
                peekc = c;
                return ttype = TT_COLON;
            }
            return ttype = TT_ASSIGN;
        }

        if ((char) c == '.') {
            return ttype = TT_DOT;
        }

        if ((char) c == ',') {
            return ttype = TT_COMMA;
        }

        return ttype = c;
    }

    /**
     * Return the current line number.
     *
     * @return  the current line number of this stream tokenizer.
     */
    public int lineno() {
        return LINENO;
    }

    /**
     * Returns the string representation of the current stream token and
     * the line number it occurs on.
     *
     * <p>The precise string returned is unspecified, although the following
     * example can be considered typical:
     *
     * <blockquote><pre>Token['a'], line 10</pre></blockquote>
     *
     * @return  a string representation of the token
     * @see     java.io.StreamTokenizer#nval
     * @see     java.io.StreamTokenizer#sval
     * @see     java.io.StreamTokenizer#ttype
     */
    public String toString() {
        String ret;
        switch (ttype) {
            case TT_EOF:
                ret = "EOF";
                break;
            case TT_EOL:
                ret = "EOL";
                break;
            case TT_WORD:
                ret = sval;
                break;
            case TT_NUMBER:
                ret = "n=" + nval;
                break;
            case TT_NOTHING:
                ret = "NOTHING";
                break;
            case TT_IDENTIFIER:
                ret="IDENTIFIER";
                break;
            case TT_COLON:
                ret="TT_COLON";
                break;
            case TT_ASSIGN:
                ret="TT_ASSIGN";
                break;
            case TT_DOT:
                ret="TT_DOT";
                break;
            case TT_COMMA:
                ret="TT_COMMA";
                break;
            case TT_KW_CLASS:
                ret="CLASS";
                break;
            case TT_KW_EXTENDS:
                ret="TT_KW_EXTENDS";
                break;
            case TT_KW_IS:
                ret="IS";
                break;
            case TT_KW_END:
                ret="END";
                break;
            case TT_KW_VAR:
                ret="TT_KW_VAR";
                break;
            case TT_KW_METHOD:
                ret="TT_KW_METHOD";
                break;
            case TT_KW_THIS:
                ret="TT_KW_THIS";
                break;
            case TT_KW_WHILE:
                ret="TT_KW_WHILE";
                break;
            case TT_KW_LOOP:
                ret="TT_KW_LOOP";
                break;
            case TT_KW_IF:
                ret="TT_KW_IF";
                break;
            case TT_KW_THEN:
                ret="TT_KW_THEN";
                break;
            case TT_KW_ELSE:
                ret="TT_KW_ELSE";
                break;
            case TT_KW_RETURN:
                ret="TT_KW_RETURN";
                break;
            case TT_BRACKET_ROUND_OP:
                ret="TT_BRACKET_ROUND_OP";
                break;
            case TT_BRACKET_ROUND_CL:
                ret="TT_BRACKET_ROUND_CL";
                break;
            case TT_BRACKET_SQUARE_OP:
                ret="TT_BRACKET_SQUARE_OP";
                break;
            case TT_BRACKET_SQUARE_CL:
                ret="TT_BRACKET_SQUARE_CL";
                break;
            case TT_MINUS_SIGN:
                ret="TT_MINUS_SIGN";
                break;
            case TT_PLUS_SIGN:
                ret="TT_PLUS_SIGN";
                break;
            default: {
                /*
                 * ttype is the first character of either a quoted string or
                 * is an ordinary character. ttype can definitely not be less
                 * than 0, since those are reserved values used in the previous
                 * case statements
                 */
                if (ttype < 256 &&
                        ((ctype[ttype] & CT_QUOTE) != 0)) {
                    ret = sval;
                    break;
                }

                char s[] = new char[3];
                s[0] = s[2] = '\'';
                s[1] = (char) ttype;
                ret = new String(s);
                break;
            }
        }
        return ret;
    }

    public int toMySymbol() {
        String ret;
        switch (ttype) {
            case TT_EOF:
                return MySymbol.EOF;
            case TT_EOL:
                return -1;
            case TT_WORD:
                return -1;
            case TT_NUMBER:
                return MySymbol.INTEGERLITERAL;
            case TT_NOTHING:
                return -1;
            case TT_IDENTIFIER:
                return MySymbol.IDENTIFIER;
            case TT_COLON:
                return MySymbol.COLON;
            case TT_ASSIGN:
                return MySymbol.ASSIGN;
            case TT_DOT:
                return MySymbol.DOT;
            case TT_COMMA:
                return MySymbol.COMMA;
            case TT_KW_CLASS:
                return MySymbol.CLASS;
            case TT_KW_EXTENDS:
                return MySymbol.EXTENDS;
            case TT_KW_IS:
                return MySymbol.IS;
            case TT_KW_END:
                return MySymbol.END;
            case TT_KW_VAR:
                return MySymbol.VAR;
            case TT_KW_METHOD:
                return MySymbol.METHOD;
            case TT_KW_THIS:
                return MySymbol.THIS;
            case TT_KW_WHILE:
                return MySymbol.WHILE;
            case TT_KW_LOOP:
                return MySymbol.LOOP;
            case TT_KW_IF:
                return MySymbol.IF;
            case TT_KW_THEN:
                return MySymbol.THEN;
            case TT_KW_ELSE:
                return MySymbol.ELSE;
            case TT_KW_RETURN:
                return MySymbol.RETURN;
            case TT_BRACKET_ROUND_OP:
                return MySymbol.LPAREN;
            case TT_BRACKET_ROUND_CL:
                return MySymbol.RPAREN;
            case TT_BRACKET_SQUARE_OP:
                return MySymbol.LBRACKET;
            case TT_BRACKET_SQUARE_CL:
                return MySymbol.RBRCKET;
            case TT_MINUS_SIGN:
                return -1;
            case TT_PLUS_SIGN:
                return -1;
        }
        return MySymbol.EOF;
    }

}
