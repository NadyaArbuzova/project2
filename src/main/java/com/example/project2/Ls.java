package com.example.project2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ls {
    private static String inputName;
    private static String outputName;
    private static Boolean lFlag = false;
    private static Boolean hFlag = false;
    private static Boolean rFlag = false;

    public static void main(String[] args) {
        try {
            if (args.length==0) throw new IOException();
            for (String arg : args) {
                if (arg.equals("[-l")) lFlag = true;
                if (arg.equals("[-h")) hFlag = true;
                if (arg.equals("[-r")) rFlag = true;
                if (arg.matches(String.valueOf(Pattern.compile("^\\[-o .+$")))) outputName = arg.split(" ")[1];
                else inputName = arg;
            }
            F file = new F(inputName);
            if (lFlag) file.lFlag();
            if (hFlag) file.hFlag();
            if (rFlag) file.rFlag();
            if (outputName.isEmpty()) file.output();
            else file.output(outputName);
        }catch (IOException e){
            System.out.println("Error");
        }
    }
}
