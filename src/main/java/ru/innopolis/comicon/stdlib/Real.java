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
        return new Real(1.7976931348623157E308D);
    }

    public Real Min() {
        return new Real(4.9E-324D);
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
    public boolean Less(Real temp) {
        return (this.value < temp.value);
    }

    public boolean Less(Integer temp) {
        return (this.value < temp.value);
    }

    public boolean Less(double temp) {
        return (this.value < temp);
    }

    public boolean Less(int temp) {
        return (this.value < temp);
    }

    public boolean LessEqual(Real temp) {
        return (this.value <= temp.value);
    }

    public boolean LessEqual(Integer temp) {
        return (this.value <= temp.value);
    }

    public boolean LessEqual(double temp) {
        return (this.value <= temp);
    }

    public boolean LessEqual(int temp) {
        return (this.value <= temp);
    }

    public boolean Greater(Real temp) {
        return (this.value > temp.value);
    }

    public boolean Greater(Integer temp) {
        return (this.value > temp.value);
    }

    public boolean Greater(double temp) {
        return (this.value > temp);
    }

    public boolean Greater(int temp) {
        return (this.value > temp);
    }

    public boolean GreaterEqual(Real temp) {
        return (this.value >= temp.value);
    }

    public boolean GreaterEqual(Integer temp) {
        return (this.value >= temp.value);
    }

    public boolean GreaterEqual(double temp) {
        return (this.value >= temp);
    }

    public boolean GreaterEqual(int temp) {
        return (this.value >= temp);
    }

    public boolean Equal(Real temp) {
        return (this.value == temp.value);
    }

    public boolean Equal(Integer temp) {
        return (this.value == temp.value);
    }

    public boolean Equal(double temp) {
        return (this.value == temp);
    }

    public boolean Equal(int temp) {
        return (this.value == temp);
    }
}
