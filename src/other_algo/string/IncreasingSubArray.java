package other_algo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Given a distinct array, find two increasing subarrays(say a and b ) such that when joined they produce one
    increasing array(say ab ). The subarray should be contiguous.
    The two subarray should not overlap

    For example: given array = [7 2 5 8 6 3 9 10]
    Two sub arrays are a = [2 5 8] , b = [9, 10] and ab = [2 5 8 9 10] Output: length(ab) = 5

    3 is not included in b because it is overlapping the subarray ‘a’.
 */
public class IncreasingSubArray {

    public static void main(String[] args) {
        int[] input = new int[]{7, 2, 5, 8, 6, 3, 9, 10};
        //int[] input = new int[]{2, 7, 5, 8, 6, 3, 9, 10};
        //int[] input = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        // int[] input = new int[]{4, 3, 2, 9};

        System.out.println(lengthOfLIS(input) +"");


       /* int indexVal = 0;
        int len = input.length;
        int index = len;

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i + 1 == len) {
                int firstListLength = firstList.size();
                if (firstListLength > 0 && (firstList.get(firstList.size() - 1)).intValue() < input[i]) {
                    firstList.add(input[i]);
                }
                break;
            }
            if (input[i] < input[i + 1]) {
                firstList.add(input[i]);
            } else {
                if (firstList.size() != 0) {
                    firstList.add(input[i]);
                    index = i;
                    indexVal = input[i];
                    break;
                }
            }
        }

        for (int i = index + 1; i < len; i++) {
            if (indexVal < input[i]) {
                secondList.add(input[i]);
                indexVal = input[i];
            }
        }

        System.out.println(firstList+ "   " + secondList);
        System.out.println("Size is:  " + (firstList.size() + secondList.size()));*/

    }

    public static int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0) { return 0; }
        int n = nums.length;

        Integer lis[] = new Integer[n];
        int max = 0;

    /* Initialize LIS values for all indexes */
    for ( int i = 0; i < n; i++ ) {
        lis[i] = 1;
    }

    /* Compute optimized LIS values in bottom up manner */
    for (int i = 1; i < n; i++ ) {
        for ( int j = 0; j < i; j++ )  {
            if ( nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                lis[i] = lis[j] + 1;
            }
        }
    }
    max = Collections.max(Arrays.asList(lis));
    return max;
}
}
