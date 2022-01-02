package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeScheduler {

    public static void main(String[] args) {
        int[][] slots1 = {{10,12},{16,17},{18,20}};
        int [][] slots2 = {{0,15},{60,70}} ;
        int duration = 8;

        minAvailableDuration(slots1, slots2, duration);
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
}
