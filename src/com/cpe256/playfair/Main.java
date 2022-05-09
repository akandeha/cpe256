package com.cpe256.playfair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to PlayFair Cipher");
        System.out.println("Please enter your key");
        String key = sc.nextLine();
	    // write your code here
        MatrixGenerator m = new MatrixGenerator(key);
//        System.out.println(Arrays.deepToString(m.matrix));
//        System.out.println(m.positions);
        System.out.println("Please enter 1 for Encryption or 2 for Decryption");
        String ende = sc.nextLine();
        boolean isDecrypt = ende.equals("2");

        System.out.println("Please enter the text");
        String text = sc.nextLine();

        PlayFair playFair = new PlayFair();
        ArrayList<Character[]> b = playFair.encryptOrDecrypt(m,text,isDecrypt);
        StringBuilder stringBuilder = new StringBuilder();
        for(Character[] c:b){
            stringBuilder.append(c[0]);
            stringBuilder.append(c[1]);
        }
        System.out.println(stringBuilder);

    }
}
