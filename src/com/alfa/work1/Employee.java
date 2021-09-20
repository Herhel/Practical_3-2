package com.alfa.work1;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String address;
    private transient int ssn;
    private int number;

    public Employee(String name, String address, int ssn, int number) {
        this.name = name;
        this.address = address;
        this.ssn = ssn;
        this.number = number;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getSsn() {
        return ssn;
    }
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", SSN=" + ssn +
                ", number=" + number +
                '}';
    }
}