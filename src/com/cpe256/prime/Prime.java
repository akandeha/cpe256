package com.cpe256.prime;

import java.util.ArrayList;
import java.util.HashSet;

public class Prime {
    protected int bruteForce(int number){
        ArrayList<Integer> factors = new ArrayList<>();
        int counter = 0;
        for (int i = 2;i < number;i++){
            if(number%i == 0) {
               factors.add(i);
            }
            counter++;
        }
        if(factors.isEmpty()){
            System.out.println(number+" Is a prime number and the factors are -> ");
        }else{
            System.out.println("From the first method the number "+number+" Is a composite number and the factors are -> "+factors);
        }
        return counter;
    }

    protected int algorithm(int number){
        int root = (int) Math.sqrt(number);
        int i = 2;
        int x = number;
        HashSet<Integer> factors = new HashSet<>();
        while(x > 1 && i <= root){
            while (x % i == 0){ //the primality test
                factors.add(i);
                x = x/i;
                root = (int) Math.sqrt(x);
            }
            i++;
        }
        if(x > 1 && x != number) factors.add(x);
        if(factors.isEmpty()){
            System.out.println(number+" Is a prime number and the factors are -> ");
        }else{
            System.out.println("From the second method the number "+number+" Is a composite number and the factors are -> "+factors);
        }
        return i;
    }
}
