package com.atlacademy.newsmvc.app.demo.config;


import org.springframework.context.annotation.Bean;


public class Student {

    private  int value;

    public Student(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Student() {
    }
}
