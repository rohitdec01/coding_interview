package leet_code;

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
        List<Integer> subset1 = new ArrayList<>();
        powerSet(lst, 0, "", subset1);

        // ***************************************************
        List<List<Integer>> subset = new ArrayList<>();
        findSubsets(subset, lst, new ArrayList<>(), 0);

        // Printing Subset
       /* for(int i = 0; i < subset.size(); i++){
            for(int j = 0; j < subset.get(i).size(); j++){
                System.out.print(subset.get(i).get(j) + " ");
            }
            System.out.println();
        }*/
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

    // O(2^n*n) for Time and space complexity.
    public static void findSubsets(List<List<Integer>> subset, List<Integer> nums, ArrayList<Integer> output, int index) {
        // Base Condition
        if (index == nums.size()) {
            subset.add(output);
            return;
        }

        // Not Including Value which is at Index
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);

        // Including Value which is at Index
        output.add(nums.get(index));
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }
}
