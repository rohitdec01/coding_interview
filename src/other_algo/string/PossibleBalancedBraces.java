package other_algo.string;

import java.util.ArrayList;
import java.util.List;

/*
Print all braces combinations for a given value n so that they are balanced.
e.g.
    N=1 => {}
    N=2 => {{}}, {}{}
    N=3 => {{{}}}, {}{{}}, {{}{}}, {{}}{}, {}{}{}


    Solve this problem using backtracking.

 */
public class PossibleBalancedBraces {

    public static void main(String[] args) {
        int given = 3;
        List<String> result = new ArrayList<>();
        printAllBacesUsingbackTracking(result, 0, 0, "", given);
        result.forEach(res -> System.out.println(res));
    }

    // Memory: Linear, O(n). Complexity: O(2^n)
    static void printAllBacesUsingbackTracking(List<String> result, int open, int close, String current, int max) {

        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max)
            printAllBacesUsingbackTracking(result, open + 1, close, current + "(", max);
        if (close < open)
            printAllBacesUsingbackTracking(result, open, close + 1, current + ")", max);
    }

}
