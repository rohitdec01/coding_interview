package other_algo.string;

/*
Search for a given number in a sorted array, with unique elements, that has been rotated by some arbitrary number.
Return -1 if the number does not exist.

e.g. {4, 8, 12, 18, 20, 21, 28, 38}

Given array=> { 28, 28, 4, 8, 12, 18, 20, 21}  target = 18
Note: It's sorted with a rotation from 28.
 */


public class SearchInSortedArray {

    public static void main(String[] args) {
        int[] givenArray = {28, 38, 4, 8, 12, 18, 20, 21};
        int target = 28;

        System.out.println("Index of target    " + findTarget(givenArray, target));
    }

    /*
        We have to resolve this problem i O(log n).
        Because this is sorted array and we have to solve that in O(log n) So,
           we can use Binary search. if we Observe here (the pattern).

        One of the either side from the mid value is in proper order.
     */
    private static int findTarget(int[] givenArray, int target) {
        int index = -1;
        int start = 0;
        int end = givenArray.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target == givenArray[mid]) {
                return mid;
            }
            if (givenArray[mid] >= givenArray[start]) {
                if (target <= givenArray[mid] && target >= givenArray[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= givenArray[mid] && target < givenArray[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return index;
    }


}
