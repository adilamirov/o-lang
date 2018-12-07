package ru.innopolis.comicon.stdlib;

public class Boolean {
    public boolean value;

    //Constructors
    public Boolean() {
        this.value = false;
    }

    public Boolean(Boolean p) {
        this.value = p.value;
    }

    public Boolean(boolean p) {
        this.value = p;
    }

    public Boolean(int p) {
        this.value = (p > 0);
    }

    public Boolean(double p) {
        this.value = (p > .0);
    }

    //Conversion
    public Integer toInteger() {
        return new Integer(this.value ? 1 : 0);
    }

    //Boolean operators
    public boolean Or(Boolean p) {
        return(this.value || p.value);
    }

    public boolean Or(boolean p) {
        return(this.value || p);
    }

    public boolean And(Boolean p) {
        return(this.value && p.value);
    }

    public boolean And(boolean p) {
        return(this.value && p);
    }

    public boolean Xor(Boolean p) {
        return(this.value ^ p.value);
    }

    public boolean Xor(boolean p) {
        return(this.value ^ p);
    }

    public boolean Not() { return (!this.value);
    }
}