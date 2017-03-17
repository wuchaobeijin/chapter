package com.java;

import java.util.Arrays;

/**
 * @author: wuchao
 * @date： 2017/3/16
 */
public class Num2Rmd {

    private String[] hanArr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    private String[] uintArr = {"十", "百","仟"};



    private String[] divide(double num) {
        long zheng = (long)num;
        long xiao = Math.round((num - zheng) * 100);
        return new String[]{zheng + "", xiao + ""};
    }

    private String toHanStr(String numStr) {
        String result = "";
        int numlen = numStr.length();
        for (int i = 0; i < numlen; i++) {
            int num = numStr.charAt(i) - 48;
            if ( i != numlen - 1 && num != 0) {
                result += hanArr[num] + uintArr[numlen - 2 -i];
            } else {
                result += hanArr[num];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Num2Rmd nr = new Num2Rmd();
        System.out.println(Arrays.toString(nr.divide(23423424242.1213)));
        System.out.println(nr.toHanStr("2312"));
    }


}
