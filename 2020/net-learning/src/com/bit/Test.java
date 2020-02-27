package com.bit;
public class Test {
    public static void main(String[] args) {
        System.out.println(Test.class.getClassLoader()
                .getResourceAsStream("../login.html"));
//        System.out.println(Test.class
//                .getResource("../../login.html"));
    }
}
