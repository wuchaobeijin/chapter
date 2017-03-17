package com.java;

/**
 * @author: wuchao
 * @date： 2017/3/16
 */
public class Triangle extends Shape {

  private double a;

    private double b;
    private double c;


    public Triangle(String color, double a, double b, double c)  {
        super(color);
        setSide(a,b,c);
    }

    public void setSide(double a, double b, double c) {
        if (a > b + c || b > a + c || c > a + b) {
            return;
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calPerimeter() {
        return a + b + c;
    }

    public String getType() {
        return "三角形";
    }
}
