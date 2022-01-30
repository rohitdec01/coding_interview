package leet_code;

import java.util.*;

public class TimeScheduler {

    public static void main(String[] args) {
        int[][] slots1 = {{10,12},{16,17},{18,20}};
        int [][] slots2 = {{0,15},{60,70}} ;
        int duration = 8;

        // minAvailableDuration(slots1, slots2, duration);

         // int nums[] = {100, 100, -300, 100};
        int nums[] = {-100, 200, -400, 200};
        // int nums[] = {-100, -100, -300, 100, 600}; // 13
        // int nums[] = {-100, -100, -300, 100};
        System.out.println(process(nums));
    }

    private  static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b)-> a[0]-b[0]);
        Arrays.sort(slots2, (a,b)-> a[0]-b[0]);

        int p1 = 0;
        int p2 = 0;

        while (p1 < slots1.length && p2 < slots2.length) {
            int[] curr1 = slots1[p1];
            int[] curr2 = slots2[p2];

            int start = Math.max(curr1[0], curr2[0]);
            int end = Math.min(curr1[1], curr2[1]);

            if (end - start >= duration)
                return Arrays.asList(start,start+duration);
            else if (curr1[1] < curr2[1]) p1++;
            else if (curr2[1] < curr1[1]) p2++;
            else {
                p1++;
                p2++;
            }

        }
        return new ArrayList<>();
    }

    // Company: Nutanix
    private static int process( int[] nums) {
        // 100 100 -300 100 -> `6`

        // TODO: nums -- base condition
        int sum = 0; // 100
        int len = nums.length;
        int iteration = len;
        int position = -1;
        boolean bol = true;

        for (int i=0; i< len; i++) {

            sum += nums[i];

            if(sum < 0 && bol) {
                position = i;
                bol = false;
            }
        }

        if (sum >= 0 && position != -1) {
            iteration = iteration + (len -1  - position) * 2;
        }

        return iteration;
    }
}
