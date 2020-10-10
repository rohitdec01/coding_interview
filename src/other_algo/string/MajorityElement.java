package other_algo.string;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {

        Arrays.sort(nums);
        int priorityIndex = Math.abs((nums.length / 2));
        int priorityElement = nums[priorityIndex];
        for (int i = 0; i < nums.length - 1; i++) {
            priorityIndex--;
        }
        return priorityIndex < 0 ? priorityElement : -1;
    }
}
