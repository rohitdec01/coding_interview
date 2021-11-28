package amazon;

public class MissingNumberInTheArray {

    /* Find the missing number in the array*/
    public static void main(String[] args) {

        System.out.println("MIssng number from N numbers starting from 1.");
        int[] array = {1, 2, 4, 5};
        int len = array.length;
        if (len < 2) {
            System.out.println("No missing number.");
        } else {
            System.out.println(find_missing(array, len));
            System.out.println(xorMethod(array, len));
        }
    }

    /* Time complexity O(1)
       With this aproach there is a problem of max integer length.
     */
    static int find_missing(int[] nums, int len) {

        int total = 0;
        for (int i = 0; i < len; i++) {
            total += nums[i];
        }
        return (len + 1) * (len + 2) / 2 - total;
    }

    /* This is better because there will be no problem of max integer value with this approach
       Time complexity O(1)*/
    static int xorMethod(int[] nums, int len) {
        int x1 = nums[0];
        int x2 = 1;

        for (int i = 1; i < len; i++)
            x1 = x1 ^ nums[i];

        for (int i = 2; i <= len + 1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2);
    }

}
