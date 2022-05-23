package com.cpe256.prime;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Prime prime = new Prime();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give a number->");
        int number = sc.nextInt();
        int bruteCount = prime.bruteForce(number);
        int algoCount = prime.algorithm(number);
        System.out.println("With 1st method number of iteration  is: "+ bruteCount);
        System.out.println("With 2nd method number of iteration  is: "+ algoCount);
    }
}
