package other_algo.string;

import java.util.Arrays;
import java.util.List;

/*
    We are given a set of integers and we have to find all the possible subsets of this set of integers.
    The following example elaborates on this further. e.g. 2 3 4
    Imp: 2 power 3 will be total subset here. formula of n subset is 2 power n

    Output:    empty       2       3       2,3     4       2,4        3,4      2,3,4
 */
public class FindAllSubset {

    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(1, 2, 3);
        int index = 0;
        String current = "";
        powerSet(lst, index, current);
    }

    private static void powerSet(List<Integer> lst, int index, String current) {
        int len = lst.size();
        if (index == len) {
            System.out.println("{" + current + "}");
            return;
        }

        powerSet(lst, index + 1, current + lst.get(index));
        powerSet(lst, index + 1, current);
    }
}
