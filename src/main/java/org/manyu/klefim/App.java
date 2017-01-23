package org.manyu.klefim;

import org.apache.commons.cli.*;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AlgoKLEFIM obj =new AlgoKLEFIM();
        CommandLine commandLine;
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        options.addOption("i", true, "get input file");
        options.addOption("o", true, "get output file");
        options.addOption("k", true, "get K");
        options.addOption("tm", true, "set transaction merging");
        options.addOption("c", true, "get transaction count");
        options.addOption("sup", true, "set subtree utility pruning");
        options.addOption("minlen", true, "minimum length of itemset");
        options.addOption("maxlen", true, "maximum length of it0.emset");
        int k=100;
        String inputPath="mushroom.txt";
        String outputPath="abc.txt";
        boolean activateTransactionMerging=true;
        int maximumTransactionCount=8124;
        boolean activateSubtreeUtilityPruning=true;
        int minLen=0;
        int maxLen=100;
        try {
            commandLine=parser.parse(options,args);
            k=Integer.parseInt(commandLine.getOptionValue("k"));
            inputPath=commandLine.getOptionValue("i");
            outputPath=commandLine.getOptionValue("o");
            maximumTransactionCount=Integer.parseInt(commandLine.getOptionValue("c"));
            activateSubtreeUtilityPruning=Boolean.parseBoolean(commandLine.getOptionValue("sup"));
            activateTransactionMerging=Boolean.parseBoolean(commandLine.getOptionValue("tm"));
            minLen=Integer.parseInt(commandLine.getOptionValue("minlen"));
            maxLen=Integer.parseInt(commandLine.getOptionValue("maxlen"));
            obj.runAlgorithm(k,1,minLen,maxLen,inputPath,outputPath,activateTransactionMerging,maximumTransactionCount,activateSubtreeUtilityPruning);
            obj.printStats();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
