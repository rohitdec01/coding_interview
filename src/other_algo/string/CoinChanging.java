package other_algo.string;

import java.util.Arrays;

/*
    Suppose we have coin conins of [1, 2, 5] and the total amount is 7. We can make changes in the
    following 6 ways:

    1,1,1,1,1,1,1
    1,1,1,1,1,2
    1,1,1,2,2
    1,2,2,2
    1,1,5
    2,5
 */
public class CoinChanging {

    public static void main(String[] args) {
        int[] conins = new int[]{1, 2, 5};
        int amount = 7;
        int result = solveCoinChange(conins, amount);
        System.out.print("SolveCoinChange(" + Arrays.toString(conins) + ", " + amount + ") = ");
        System.out.print(result);

    }

    /*
          This will be solve using dynamic programming.
          1. create an array with length = amount + 1
          2. Set the first array value with '1'
          3. Take first coin and iteration will start from coin position and upto end of the array.
          4. take the previous value of i position and add i - coin position value and update i position in array.
          5. Repeat the process upto number of coins and last position value will be the answer.
     */
    static int solveCoinChange(int[] coins, int amount) {
        int[] solution = new int[amount + 1];
        solution[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < solution.length; i++) {
                solution[i] += solution[i - coin];
            }
        }
        return solution[amount];
    }

}
