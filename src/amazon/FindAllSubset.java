package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    We are given a set of integers and we have to find all the possible subsets of this set of integers.
    The following example elaborates on this further. e.g. 2 3 4
    Imp: 2 power 3 will be total subset here. formula of n subset is 2 power n

    Output:    empty       2       3       2,3     4       2,4        3,4      2,3,4

    Solve this problem using backtracking.
 */
public class FindAllSubset {

    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(1, 1, 2, 3);
        int index = 0;
        List<Integer> subsets = new ArrayList<>();
        String current = "";
        powerSet(lst, index, current, subsets);
        // System.out.println("test   " + powerSet(lst, index, current, subsets) );

    }

    // O(2^n*n) for Time and space complexity.
    private static List<Integer>  powerSet(List<Integer> lst, int index, String current, List<Integer> subsets) {
        int len = lst.size();
        if (index == len) {
            System.out.println("{" + current + "}");
            subsets.add(current.length());
            return subsets;
        }

        powerSet(lst, index + 1, current + lst.get(index), subsets);
        powerSet(lst, index + 1, current, subsets);

        return subsets;
    }
}
