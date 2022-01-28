package leet_code;

import java.util.Arrays;
import java.util.HashMap;

public class SumOfTwoInt_IsGivenNumber {

    /* Determine if the sum of two integers is equal to the given value */

    public static void main(String[] args) {
        int[] nums = {2, 4, 8, 15, 6};
        int target = 21;
        System.out.println(Arrays.toString(sumofTwoNumbersIsEqualToGivenValue(nums, target)));
        System.out.println(Arrays.toString(sumofTwoNumbersIsEqualToGivenValue2(nums, target)));
    }

    /* Time complexity O(n Square). Brute force Algo*/
    static int[] sumofTwoNumbersIsEqualToGivenValue(int[] nums, int target) {
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
    static int[] sumofTwoNumbersIsEqualToGivenValue2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainingNumber = target - nums[i];
            if (map.containsKey(remainingNumber)) {
                return new int[] {remainingNumber, nums[i]};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No match found");
    }
}
