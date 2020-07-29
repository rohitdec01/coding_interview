package other_algo.string;

import java.util.ArrayList;
import java.util.List;

/*
    Given a set of ‘n’ elements, find their Kth permutation (e.g. 4th) Consider the following set of elements:
    e.g. n=3 => 1 2 3

    permutation
    (1)123     (3)213     (5)312
    (2)132     (4)231     (6)321

    Output (4)231

    Explanation: https://www.youtube.com/watch?v=W9SIlE2jhBQ
 */
public class kthPermutation {

    public static void main(String[] args) {
        /*for (int k = 1; k <= factorial(4); ++k) { // Number of permutation is factorial(4) = 24
            System.out.println(k + "th permutation = \t" + get_permutation(4, k));
        }*/

        System.out.println("23rd permutation = \t" + get_permutation(4, 23));
    }

    static String get_permutation(int n, int k) { // 4,23 --iteration
        List<Character> v = new ArrayList<Character>();
        char c = '1';
        for (int i = 1; i <= n; ++i) {
            v.add(c);
            c++;
        }

        StringBuilder result = new StringBuilder();
        find_kth_permutation(v, k, result);
        return result.toString();
    }

    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    static void find_kth_permutation(List<Character> v, int k, StringBuilder result) {
        if (v.isEmpty()) {
            return;
        }
        if (v.size() == 1) {
            result.append(v.get(0));
            return;
        }

        int size = v.size();
        int fac = factorial(size - 1);
        int selectedGroup = (k - 1) / fac;

        result.append(v.get(selectedGroup));
        v.remove(selectedGroup);

        k = k - (fac * selectedGroup);
        find_kth_permutation(v, k, result);
    }

}
