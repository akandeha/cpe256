package com.cpe256.playfair;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayFair {
    ArrayList<char[]> split;


    public ArrayList<Character[]> encryptOrDecrypt(MatrixGenerator matrix, String sentence,Boolean isDecrypt){
        ArrayList<Character[]> result = new ArrayList<>();

        //split the sentence into two characters
        splitter(sentence);
        //check which rule each pair falls into
        for(char[] c: split){
           Point firstPosition = matrix.positions.get(c[0]);
           Point secondPosition = matrix.positions.get(c[1]);
//           if(firstPosition == null || secondPosition == null) continue;
           //check which rules the pair fall into
           if(firstPosition.x == secondPosition.x) result.add(rowRule(isDecrypt,matrix,firstPosition,secondPosition));
           else if(firstPosition.y == secondPosition.y) result.add(colRule(isDecrypt,matrix,firstPosition,secondPosition));
           else result.add(rectRule(matrix,firstPosition,secondPosition));
        }
        return result;
    }


    private void splitter(String sentence){
        sentence = sentence.toUpperCase();
        this.split = new ArrayList<>();
        for(int i = 0;i < sentence.length();i+=2){
            if(sentence.charAt(i) == ' ')i++;
            char first = sentence.charAt(i);
            char second;
            try{
                second = sentence.charAt(i+1);
                if(second == ' '){
                    i++;
                    second = sentence.charAt(i+1);
                }
            } catch (IndexOutOfBoundsException e){
                second = 'X';
            }

            if(first == second){
                second = 'X';
                i--;
            }

            char[] s = {first,second};
            this.split.add(s);
        }
        System.out.println(Arrays.deepToString(split.toArray()));
    }

    private Character[] rowRule(Boolean isDecrypt, MatrixGenerator matrixGenerator, Point firsPosition, Point secondPosition){
//        System.out.println("row rulle called");
        Character[] rez = new Character[2];
        int y1,y2;
        if(isDecrypt){
            //move by one point in the left direction for decryption
            y1 = firsPosition.y - 1;
            y2 = secondPosition.y - 1;
        }else {
            //move by one point in the right direction for encryption
            y1 = firsPosition.y + 1;
            y2 = secondPosition.y + 1;
        }
        if(y1 > 4) y1 = 0;
        if(y2 > 4) y2 = 0;

        if(y1 < 0) y1 = 4;
        if(y2 < 0) y2 = 4;

        for(Character c: matrixGenerator.positions.keySet()){
            Point check = matrixGenerator.positions.get(c);
            if(check.x == firsPosition.x && check.y == y1) rez[0] = c;
            if(check.x == secondPosition.x && check.y == y2) rez[1] = c;
        }
        return rez;
    }

    private Character[] colRule(Boolean isDecrypt, MatrixGenerator matrixGenerator, Point firsPosition, Point secondPosition){
        Character[] rez = new Character[2];
        int x1,x2;
        if(isDecrypt){
            //move by one point in the left direction for decryption
            x1 = firsPosition.x - 1;
            x2 = secondPosition.x - 1;
        }else {
            //move by one point in the right direction for encryption
            x1 = firsPosition.x + 1;
            x2 = secondPosition.x + 1;
        }
        if(x1 > 4) x1 = 0;
        if(x2 > 4) x2 = 0;

        if(x1 < 0) x1 = 4;
        if(x2 < 0) x2 = 4;

        for(Character c: matrixGenerator.positions.keySet()){
            Point check = matrixGenerator.positions.get(c);
            if(check.x == x1 && check.y == firsPosition.y) rez[0] = c;
            if(check.x == x2 && check.y == secondPosition.y) rez[1] = c;
        }
        return rez;
    }

    private Character[] rectRule(MatrixGenerator matrixGenerator, Point firsPosition, Point secondPosition){
        Character[] rez = new Character[2];
        Point newFirst = new Point(firsPosition.x, secondPosition.y);
        Point newSec = new Point(secondPosition.x, firsPosition.y);

        for(Character c: matrixGenerator.positions.keySet()){
            Point check = matrixGenerator.positions.get(c);
            if(check.x == newFirst.x && check.y == newFirst.y) rez[0] = c;
            if(check.y == newSec.y && check.x == newSec.x)rez[1] = c;
        }
        return rez;
    }
}
