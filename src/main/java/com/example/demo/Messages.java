package com.example.demo;

public class Messages {
    public static final String RESULT = "%.2f %s + %.2f %s = %.2f %s!";
    public static final String INFO = "This is the root. Using this webservice, one can sum two distances " +
            "by navigating to /distance/{distance1}/{distance2}. Additionally you can specify whether each distance is " +
            "in yards or meters by setting the parameter(s) isYardsUnit1 and/or isYardsUnit2 to true/false. " +
            "The default value is false. Finally, you can specify whether the result should be in yards or meters " +
            "by setting the parameter isYardsResult to true/false. The default is false. " +
            "Example usage: /distance/5/5?isYardsUnit1=true&isYardsUnit2=true&isYardsResult=true";
}
