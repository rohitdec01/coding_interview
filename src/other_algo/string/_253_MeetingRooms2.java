package other_algo.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _253_MeetingRooms2 {
    /*
    Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

    Example 1:
        Input: intervals = [[0,30],[5,10],[15,20]]
        Output: 2
    Example 2:
        Input: intervals = [[7,10],[2,4]]
        Output: 1
     */

    public static void main(String[] args) {
        int[][] intervals = {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
        System.out.print(minMeetingRooms2(intervals));
    }

    public static int minMeetingRooms2(int[][] intervals) {
        // Min heap
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
            intervals.length,
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return a - b;
                }
            });

        // Sort array by start time.
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Add the first meeting
        queue.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= queue.peek()) {
                // if start time >= existing minimum end time.
                queue.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            queue.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return queue.size();
    }
}
