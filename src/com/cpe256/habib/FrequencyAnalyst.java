package com.cpe256.habib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FrequencyAnalyst {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(new File(args[0]));
        String cypher = input.nextLine();
        HashMap<Character, Integer> holder = new HashMap<>();
        Integer count = 0;
        for(int i = 0;i < cypher.length();i++){
            count = holder.get(cypher.charAt(i));
            if(count != null) {
                count++;
            }else{
                count = 1;
            }
            holder.put(cypher.charAt(i),count);
        }
        System.out.println("------------------------------BEGIN----------------------------------------");
        System.out.println("Cypher Text");
        System.out.println(cypher);
        System.out.println("Analysis");
        System.out.println(holder);
        System.out.println("Enter 1 to Give replacement rule or 2 to exit");
        System.out.println("------------------------------END----------------------------------------");
        String answer = sc.nextLine();

        if(answer.equals("1")){
            System.out.println("Enter replacement rule CypherChar:NewChar. Input pairs should be separated by \",\"");
            String replacementRule = sc.nextLine();
            String[] replacements = replacementRule.split(",");
            String clearText = cypher;
            for (String replacement: replacements) {
                String[] l = replacement.split(":");
                clearText = clearText.replace(l[0],l[1]);
            }
            System.out.println("------------------------------BEGIN----------------------------------------");
            System.out.println("Cypher Text");
            System.out.println(cypher);
            System.out.println("Analysis");
            System.out.println(holder);
            System.out.println("Plain Text");
            System.out.println(clearText);
            System.out.println("------------------------------END----------------------------------------");

        }
    }
}
