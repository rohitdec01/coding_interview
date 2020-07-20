package chapter1;

import java.util.Arrays;

public class Problem1 {
    // 01. Determine if a string has all unique characters.

    private static int MAX_CHAR = 256;

    public static void main(String[] args) {
        System.out.println(uniqueCharacters("rohit"));
    }

    // Use of Extra Data Structure:
    private static boolean uniqueCharacters(String str)
    {
        //Time Complexity: O(n)

        // If length is greater than 256,
        // some characters must have been repeated
        if (str.length() > MAX_CHAR)
            return true;

        boolean[] chars = new boolean[MAX_CHAR];
        Arrays.fill(chars, false);

        char[] charArray = str.toCharArray();
        for (char theChar : charArray) {
            int charInt = (int)theChar;

            if(!chars[charInt]) {
                chars[charInt] = true;
            } else {
                return true;
            }

        }
        return false;
        /*for (int i = 0; i < str.length(); i++) {
            int index = (int)str.charAt(i);

            *//* If the value is already true, string
               has duplicate characters, return false *//*
            if (chars[index] == true) {
                return false;
            }

            chars[index] = true;
        }

        *//* No duplicates encountered, return true *//*
        return true;*/
    }
}
