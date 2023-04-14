package com.example.project2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class F {
    private final File dir_or_file;
    private ArrayList<String> outputText = new ArrayList<>();

    public F(String inputName) {
        dir_or_file = new File(inputName);
    }

    public void output(String outputName){
        File outputFile = new File(outputName);
        try {
            FileWriter writer = new FileWriter(outputFile);
            for (String s : outputText) {
                writer.write(s);
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void output(){
        System.out.println(outputText);
    }

    public void lFlag() {
        String flag;
        for (File file : Objects.requireNonNull(dir_or_file.listFiles())) {
            if (file.canExecute()) flag = "1";
            else flag = "0";
            if (file.canRead()) flag = flag + "1";
            else flag = flag + "0";
            if (file.canWrite()) flag = flag + "1";
            else flag = flag + "0";
            outputText.add(file.getName() + " " + flag +  " " + file.lastModified() + " " + file.length() + "\n");
            Collections.sort(outputText);
        }
    }
    public void hFlag() {
        String flag;
        String fileSize;
        for (File file : Objects.requireNonNull(dir_or_file.listFiles())) {
            flag = "";
            if (file.length() / 1024*1024*1024 > 0) fileSize = String.valueOf((file.length() / 1024*1024*1024)) + "gb";
            if (file.length() / 1024*1024*1024 > 0) fileSize = String.valueOf((file.length() / 1024*1024)) + "mb";
            else fileSize = String.valueOf((file.length() / 1024)) + "kb";
            if (file.canRead()) flag += "r";
            if (file.canWrite()) flag += "w";
            if (file.canExecute()) flag += "x";
            outputText.add(file.getName() + " " + flag + " " + fileSize + "\n");
            Collections.sort(outputText);
        }
    }

    public void rFlag() {
       Collections.sort(outputText, Comparator.reverseOrder());
    }

}
