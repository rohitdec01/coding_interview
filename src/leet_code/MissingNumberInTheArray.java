package leet_code;

public class MissingNumberInTheArray {

    /* Find the missing number in the array*/
    public static void main(String[] args) {

        System.out.println("MIssng number from N numbers starting from 1.");
        int[] array = {1, 2, 4, 5};
        int[] array1 = {1, 2, 4, 5,7};
        int len = array.length;
        if (len < 2) {
            System.out.println("No missing number.");
        } else {
            // System.out.println(find_missing(array, len));
            System.out.println(xorMethod(array, len));

            findTwoMissingNumbers(array1, array1.length);
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

    static void findTwoMissingNumbers(int arr[], int n)
    {
        int XOR = arr[0];
        for (int i = 1; i < n; i++)
            XOR ^= arr[i];
        for (int i = 1; i <= n+2; i++)
            XOR ^= i;

        // Now XOR has XOR of two missing elements.
        // Any set bit in it must be set in one missing
        // and unset in other missing number

        // Get a set bit of XOR (We get the rightmost
        // set bit)
        int set_bit_no = XOR & ~(XOR-1);

        // Now divide elements in two sets by comparing
        // rightmost set bit of XOR with bit at same
        // position in each element.
        int x = 0, y = 0; // Initialize missing numbers
        for (int i = 0; i < n; i++)
        {
            if ((arr[i] & set_bit_no) > 0)

                /*XOR of first set in arr[] */
                x = x ^ arr[i];
            else
                /*XOR of second set in arr[] */
                y = y ^ arr[i];
        }

        for (int i = 1; i <= n+2; i++)
        {
            if ((i & set_bit_no)>0)

                /* XOR of first set in arr[] and
                   {1, 2, ...n }*/
                x = x ^ i;
            else
                /* XOR of second set in arr[] and
                    {1, 2, ...n } */
                y = y ^ i;
        }

        System.out.println("Two Missing Numbers are ");
        System.out.println( x + " " + y);
    }

}
