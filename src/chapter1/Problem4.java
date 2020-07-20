package chapter1;

import java.util.Arrays;

public class Problem4 {

    // Check if two strings are anagram or not

    public static void main(String[] arg) {
        System.out.println(isanagramString("yihor", "rohiy"));
    }

    private static boolean isanagramString(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 != len2) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        for (int i = 0; i < len1; i++) {
            if (charArray1[i] != charArray2[i]) {
                return false;
            }
        }
        return true;
    }
}
