package com.java;

/**
 * @author: wuchao
 * @date： 2017/3/17
 */

class Address {
    String detail;
    public Address(String detail) {
        this.detail = detail;
    }
}

class User implements Cloneable {
    int age;
    Address address;
    public User(int age) {
        this.age = age;
        address = new Address("吴超");
    }

    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

}

public class CloneTest {

    public static void main(String[] args) throws Exception {
        User u1 = new User(29);
        User user = u1.clone();
        System.out.println(u1 == user);
        System.out.println(u1.address == user.address);
    }
}
