package com.cpe256.habib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) throws FileNotFoundException {

        final char[] english = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".toCharArray();
        final char[] turkish = "AaBbCcÇçDdEeFfGgĞğHhIıİiJjKkLlMmNnOoÖöPpRrSsŞşTtUuÜüVvYyZz".toCharArray();
        final char[] spanish = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnÑñOoPpQqRrSsTtUuVvWwXxYyZz".toCharArray();

        // [Shift Count]:[Encrypt/De-crypt]:[Alphabet 0-4]:Plain text/Cipher Text
        Scanner input = new Scanner(new File(args[0]));
        String[] inputs = input.nextLine().split(":");
        int shift = Integer.parseInt(inputs[0])*2;
        StringBuilder builder = new StringBuilder();

        //the English alphabet is same as the French
        char[] language = switch (inputs[2]) {
            case "2" -> spanish;
            case "3" -> turkish;
            default -> english;
        };

        if(inputs[1].equals("1")){
            shift = -shift;
        }

        for(int i= 0;i < inputs[3].length();i++){
            for(int j = 0;j< language.length;j++){
                if(language[j] == inputs[3].charAt(i)){
                    int shiftBy = j + shift;
                    if(shiftBy > language.length) shiftBy = shiftBy - language.length;
                    if(shiftBy < 0) shiftBy = language.length + shiftBy;
                    builder.append(language[shiftBy]);
                }
            }
        }
        System.out.println(builder);
    }
}
