package com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: wuchao
 * @date： 2017/3/17
 */
public class KeyInTest {

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("用户输入是: " + line);
        }
    }
}
