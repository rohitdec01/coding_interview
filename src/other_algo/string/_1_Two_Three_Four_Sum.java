package other_algo.string;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _1_Two_Three_Four_Sum {

   /* Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]
    */
    public static void main(String[] args) {
        int [] array = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(array, 9)));
        // System.out.println(twoSum2(array, 9));
        System.out.println(Arrays.toString(twoSum3(array, 9)));

        int [] array1 = {-1,0,1,2,-1,-4};
        System.out.println(threeSum1(array1, -2).stream().flatMap(a -> a.stream()).collect(Collectors.toList()));
    }

    // Time complexity: O(nsquare)
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    // Time complexity: O(n).  Space complexity: O(n)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    // Time complexity: O(n).  Space complexity: O(1) ------------ Input Array Is Sorted
    private static int[] twoSum3(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];

            if (sum == target) {
                return new int[] {low, high};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        // In case there is no solution, return {-1, -1}.
        return null;
    }

    // *************************************************************

    // Time Complexity: O(nsquare)  // Space Complexity: O(n)
    public static List<List<Integer>> threeSum1(int[] nums, int target) {
        Arrays.sort(nums); // Sorting the array takesO(nlogn)
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, result, target);
            }
        return result;
    }

    static void twoSumII(int[] nums, int i, List<List<Integer>> result, int target) {
        int low = i + 1, high = nums.length - 1;
        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if (sum < target) {
                ++low;
            } else if (sum > target) {
                --high;
            } else {
                result.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                while (low < high && nums[low] == nums[low - 1])
                    ++low;
            }
        }
    }

    // No-Sort  // Time Complexity: O(nsquare) // Space Complexity: O(n)
    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (duplicate.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList(result);
    }
}
