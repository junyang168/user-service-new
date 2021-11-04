package com.broadcom.userservice;

public class Filter {
    private String _name;
    private String _value;

    public Filter(String name, String value) {
        this._name = name;
        this._value = value;
    }

    public String getName() { return this._name;}
    public void setName(String name) { this._name = name;}

    public String getValue() { return this._value;}
    public void setValue(String value) { this._value = value;}    

}