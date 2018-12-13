package com.farahani.elmira.bitcoinpredictor.utils;

import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomClassifier {
    final static Classifier<String, String> bayes =
            new BayesClassifier<String, String>();

    public static String classify(){
        final String[] positiveText = "I love sunny days".split("\\s");
        bayes.learn("positive", Arrays.asList(positiveText));

        final String[] negativeText = "I hate rain".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText));

        final String[] unknownText1 = "today is a sunny day".split("\\s");
        final String[] unknownText2 = "there will be rain".split("\\s");


        ((BayesClassifier<String, String>) bayes).classifyDetailed(
                Arrays.asList(unknownText1));
        bayes.setMemoryCapacity(500);

        return bayes.classify(Arrays.asList(unknownText1)).getCategory()+" "+bayes.classify(Arrays.asList(unknownText2)).getCategory();

    }

    public static ArrayList<Integer> getPriceArry(ArrayList<Integer> priceArray){
        return priceArray;
    }



}
