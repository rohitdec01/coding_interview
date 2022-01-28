package leet_code.dynamicPrograming;

public class _4_TwoEqualSumInAnArray {

    public static void main(String[] args) {
        int[] nums = {2, 4, 8, 15, 6, 5};

        // Sum of all numbers.
        int sum = 0;
        for(int i=0;i< nums.length;i++) {
            sum += nums[i];
        }

        // Two Equal Sum from an array is possible or not.
        if(sum % 2 == 0) {
            // using recursion.
            System.out.println(
                    _3_SumOfTwo_or_three_Int_IsGivenNumber.sumOfTwoNumbersIsEqualToGivenValueRecursion(nums, nums.length, sum/2));

            // using DP.
            boolean[][] memory = new boolean[nums.length + 1][sum/2 + 1];
            System.out.println(
                    _3_SumOfTwo_or_three_Int_IsGivenNumber.sumOfTwoNumbersIsEqualToGivenValueDP(nums, nums.length, sum/2, memory));
        } else { // if sum is odd then two equal sum is not possible in an array.
            System.out.println("false");
        }

    }
}
