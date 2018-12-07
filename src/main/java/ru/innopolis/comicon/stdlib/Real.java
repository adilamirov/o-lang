package ru.innopolis.comicon.stdlib;

import java.lang.Math;

public class Real {
    public double value;

    // Constructors
    public Real() { this.value = 0; }

    public Real(double temp) {
        this.value = temp;
    }

    public Real(int temp) { this.value = (double) temp; }

    public Real(Integer temp) {
        this.value = temp.toReal().value;
    }

    public Real(Real temp) {
        this.value = temp.value;
    }

    // Features
    public Real Max() {
        return new Real(Double.MAX_VALUE);
    }

    public Real Min() {
        return new Real(Double.MIN_VALUE);
    }

    public Real Epsilon() {
        return new Real(Math.ulp(1));
    }

    public Integer toInteger() {
        return new Integer((int)this.value);
    }

    public Real UnaryMinus() {
        return new Real(this.value - 1);
    }

    public Real Plus(Real temp) {
        return new Real(this.value + temp.value);
    }

    public Real Plus(Integer temp) {
        return new Real(this.value + temp.value);
    }

    public Real Plus(double temp) {
        return new Real(this.value + temp);
    }

    public Real Plus(int temp) {
        return new Real(this.value + temp);
    }

    public Real Minus(Real temp) {
        return new Real(this.value - temp.value);
    }

    public Real Minus(Integer temp) {
        return new Real(this.value - temp.value);
    }

    public Real Minus(double temp) {
        return new Real(this.value - temp);
    }

    public Real Minus(int temp) {
        return new Real(this.value - temp);
    }

    public Real Mult(Real temp) {
        return new Real(this.value * temp.value);
    }

    public Real Mult(Integer temp) {
        return new Real(this.value * temp.toReal().value);
    }

    public Real Mult(double temp) {
        return new Real(this.value * temp);
    }

    public Real Mult(int temp) {
        return new Real(this.value * temp);
    }

    public Real Div(Real temp) {
        return new Real(this.value / temp.value);
    }

    public Real Div(Integer temp) {
        return new Real(this.value / temp.toReal().value);
    }

    public Real Div(double temp) {
        return new Real(this.value / temp);
    }

    public Real Div(int temp) {
        return new Real(this.value / temp);
    }

    public Real Rem(Integer temp) {
        return new Real(this.value % temp.value);
    }

    public Real Rem(int temp) {
        return new Real(this.value % temp);
    }

    // Relations
    public Boolean Less(Real temp) {
        return new Boolean(this.value < temp.value);
    }

    public Boolean Less(Integer temp) {
        return new Boolean(this.value < temp.value);
    }

    public Boolean Less(double temp) {
        return new Boolean(this.value < temp);
    }

    public Boolean Less(int temp) {
        return new Boolean(this.value < temp);
    }

    public Boolean LessEqual(Real temp) {
        return new Boolean(this.value <= temp.value);
    }

    public Boolean LessEqual(Integer temp) {
        return new Boolean(this.value <= temp.value);
    }

    public Boolean LessEqual(double temp) {
        return new Boolean(this.value <= temp);
    }

    public Boolean LessEqual(int temp) {
        return new Boolean(this.value <= temp);
    }

    public Boolean Greater(Real temp) {
        return new Boolean(this.value > temp.value);
    }

    public Boolean Greater(Integer temp) {
        return new Boolean(this.value > temp.value);
    }

    public Boolean Greater(double temp) {
        return new Boolean(this.value > temp);
    }

    public Boolean Greater(int temp) {
        return new Boolean(this.value > temp);
    }

    public Boolean GreaterEqual(Real temp) {
        return new Boolean(this.value >= temp.value);
    }

    public Boolean GreaterEqual(Integer temp) {
        return new Boolean(this.value >= temp.value);
    }

    public Boolean GreaterEqual(double temp) {
        return new Boolean(this.value >= temp);
    }

    public Boolean GreaterEqual(int temp) {
        return new Boolean(this.value >= temp);
    }

    public Boolean Equal(Real temp) {
        return new Boolean(this.value == temp.value);
    }

    public Boolean Equal(Integer temp) {
        return new Boolean(this.value == temp.value);
    }

    public Boolean Equal(double temp) {
        return new Boolean(this.value == temp);
    }

    public Boolean Equal(int temp) {
        return new Boolean(this.value == temp);
    }
}
