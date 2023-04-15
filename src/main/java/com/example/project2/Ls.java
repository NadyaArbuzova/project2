package com.example.project2;

import java.io.IOException;
import java.util.regex.Pattern;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class Ls {

    @Option(name = "-l", usage = "Long format output")
    private static Boolean lFlag;
    @Option(name = "-h", usage = "Output to human-readable format")
    private static Boolean hFlag;
    @Option(name = "-r", usage = "Output order is reversed")
    private static Boolean rFlag;
    @Option(name = "-o", usage = "Output file")
    private static String inputName;
    @Argument
    private static String outputName;

    public static void main(String[] args) {
        new Ls().launch(args);
    }
    private void launch(String[] args) {
        Ls bean = new Ls();
        CmdLineParser parser = new CmdLineParser(bean);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
        }
        try {
            F file = new F(inputName);
            if (lFlag) file.lFlag();
            if (hFlag) file.hFlag();
            if (rFlag) file.rFlag();
            if (outputName.isEmpty()) file.output();
            else file.output(outputName);
        }catch (NullPointerException e){
            System.err.println(e.getMessage());
        }
    }
}
