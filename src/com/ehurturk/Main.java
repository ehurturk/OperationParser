package com.ehurturk;

public class Main {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        String str = "5+12*1";
        int res = Parser.parseInput("4+5*2");

        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;

        System.out.println(res);
        System.out.println("Execution in nanosecond: "+ elapsed);
        System.out.println("Execution in milliseconds: "+ elapsed / 1000000);

    }


}



