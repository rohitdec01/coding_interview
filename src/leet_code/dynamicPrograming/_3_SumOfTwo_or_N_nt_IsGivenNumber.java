package leet_code.dynamicPrograming;

import java.util.Arrays;
import java.util.HashSet;

public class _3_SumOfTwo_or_N_nt_IsGivenNumber {

    /* Determine if the sum of two integers is equal to the given value */

    public static void main(String[] args) {
        int[] nums = {2, 4, 8, 15, 6};
        int target = 21;
        System.out.println( "*********  Return array if the sum if available for 2 numbers ***********");
        System.out.println(Arrays.toString(sumOfTwoNumbersIsEqualToGivenValue(nums, target)));
        System.out.println(Arrays.toString(sumOfTwoNumbersIsEqualToGivenValue2(nums, target)));

        System.out.println( "*********  Return array if the sum if available for 3 numbers ***********");
        find3Numbers(nums, nums.length, target);
        System.out.println( "************************************** ***********");

// **********************************************************************************************

        System.out.println("******* recursive ********  true/false");
        System.out.println(sumOf_N_NumbersIsEqualToGivenValueRecursion(nums, nums.length, target));
        System.out.println("******* Dynamic programing ********  true/false");
        boolean[][] memory = new boolean[nums.length + 1][target + 1];
        System.out.println(sumOf_N_NumbersIsEqualToGivenValueDP(nums, nums.length, target, memory));
    }

    /* Time complexity O(n Square). Brute force Algo*/
    static int[] sumOfTwoNumbersIsEqualToGivenValue(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int remainingNumber = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (remainingNumber == nums[j]) {
                    return new int[]{remainingNumber, nums[i]};
                }
            }
        }
        throw new IllegalArgumentException("No match found");
    }

    /* Time complexity O(n) space complexity O(n)*/
    static int[] sumOfTwoNumbersIsEqualToGivenValue2(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int remainingNumber = target - nums[i];
            if (set.contains(remainingNumber)) {
                return new int[] {remainingNumber, nums[i]};
            }
            set.add(nums[i]);
        }
        throw new IllegalArgumentException("No match found");
    }

    // returns true if there is triplet
    // with sum equal to 'sum' present
    // in A[]. Also, prints the triplet
    static boolean find3Numbers(int A[], int arr_size, int sum) {
        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {
            // Find pair in subarray A[i+1..n-1]
            // with sum equal to sum - A[i]
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++) {
                if (s.contains(curr_sum - A[j])) {
                    System.out.printf("Triplet is", A[i], A[j], curr_sum - A[j]);
                    return true;
                }
                s.add(A[j]);
            }
        }

        // If we reach here, then no triplet was found
        return false;
    }


    public static boolean sumOf_N_NumbersIsEqualToGivenValueRecursion(int[] value, int len, int target) {
        if (len  == 0) {
            return false;
        }

        if (target == 0) {
            return true;
        }

        if (value[len - 1] <= target) {
            return sumOf_N_NumbersIsEqualToGivenValueRecursion(value, len - 1, target - value[len -1]) ||
                    sumOf_N_NumbersIsEqualToGivenValueRecursion(value,len - 1, target);
        }
        return sumOf_N_NumbersIsEqualToGivenValueRecursion(value,len - 1, target);
    }

    public static boolean sumOf_N_NumbersIsEqualToGivenValueDP(int[] value, int len, int target, boolean[][] memory) {
        // int[] value = {2, 4, 8, 15, 6}; // 21
        for(int i = 0; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 || j ==0) {
                    if (i == 0) {
                        memory[i][j] = false;
                    } if (j == 0) {
                        memory[i][j] = true;
                    }
                } else if (value[i - 1] > j) {
                    memory[i][j] = memory[i - 1][j];
                } else {
                    memory[i][j] = memory[i - 1][j - value[i-1]] || memory[i -1][j];
                }
            }
        }
        return memory[len][target];
    }
}
