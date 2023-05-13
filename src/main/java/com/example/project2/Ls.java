package com.example.project2;

import java.io.IOException;


import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;


public class Ls {

    @Option(name = "-l", usage = "Long format output")
    public boolean lFlag;
    @Option(name = "-h", usage = "Output to human-readable format")
    public boolean hFlag;
    @Option(name = "-r", usage = "Output order is reversed")
    public boolean rFlag;
    @Option(name = "-o", usage = "Output file", metaVar="OUTPUT")
    public String outputName;
    @Argument
    public String inputName;

    public static void main(String[] args) throws IOException{
        final Ls ls = new  Ls();
        try {
            ls.launch(args);
        }catch (IOException ignored){}

    }
    private void launch(String[] args) throws IOException{
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
        }
        try {
            F file = new F(inputName, lFlag, hFlag, rFlag);
            if (outputName == null) file.output();
            else file.output(outputName);
        }catch (NullPointerException e){
            System.err.println(e.getMessage());
        }
    }
}
