package other_algo.string;

import java.util.Arrays;

/*
1. Maximum difference between two elements.
e.g.
Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 9
Explanation : The maximum difference is between 10 and 1.

2. Maximum difference between two elements. such that larger element appears after the smaller number

e.g. Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.
 */
public class MaxDifference {

    public static void main(String[] args) {

        int[] integerArray = {2, 3, 10, 6, 4, 8, 1};
        if (integerArray != null && integerArray.length > 1) {
            System.out.println("Problem 2:  " + maxDifferenceProblem2(integerArray));
            System.out.println("Problem 1:  " + maxDifferenceProblem1(integerArray));
        }
    }

    private static int maxDifferenceProblem1(int[] integerArray) {
        Arrays.sort(integerArray);
        return integerArray[integerArray.length - 1] - integerArray[0];
    }

    private static int maxDifferenceProblem2(int[] integerArray) {
        // Test: int[] integerArray = {2, 3, 10, 6, 4, 8, 1};
        int n = integerArray.length;

        int diff = integerArray[1] - integerArray[0];
        int curr_sum = diff;
        int max_sum = curr_sum;

        for (int i = 1; i < n - 1; i++) {
            diff = integerArray[i + 1] - integerArray[i];
            if (curr_sum > 0)
                curr_sum += diff;
            else
                curr_sum = diff;

            if (curr_sum > max_sum)
                max_sum = curr_sum;
        }

        return max_sum;
    }
}
