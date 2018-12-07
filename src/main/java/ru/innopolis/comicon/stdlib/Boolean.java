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
        this.value = (p > 0);
    }

    //Conversion
    public Integer toInteger(){
        return new Integer(this.value ? 1 : 0);
    }

    //Boolean operators
    public Boolean Or(Boolean p){
        return new Boolean(this.value || p.value);
    }

    public Boolean Or(boolean p){
        return new Boolean(this.value || p);
    }

    public Boolean And(Boolean p){
        return new Boolean(this.value && p.value);
    }

    public Boolean And(boolean p){
        return new Boolean(this.value && p);
    }

    public Boolean Xor(Boolean p){
        return new Boolean(this.value ^ p.value);
    }

    public Boolean Xor(boolean p){
        return new Boolean(this.value ^ p);
    }

    public Boolean Not(){
        return new Boolean(!this.value);
    }
}