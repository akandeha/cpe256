package com.cpe256.playfair;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;

public class MatrixGenerator {
    String key;
    final String ALPHABET = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
    char[][] matrix;
    HashMap<Character,Point> positions;

    public MatrixGenerator(String key) {
        if(key.isEmpty()){
            this.key = ALPHABET;
        }else{
            this.key = key;
        }
        matrix = new char[5][5];
        positions = new HashMap<>();
        generate();
    }

    private void generate(){
        int counter = 0;
        HashSet<Character> hashSet = new HashSet<>();


        for(int i=0;i<5;i++){
            for(int j = 0;j < 5;j++){
                if(counter >= this.key.length()) {
                    counter = reset();
                }
                char current = this.key.charAt(counter);
                while(hashSet.contains(current)){
                    counter++;
                    if(counter == this.key.length()){
                        counter = reset();
                    }
                    current = this.key.charAt(counter);
                }
                hashSet.add(current);
                matrix[i][j] = current;
                positions.put(current,new Point(i,j));
                counter++;
            }
        }
    }

    private int reset(){
        this.key = ALPHABET;
        return 0;
    }
}
