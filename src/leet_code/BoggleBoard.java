package leet_code;

public class BoggleBoard {

    /*
    DFS

    Boggle (Find all possible words in a board of characters) | Set 1
    Difficulty Level : Hard
    Last Updated : 27 Sep, 2021
    Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character.
    Find all possible words that can be formed by a sequence of adjacent characters.
    Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.
    Example:


    Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
    boggle[][]   = {{'G', 'I', 'Z'},
        {'U', 'E', 'K'},
        {'Q', 'S', 'E'}};
    isWord(str): returns true if str is present in dictionary
                   else false.

    Output:  Following words of dictionary are present
    GEEKS
            QUIZ


            NOte: problem with this aproach that one world will be printed multiple times.
            */


    // Let the given dictionary be following
    static final String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GUQ", "EE", "text"};
    static final int n = dictionary.length;
    static final int M = 3, N = 3;

    // Driver program to test above function
    public static void main(String args[]) {
        char boggle[][] = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}
        };

        System.out.println("Following words of dictionary are present");
        findWords(boggle);
    }

    // Prints all words present in dictionary.
    static void findWords(char boggle[][]) {
        // Mark all characters as not visited
        boolean visited[][] = new boolean[M][N];

        // Initialize current string
        String str = "";

        // Consider every character and look for all words
        // starting with this character
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                findWordsUtil(boggle, visited, i, j, str);
    }

    // A recursive function to print all words present on boggle
    static void findWordsUtil(char boggle[][], boolean visited[][], int i,
                              int j, String str) {
        // Mark current cell as visited and append current character
        // to str
        visited[i][j] = true;
        str = str + boggle[i][j];

        // If str is present in dictionary, then print it
        if (isWord(str))
            System.out.println(str);

        // Traverse 8 adjacent cells of boggle[i][j]
        for (int row = i - 1; row <= i + 1 && row < M; row++)
            for (int col = j - 1; col <= j + 1 && col < N; col++)
                if (row >= 0 && col >= 0 && !visited[row][col])
                    findWordsUtil(boggle, visited, row, col, str);

        // Erase current character from string and mark visited
        // of current cell as false
        str = "" + str.charAt(str.length() - 1);
        visited[i][j] = false;
    }

    // A given function to check if a given string is present in
    // dictionary. The implementation is naive for simplicity. As
    // per the question dictionary is given to us.
    static boolean isWord(String str) {
        // Linearly search all words
        for (int i = 0; i < n; i++)
            if (str.equals(dictionary[i]))
                return true;
        return false;
    }
}
