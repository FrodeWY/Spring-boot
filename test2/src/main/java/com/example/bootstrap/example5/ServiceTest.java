package com.example.bootstrap.example5;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

public class ServiceTest {

    public static void main(String[] args) {
        test1();
        System.out.println("---------------");
        test2();
    }

    public static void test1() {
        String s = new String("1");
        String s2 = "1";
        String intern = s.intern();
        System.out.println(intern == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        String intern1 = s3.intern();
        System.out.println(intern1 == s4);
    }

    public static void test2() {
        String s = new String("1");//变量s的引用地址指向堆中对象,这里会将"1"放入常量池
        String intern = s.intern();
        String s2 = "1";//指向常量池中的"1"
        System.out.println(intern == s2);

        String s3 = new String("1") + new String("1");//这里会将"1"放入常量池
        String intern1 = s3.intern();//将11也放入常量池
        String s4 = "11";//指向常量池中的11
        System.out.println(intern1 == s4);
    }
}
