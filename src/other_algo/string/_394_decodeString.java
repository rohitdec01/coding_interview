package other_algo.string;

public class _394_decodeString {

    /*
    Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

Time Complexity: O(maxK. n)O(maxK⋅n), where maxK is the maximum value of k and n is the length of a given string ss.
We traverse a string of size nn and iterate kk times to decode each pattern of k[string].
This gives us worst case time complexity as O(maxK⋅n).

Space Complexity: O(m+n)O(m+n), where mm is the number of letters(a-z) and nn is the number of digits(0-9) in string ss.
In worst case, the maximum size of stringStack and countStack could be mm and nn respectively.
     */

    static int index = 0;

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    private static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index)))
                result.append(s.charAt(index++));
            else {
                int k = 0;
                // build k while next character is a digit
                while (index < s.length() && Character.isDigit(s.charAt(index)))
                    k = k * 10 + s.charAt(index++) - '0';
                // ignore the opening bracket '['
                index++;
                String decodedString = decodeString(s);
                // ignore the closing bracket ']'
                index++;
                // build k[decodedString] and append to the result
                while (k-- > 0)
                    result.append(decodedString);
            }
        }
        return new String(result);
    }
}
