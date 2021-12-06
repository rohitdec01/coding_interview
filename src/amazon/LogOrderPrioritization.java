package amazon;

import java.util.Arrays;

public class LogOrderPrioritization {
    /*Requirements
     *  1. Letter logs come first than digits log. (Id should not involved here)
     * 2. Letter log sorted lexicographically.
     * 3. When letter logs are equal sort by id (id is un till first space) lexicographically.
     * 4. Digits log should maintain their order.
     *
     * e.g.  [id1 this is log1, id2 thi is log2, id 10, id2 thi is log2]
     * */
    public static void main(String[] args) {
        String [] logs = {"id1 this is log1", "id2 thi is log2", "id3 10", "id4 thi is log2"};
        String [] output = logOrder(logs);
        for (String log: output) {
            System.out.println(log);
        }
    }

    private static String[] logOrder(String[] logs) {

        Arrays.sort(logs, (log1, log2) -> {
            int index1 = log1.indexOf(" ");
            String id1 = log1.substring(0, index1);
            String mainLog1 = log1.substring(index1 + 1);
            boolean isDigit1 = Character.isDigit(mainLog1.charAt(0));

            int index2 = log2.indexOf(" ");
            String id2 = log2.substring(0, index2);
            String mainLog2 = log2.substring(index2 + 1);
            boolean isDigit2 = Character.isDigit(mainLog2.charAt(0));

            if (!isDigit1 && !isDigit2 ) {
                int value = mainLog1.compareTo(mainLog2);
                if (value == 0) return id1.compareTo(id2);
                return value;
            }

            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}
