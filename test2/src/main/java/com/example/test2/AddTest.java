package com.example.bootstrap;

public class AddTest {


    public static void main(String[] args) {
        Integer result = add(3, 5);
        System.out.println(result);
    }
    public static Integer add(int a,int b){
        int c=a+b;
        int d=c+9;
        return d;
    }
}