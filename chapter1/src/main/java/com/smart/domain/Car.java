package com.smart.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 汽车类
 *
 * @author: wuchao
 * @date： 2017/2/8
 */
//@Configuration
public class Car {
    //品牌
    private String brand;
    //颜色
    private String color;
    //最高速度
    private int maxSpeed;

    private Map fav = new HashMap();

    public void setFav(Map fav) {
        this.fav = fav;
    }

    public Map getFav() {
        return fav;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

//    @Bean(name = "car")
//    public Car buildCar(){
//        Car car = new Car();
//        car.setBrand("奔驰");
//        return car;
//
//    }
}
