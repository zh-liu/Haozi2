package com.jsecode.androidmvp.bean;

public class MyBean {
    public String type;
    public String name;
    public String age;

    public String getType() {
        return type;
    }

    public MyBean setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public MyBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public MyBean setAge(String age) {
        this.age = age;
        return this;
    }
}
