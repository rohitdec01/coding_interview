package amazon;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
Problem:
    Having an array of integers and a number X, find all pairs of integers in the array which have difference equal
    to the number X.

    e.g. {2,4,6,8,10} x = 6
    2+6 = 8 yes  -- 2,8
    4+6 = 10 yes -- 4,10
    6+6 = 12 No
    8+6 = 14 No
    10+6 = 16 No
 */
public class ArrayPairDifference {
    public static void main(String[] args) {
        //int[] intArray = new int[]{2, 4, 6, 8, 10};
        int[] intArray = new int[]{2, 8, 4, 6, 2, 10, 4, 8, 8};
        //int[] intArray = new int[]{1, 4, 45, 6, 10, 8};
        int x = 6;
        System.out.println("====== 1st ============");
        findPairs(intArray, x);
        System.out.println("====== 2nd =================");
        findPairs2(intArray, x);
    }

    // O(nSquare)
    // To avoid Duplicates Need more checks.
    private static void findPairs(int[] intArray, int x) {
        for (int i : intArray) {
            int sum = i + x;
            if (IntStream.of(intArray).anyMatch(val -> val == sum)) {
                System.out.println(i + "   " + sum);
            }
        }
    }

    // To avoid Duplicates Need more checks.
    private static void findPairs2(int[] intArray, int x) {
        // test:  int[] intArray = new int[]{2, 8, 4, 6, 2, 10, 4};
        Arrays.sort(intArray);

        int i = 0;
        int j = 0;
        int n = intArray.length;

        while (i < n && j < n) {
            if (intArray[j] - intArray[i] > x) {
                i++;
            } else if (intArray[j] - intArray[i] < x) {
                j++;
            } else {
                System.out.println(intArray[j] + ", " + intArray[i]);
                i++;
                j++;
            }
        }
    }
}
