package com.sls;

public class AfWordReverse {
    public String wordReverse(String sentence) {
        sentence = sentence.trim();
        if (sentence.length() == 0) {
            return "";
        }
        String punctuation = sentence.substring(sentence.length()-1);
        if (punctuation.matches("\\p{Punct}")) {
            sentence = sentence.substring(0, sentence.length() -1);
        } else {
            punctuation = "";
        }
        String[] myWords = sentence.split(" ");
        String results = "";
        for (int i = myWords.length-1; i>=0; i--) {
            results += myWords[i] + ((i==0)?punctuation:" ");
        }
        return results;
    }

}
