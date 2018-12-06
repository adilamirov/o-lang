package ru.innopolis.comicon.stdlib;

public class Boolean {
    private boolean value;

    //Constructors
    public Boolean(Boolean p) {
        this.value = p.value;
    }
    Boolean(boolean p) {
        this.value = p;
    }

    //Conversion
    public Integer toInteger(){
        return new Integer(this.value ? 1 : 0);
    }

    //Boolean operators
    public Boolean Or(Boolean p){
        return new Boolean(this.value || p.value);
    }

    public Boolean And(Boolean p){
        return new Boolean(this.value && p.value);
    }

    public Boolean Xor(Boolean p){
        return new Boolean(this.value ^ p.value);
    }

    public Boolean Not(){
        return new Boolean(!this.value);
    }
}