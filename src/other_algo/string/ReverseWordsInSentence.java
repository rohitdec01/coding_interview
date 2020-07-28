package other_algo.string;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Collections;

/*
Reverse the order of words in a given sentence (an array of characters). Take the “Hello World” string for example:
should be "World Hello"
 */
public class ReverseWordsInSentence {

    public static void main(String[] args) {
        String input = "Hello World";
        if (input != null) {
            System.out.println("Input: " + input);
            System.out.println("Output (with Java inbuilt methods):  " + reverseString(input));
            System.out.println("Output (with Algorithm:              " + reverseString2(input));
        }
    }

    private static String reverseString(String input) {
        String[] splittedStr = input.split(" ");
        Collections.reverse(Arrays.asList(splittedStr));
        return Arrays.toString(splittedStr).replaceAll("\\[|\\]|,", "");
    }

    private static String reverseString2(String input) {
        String result = "";
        int index;
        while ((index = input.indexOf(" ")) >= 0) {
            result = input.substring(0, index) + " " + result;
            input = input.substring(index + 1);
        }
        return input + " " + result;
    }

}
