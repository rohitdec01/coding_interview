package other_algo.string;

import java.util.HashSet;

/*
    You are given a dictionary of words and a large input string. You have to find out whether the input string
    can be completely segmented into the words of a given dictionary. The following two examples elaborate on the
    problem further.

https://www.educative.io/m/string-segmentation
 */
public class StringSegmentation {

    public static void main(String[] argu) {
        String lookup = "applepie";
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("apple");
        dictionary.add("pear");
        dictionary.add("pier");
        dictionary.add("pie");

        System.out.println(segmentedString(lookup, dictionary));
    }

    private static boolean segmentedString(String lookup, HashSet<String> dictionary) {

        for (int i = 0; i < lookup.length(); i++) {
            String subSet = lookup.substring(0, i);
            if (dictionary.contains(subSet)) {
                String subSet2 = lookup.substring(i);

                if (subSet2 == null || subSet2.length() == 0 || dictionary.contains(subSet2) ||
                        segmentedString(subSet2, dictionary)) {
                    return true;
                }
            }
        }
        return false;
    }

}
