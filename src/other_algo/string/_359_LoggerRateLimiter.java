package other_algo.string;

import java.util.HashMap;
import java.util.Map;

public class _359_LoggerRateLimiter {

    /*

    359. Logger Rate Limiter
Easy

Add to List

Share Design a logger system that receives a stream of messages along with their timestamps. Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).

All messages will come in chronological order. Several messages may arrive at the same timestamp.

Implement the Logger class:

Logger() Initializes the logger object.
bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp, otherwise returns false.


Input
["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
[[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
Output
[null, true, true, false, false, false, true]

     */

    static Map<String, Integer> map = new HashMap<>(); // msg : lst print timestamp
    static int limiter = 10;

    public static void main(String[] args) {
        System.out.println(shouldPrintMessage(1, "foo"));
        System.out.println(shouldPrintMessage(2, "bar"));
        System.out.println(shouldPrintMessage(3, "foo"));
        System.out.println(shouldPrintMessage(8, "bar"));
        System.out.println(shouldPrintMessage(10, "foo"));
        System.out.println(shouldPrintMessage(11, "foo"));
    }

    public static boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }else{
            if(timestamp - map.get(message) >= limiter){
                map.put(message, timestamp);
                return true;
            }
        }

        return false;
    }
}
