package amazon;

import java.util.HashSet;

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
}
