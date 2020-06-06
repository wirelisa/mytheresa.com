package com.mytheresa.tests;

public class ProblemSolving {

    public static void main(String[] args) {

        System.out.println(check(3));   //divisible by 3 so returns my
        System.out.println(check(5));   //divisible by 5 so returns theresa
        System.out.println(check(7));   //divisible by 7 so returns clothes
        System.out.println(check(11));  //divisible by non of them so returns 11 itself
        System.out.println(check(15));  //divisible by 3 and 5 so returns mytheresa
        System.out.println(check(21));  //divisible by 3 and 7 so returns myclothes
        System.out.println(check(105)); //divisible by 3,5 and 7 so returns mytheresaclothes

    }

    public static String check(int i) {

        String print = "";
        if (i % 3 == 0) print = "my";
        if (i % 5 == 0) print += "theresa";
        if (i % 7 == 0) print += "clothes";
        if(print.length()==0) print +=i;

        return print;

    }

}
