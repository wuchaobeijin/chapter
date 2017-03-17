package com.java;

/**
 * @author: wuchao
 * @date： 2017/3/16
 */
public class Circle extends Shape {


    private double radius;


    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public double calPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getType() {
        return getColor() + "圆形";
    }

    public static void main(String[] args) {
        Shape s1 = new Triangle("黑色",3,4,5);
        Shape s2 = new Circle("黑色",3);
        System.out.println(s1.getType());
        System.out.println(s1.calPerimeter());
        System.out.printf("%.2f",s2.calPerimeter());
        System.out.println();
        System.out.println(s2.getType());

    }
}
