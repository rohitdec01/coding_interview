package leet_code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _001_TwoSums {
    /*Given an array of integers, return indices of the two numbers
    such that they add up to a specific target.*/

    public static void main(String[] args) {
        int[] nums = {2, 8, 17, 7};
        int target = 9;
        System.out.println(Arrays.toString(twoSum1(nums, target)));
    }

    //Approach 1: Brute Force
    //O(n power 2)
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // Time complexity O(n) and space complexity O(n)
    private static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int secondNumber = target - nums[i];
            if (map.containsKey(secondNumber) && map.get(secondNumber) != i) {
                return new int[] {i, map.get(secondNumber)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution.");
    }
}
