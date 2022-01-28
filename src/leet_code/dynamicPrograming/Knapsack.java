package leet_code.dynamicPrograming;

import java.util.Arrays;

public class Knapsack {

    /*Given N items, each item having a given weight Ci and a profit value Pi, the task is to maximize the profit
    by selecting a maximum of K items adding up to a maximum weight W.

    Examples:

    Input: N = 5, P[] = {2, 7, 1, 5, 3}, C[] = {2, 5, 2, 3, 4}, W = 8, K = 2.
    Output: 12
    Explanation:
    Here, the maximum possible profit is when we take 2 items: item2 (P[1] = 7 and C[1] = 5) and
    item4 (P[3] = 5 and C[3] = 3).
    Hence, maximum profit = 7 + 5 = 12
    Input: N = 5, P[] = {2, 7, 1, 5, 3}, C[] = {2, 5, 2, 3, 4}, W = 1, K = 2
    Output: 0
    Explanation: All weights are greater than 1. Hence, no item can be picked.*/

    public static void main(String[] args) {
        int value[] = {2, 7, 1, 5, 3};
        int weight[] = {2, 5, 2, 3, 4};
        int maxWeight = 8;

        System.out.println("RecursiveSol   " + napSackRecursiveSol(value, weight, value.length, maxWeight));
        System.out.println("****************************************" );

        int[][] memorizableMatrix = new int[value.length + 1][maxWeight + 1] ;
        for (int[] row: memorizableMatrix) {
            Arrays.fill(row, -1);
        }
        System.out.println("Recursive + Memorization Soln:   " + napSackRecursiveMemorizationSol(value, weight, value.length, maxWeight, memorizableMatrix ));
        System.out.println("****************************************" );

        int[][] memorizableMatrixForDP = new int[value.length + 1] [maxWeight + 1];
        System.out.println("Pure DP (TOP down Approach) Soln:   " + napSackRPureDP(value, weight, value.length, maxWeight, memorizableMatrixForDP));
    }

    private static int napSackRecursiveSol(int[] value, int[] weight , int len, int maxWeight) {
        if (maxWeight == 0 || len  == 0) {
            return 0;
        }

        if (weight[len - 1] <= maxWeight) {
            return Math.max(value[len -1] + napSackRecursiveSol(value, weight,  len - 1, maxWeight - weight[len -1]),
                    napSackRecursiveSol(value, weight,len - 1, maxWeight));
        }
        return napSackRecursiveSol(value, weight, len - 1, maxWeight);
    }

    private static int napSackRecursiveMemorizationSol(int[] value, int[] weight , int len, int maxWeight, int[][] memorizableMatrix) {
        if (maxWeight == 0 || len  == 0) {
            return 0;
        }

        if(memorizableMatrix[len][maxWeight] != -1) {
            return memorizableMatrix[len][maxWeight];
        }

        if (weight[len - 1] <= maxWeight) {
            return memorizableMatrix[len][maxWeight] = Math.max(value[len -1] + napSackRecursiveSol(value, weight,  len - 1, maxWeight - weight[len -1]),
                    napSackRecursiveSol(value, weight,len - 1, maxWeight));
        }
        return memorizableMatrix[len][maxWeight] = napSackRecursiveSol(value, weight, len - 1, maxWeight);
    }

    /*
    * Simple to write DP soln from recursion soln
    *
    * convert len = i and maxweight to j inside the method
    *
    * */
    private static int napSackRPureDP(int[] value, int[] weight , int len, int maxWeight, int[][] memorizableMatrixForDP) {

        for(int i = 0; i< len + 1 ; i++) {
            for (int j = 0; j< maxWeight + 1 ; j++) {
                if (i == 0 || j == 0) {
                    memorizableMatrixForDP[i][j] = 0;
                } else if (weight[i - 1] <= j) {
                    memorizableMatrixForDP[i][j] = Math.max(value[i -1] + memorizableMatrixForDP[i-1][j - weight[i-1]],
                            memorizableMatrixForDP[i-1][j]);
                } else {
                    memorizableMatrixForDP[i][j] = memorizableMatrixForDP[i-1][j];
                }
            }
        }
        return memorizableMatrixForDP[len][maxWeight];
    }
}
