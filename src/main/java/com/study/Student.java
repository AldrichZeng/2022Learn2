package com.study;

public class Student {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
        this.id = 1;
        this.name = "zengyao";
    }


    public String calcScore() {
        System.out.println("do something in calcSocre");
        return "returnValue";
    }

    public String method(String a, String b) {
        System.out.println("do something in method");
        System.out.println("Input: [a=" + a + ",b=" + b + "]");
        return a + b;
    }

    public static void main(String[] args) {

    }


}
