package com.java;

import java.util.Objects;

/**
 * @author: wuchao
 * @date： 2017/3/17
 */
class Users {
    int age;
    String name;

    Users() {

    }

    Users(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class ObjectsTest {

    public static void main(String[] args) {
        Users users = new Users(21,"wuchao");
        System.out.println(Objects.toString(users));
    }
}
