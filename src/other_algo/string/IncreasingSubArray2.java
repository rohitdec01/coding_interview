package other_algo.string;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubArray2 {

    public static void main(String[] args) {
        //int[] input = {7, 2, 5, 8, 6, 3, 9, 10};
        int[] input = new int[]{2, 7, 5, 8, 6, 3, 9, 10};
        System.out.println(getLongestInceasingSubarrays(input));
        /*int [] input2 = {1, 2, 1, 2, 5, 4, 5};
        System.out.println(getLongestInceasingSubarrays(input2));*/
    }

    public static int getLongestInceasingSubarrays(int[] nums) {
        // all subarrays with min, max and length
        List<Node> nodes = new ArrayList();

        int prevMinIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                addNodesSubarray(nodes, prevMinIndex, i - 1, nums);
                prevMinIndex = i;
            }
        }
        addNodesSubarray(nodes, prevMinIndex, nums.length - 1, nums);
        int maxLength = 0;

        for (int outer = 0; outer < nodes.size(); outer++) {
            for (int inner = outer + 1; inner < nodes.size(); inner++) {
                Node outerSubArr = nodes.get(outer);
                Node innerSubArr = nodes.get(inner);

                if (outerSubArr.max < innerSubArr.min) {
                    maxLength = Math.max(maxLength, outerSubArr.length + innerSubArr.length);
                }
            }
        }

        return maxLength;
    }

    private static void addNodesSubarray(List<Node> nodes, int start, int end, int[] nums) {
        for (int i = start; i <= end; i++) {
            for (int j = i; j <= end; j++) {
                Node node = new Node(nums[i], nums[j], j - i + 1);
                System.out.println(node.toString());
                nodes.add(node);
            }
        }
    }
}

class Node {
    int min;
    int max;
    int length;

    public Node(int min, int max, int length) {
        this.min = min;
        this.max = max;
        this.length = length;
    }

    public String toString() {
        return min + " " + max + " " + length;
    }
}
