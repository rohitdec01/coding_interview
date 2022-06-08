package leet_code.backtTacking;

public class _0_NQueenProblem {

    public static void main(String args[]) {
        int board[][] = {
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 }
        };
        solveNQUtil(board, 0);
        printSolution(board);
    }

    /* A recursive utility function to solve N Queen problem */
    private static boolean solveNQUtil(int board[][], int col) {
        int len = board.length;
        /* base case: If all queens are placed then return true */
        if (col >= board.length) {
            return true;
        }

        /* Consider this column and try placing this queen in all rows one by one */
        for (int row = 0; row < len; row++) {
            /* Check if the queen can be placed on board[i][col] */
            if (isSafe(board, row, col)) {
                /* Place this queen in board[i][col] */
                board[row][col] = 1;

                /* recur to place rest of the queens */
                if (solveNQUtil(board, col + 1) == true) {
                    return true;
                }
                /* If placing queen in board[row][col] doesn't lead to a solution then remove queen from board[row][col] */
                board[row][col] = 0; // BACKTRACK
            }
        }

        /* If the queen can not be placed in any row in this column col, then return false */
        return false;
    }

    /* A utility function to check if a queen can be placed on board[row][col]. Note that this function is called
    when "col" queens are already placed in columns from 0 to col -1. So we need to check only left side for attacking
    queens  */
    private static boolean isSafe(int board[][], int row, int col) {
        int len = board.length;
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < len; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    /* A utility function to print solution */
    private static void printSolution(int board[][]) {
        int len = board.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }
}
