package leet_code;

import java.util.ArrayList;

class Pair {
    int first;
    int second;

    public Pair(int start, int second) {
        this.first = start;
        this.second = second;
    }
}

public class MergeIntervals {

    public static void main(String[] args) {
        ArrayList<Pair> v = new ArrayList<>();

        v.add(new Pair(1, 5));
        v.add(new Pair(3, 7));
        v.add(new Pair(4, 6));
        v.add(new Pair(6, 8));
        v.add(new Pair(10, 12));
        v.add(new Pair(11, 15));

        ArrayList<Pair> result = mergeIntervals(v);

        for (Pair pair : result) {
            System.out.print(String.format("[%d, %d] ", pair.first, pair.second));
        }
    }

    static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {

        if(v == null || v.size() == 0) {
            return null;
        }

        ArrayList<Pair> result = new ArrayList<>();

        result.add(new Pair(v.get(0).first, v.get(0).second));

        for(int i = 1 ; i < v.size(); i++) {
            int x1 = v.get(i).first;
            int y1 = v.get(i).second;
            int x2 = result.get(result.size() - 1).first;
            int y2 = result.get(result.size() - 1).second;

            if(y2 >= x1) {
                result.get(result.size() - 1).second = Math.max(y1, y2);
            } else {
                result.add(new Pair(x1, y1));
            }
        }
        return result;
    }
}
