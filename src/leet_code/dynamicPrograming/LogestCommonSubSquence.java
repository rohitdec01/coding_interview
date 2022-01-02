package leet_code.dynamicPrograming;

import java.util.Arrays;

public class LogestCommonSubSquence {

    /*NOTE: Using Recursion and dynamic programing*/

    /*Example 1:

    Input: text1 = "abcde", text2 = "ace"
    Output: 3
    Explanation: The longest common subsequence is "ace" and its length is 3.
    Example 2:

    Input: text1 = "abc", text2 = "abc"
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.
    Example 3:

    Input: text1 = "abc", text2 = "def"
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.*/

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequenceUsingRecursionAndDP(text1, text2));
        System.out.println(longestCommonSubsequenceUsingPureDP(text1, text2));
    }

    // ******************** Using Recursion + DP ********************
    public static int longestCommonSubsequenceUsingRecursionAndDP(String text1, String text2) {
        int len1 = text1.length();
        int len2= text2.length();
        int t[][] =new int [len1+1][len2+1];
        // assign -1 to all positions
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return recursion(text1.toCharArray(), text2.toCharArray(), len1, len2, t);
    }

    private static int recursion(char[] text1, char[] text2, int len1, int len2, int t[][]) {
        if (len1 == 0 || len2 == 0)return 0;

        if (t[len1][len2] != -1) {
            return t[len1][len2];
        }

        if (text1[len1-1] == text2[len2-1]){
            return t[len1][len2] = 1 + recursion(text1, text2, len1 -1, len2-1, t);
        }
        return t[len1][len2] = Math.max(
                recursion(text1, text2, len1, len2-1, t),
                recursion(text1, text2, len1-1, len2, t));
    }

    // ******************** Using pure DP ********************
    public static int longestCommonSubsequenceUsingPureDP(String text1, String text2) {
        int len1 = text1.length();
        int len2= text2.length();
        int t[][] = new int [len1+1][len2+1];
        return dp(text1.toCharArray(), text2.toCharArray(), len1, len2, t);
    }

    public static int dp(char[] text1, char[] text2, int len1, int len2, int my_arr[][]) {
        for (int i = 0; i <= len1; i++){
            for (int j = 0; j <= len2; j++){
                if (i == 0 || j == 0)
                    my_arr[i][j] = 0;
                else if (text1[i - 1] == text2[j - 1])
                    my_arr[i][j] = my_arr[i - 1][j - 1] + 1;
                else
                    my_arr[i][j] = Math.max(my_arr[i - 1][j], my_arr[i][j - 1]);
            }
        }
        return my_arr[len1][len2];
    }
}
