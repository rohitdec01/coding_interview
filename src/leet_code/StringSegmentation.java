package leet_code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringSegmentation {

    public static void main(String[] args) {
        String segment = "applepear";
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("apple");
        hashSet.add("pear");
        System.out.println(stringSegmentCheck(segment, hashSet));
    }

    /*
        Runtime Complexity: Exponential, O(2^n)
        Memory Complexity: Polynomial  O(n)
    */
    static boolean stringSegmentCheck(String s, HashSet<String> hashSet) {
        for (int i = 0; i < s.length(); i++) {
            String first = s.substring(0, i);
            if (hashSet.contains(first)) {
                String second = s.substring(i);

                if (second == null || second.length() == 0 || hashSet.contains(second) || stringSegmentCheck(second, hashSet)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
            Given a string with alphabets, find all substrings, call it set A. Now find all unique substrings, call it B.
            In set A, calculate the sum of unique alphabets in each substring, call it sum(A). Now calculate the sum of unique
            alphabets in each substring in set B, call it sum(B). Print difference of sum(A) and sum(B).

            For example: given String aabb

            set A: {a, a, b, b, aa, bb, ab, ba, aab, baa}
            sum(A) = 1 + 1 + 1 + 1 + 1 + 1 + 2 + 2 + 2 + 2 = 14

            set B: {a, b, aa, bb, ab, ba, aab, baa}
            sum(B) = 1 + 1 + 1 + 1 + 2 + 2 + 2 + 2 = 12

            Ans is |sum(A) - sum(B)| = |14-12| = 2
         */
    public static class SumOfSubSet {

        public static void main(String[] args) {
            String input = "1123";
            int index = 0;
            String current = "";

            List<String> setA = subSet(input, index, current, new ArrayList<>(), false);
            List<String> setB = subSet(input, index, current, new ArrayList<>(), true);

            int sumSetA = setA.stream().mapToInt(w -> w.length()).sum();
            int sumSetB = setB.stream().mapToInt(w -> w.length()).sum();

            System.out.println(" Answer is:  " + (sumSetA - sumSetB));
        }

        private static List<String> subSet(String input, int index, String current, List<String> subsets, boolean distinct) {
            int len = input.length();
            if (index == len) {
                if (!subsets.contains(current) || !distinct) {
                    subsets.add(current);
                }
                return subsets;
            }
            subSet(input, index + 1, current + input.charAt(index), subsets, distinct);
            subSet(input, index + 1, current, subsets, distinct);

            return subsets;
        }
    }
}
