package com.example.dohun.a06week;

/**
 * Created by DoHun on 2017-03-17.
 */

public class Stu {
    private String Name;
    private String Age;

    public Stu(String name,String age) {
        this.Name = name;
        this.Age = age;
    }

    public String getStuname() {
        return this.Name;
    }

    public String getStuage() {
        return this.Age;
    }
}