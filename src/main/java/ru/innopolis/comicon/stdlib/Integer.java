package ru.innopolis.comicon.stdlib;

public class Integer {
    public int value;

    //Constructors
    public Integer(Integer p) {
        this.value = p.value;
    }

    public Integer(int p) {
        this.value = p;
    }

    public Integer(Real p) {
        this.value = p.toInteger().value;
    }

    //Features
    public Integer Max() {
        return new Integer(java.lang.Integer.MAX_VALUE);
    }

    public Integer Min() {
        return new Integer(java.lang.Integer.MIN_VALUE);
    }

    //Conversions
    public Real toReal() {
        return new Real((double)this.value);
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

    public Integer Minus(Integer p) {
        return new Integer(this.value - p.value);
    }

    public Integer Minus(Real p) {
        return new Integer(this.value - p.toInteger().value);
    }

    public Integer Mult(Integer p) {
        return new Integer(this.value * p.value);
    }

    public Integer Mult(Real p) {
        return new Integer(this.value * p.toInteger().value);
    }

    public Integer Div(Integer p) {
        return new Integer(this.value / p.value);
    }

    public Integer Div(Real p) {
        return new Integer(this.value / p.toInteger().value);
    }

    public Integer Rem(Integer p) {
        return new Integer(this.value % p.value);
    }

    //Relations
    public Boolean Less(Integer p) {
        return new Boolean(this.value < p.value);
    }

    public Boolean Less(Real p) {
        return new Boolean(this.value < p.toInteger().value);
    }

    public Boolean LessEqual(Integer p) {
        return new Boolean(this.value <= p.value);
    }

    public Boolean LessEqual(Real p) {
        return new Boolean(this.value <= p.toInteger().value);
    }

    public Boolean Greater(Integer p) {
        return new Boolean(this.value > p.value);
    }

    public Boolean Greater(Real p) {
        return new Boolean(this.value > p.toInteger().value);
    }

    public Boolean GreaterEqual(Integer p) {
        return new Boolean(this.value >= p.value);
    }

    public Boolean GreaterEqual(Real p) {
        return new Boolean(this.value >= p.toInteger().value);
    }

    public Boolean Equal(Integer p) {
        return new Boolean(this.value == p.value);
    }

    public Boolean Equal(Real p) {
        return new Boolean(this.value == p.toInteger().value);
    }
}
