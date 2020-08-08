package other_algo.string;

/*
    Given a sorted array of integers, return the low and high index of the given key.
    You must return -1 if the indexes are not found.
    e.g. {2,4,5,5,5,7,8,9,9,9};
        key: 5, low = 2 and high = 4
        key: 6, low = -1 and high = -1
        key: 7, low = 5 and high = 5

    Note: Binary Search will be hte best searching algo here.

 */
public class FindLowHighIndex {
    public static void main(String[] args) {
        int[] input = {2, 4, 5, 5, 5, 7, 8, 9, 9, 9};
        int target = 5;

        System.out.println("Lower Index    " + findLowerIndex(input, target));
        System.out.println("High Index    " + findHigherIndex(input, target));

    }

    // Using Binary Search O(logn)
    private static int findLowerIndex(int[] input, int target) {
        int index = -1;
        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target <= input[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            if (input[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    // Using Binary Search O(logn)
    private static int findHigherIndex(int[] input, int target) {
        int index = -1;
        int start = 0;
        int end = input.length - 1;

        /*int[] input = {2, 4, 5, 5, 5, 7, 8, 9, 9, 9};
        int target = 5;*/

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target >= input[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if (target == input[mid]) {
                index = mid;
            }
        }
        return index;
    }

}
