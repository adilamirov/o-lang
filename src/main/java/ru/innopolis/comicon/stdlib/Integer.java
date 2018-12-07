package ru.innopolis.comicon.stdlib;


public class Integer {
    public int value;

    //Constructors
    public Integer() { this.value = 0; }

    public Integer(Integer p) {
        this.value = p.value;
    }

    public Integer(int p) {
        this.value = p;
    }

    public Integer(Real p) {
        this.value = p.toInteger().value;
    }

    public Integer(double p) {
        this.value = (int) p;
    }

    //Features
    public Integer Max() {
        return new Integer(2147483647);
    }

    public Integer Min() {
        return new Integer(-2147483648);
    }

    //Conversions
    public Real toReal() {
        return new Real((double) this.value);
    }

    public Boolean toBoolean() {
        return new Boolean(this.value != 0);
    }

    //Unary operators
    public Integer UnaryMinus() {
        return new Integer(this.value - 1);
    }

    //Integer binary arithmetics
    public Integer Plus(Integer p) {
        return new Integer(this.value + p.value);
    }

    public Integer Plus(Real p) {
        return new Integer(this.value + p.toInteger().value);
    }

    public Integer Plus(int p) {
        return new Integer(this.value + p);
    }

    public Integer Plus(double p) {
        return new Integer(this.value + (int) p);
    }

    public Integer Minus(Integer p) {
        return new Integer(this.value - p.value);
    }

    public Integer Minus(Real p) {
        return new Integer(this.value - p.toInteger().value);
    }

    public Integer Minus(int p) {
        return new Integer(this.value - p);
    }

    public Integer Minus(double p) {
        return new Integer(this.value - (int) p);
    }

    public Integer Mult(Integer p) {
        return new Integer(this.value * p.value);
    }

    public Integer Mult(Real p) {
        return new Integer(this.value * p.toInteger().value);
    }

    public Integer Mult(int p) {
        return new Integer(this.value * p);
    }

    public Integer Mult(double p) {
        return new Integer(this.value * (int) p);
    }

    public Integer Div(Integer p) {
        return new Integer(this.value / p.value);
    }

    public Integer Div(Real p) {
        return new Integer(this.value / p.toInteger().value);
    }

    public Integer Div(int p) {
        return new Integer(this.value / p);
    }

    public Integer Div(double p) {
        return new Integer(this.value / (int) p);
    }

    public Integer Rem(Integer p) {
        return new Integer(this.value % p.value);
    }

    public Integer Rem(int p) {
        return new Integer(this.value % p);
    }

    //Relations
    public Boolean Less(Integer p) {
        return new Boolean(this.value < p.value);
    }

    public Boolean Less(Real p) {
        return new Boolean(this.value < p.toInteger().value);
    }

    public Boolean Less(int p) {
        return new Boolean(this.value < p);
    }

    public Boolean Less(double p) {
        return new Boolean(this.value < p);
    }

    public Boolean LessEqual(Integer p) {
        return new Boolean(this.value <= p.value);
    }

    public Boolean LessEqual(Real p) {
        return new Boolean(this.value <= p.value);
    }

    public Boolean LessEqual(int p) {
        return new Boolean(this.value <= p);
    }

    public Boolean LessEqual(double p) {
        return new Boolean(this.value <= p);
    }

    public Boolean Greater(Integer p) {
        return new Boolean(this.value > p.value);
    }

    public Boolean Greater(Real p) {
        return new Boolean(this.value > p.toInteger().value);
    }

    public Boolean Greater(int p) {
        return new Boolean(this.value > p);
    }

    public Boolean Greater(double p) {
        return new Boolean(this.value > p);
    }

    public Boolean GreaterEqual(Integer p) {
        return new Boolean(this.value >= p.value);
    }

    public Boolean GreaterEqual(Real p) {
        return new Boolean(this.value >= p.toInteger().value);
    }

    public Boolean GreaterEqual(int p) {
        return new Boolean(this.value >= p);
    }

    public Boolean GreaterEqual(double p) {
        return new Boolean(this.value >= p);
    }

    public Boolean Equal(Integer p) {
        return new Boolean(this.value == p.value);
    }

    public Boolean Equal(Real p) {
        return new Boolean(this.value == p.toInteger().value);
    }

    public Boolean Equal(int p) {
        return new Boolean(this.value == p);
    }

    public Boolean Equal(double p) {
        return new Boolean(this.value == p);
    }
}
