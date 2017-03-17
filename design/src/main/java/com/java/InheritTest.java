package com.java;

/**
 * @author: wuchao
 * @date： 2017/3/16
 */

class Animal {
    private  void beat() {
        System.out.println("心脏跳动");
    }

    public void  breath() {
        beat();
        System.out.println("吸一口气，吐一口气");
    }
}

class Bird extends Animal{
    public void fly() {
        System.out.println("飞翔");
    }
}

class Wolf extends  Animal {
    public void run() {
        System.out.println("奔跑");
    }
}

public class InheritTest {
    static {
        System.out.println("static -------- > ");
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.breath();
        bird.fly();
        Wolf wolf = new Wolf();
        wolf.breath();
        wolf.run();
    }
}
