package microsoft_online_test;

public class Test3 {

    public static void main(String[] args) {

        // ********************* Microsoft online test ************************
        String str = "bab??a";
        // "?ab??a"
        // ?a?
        char[] s = str.toCharArray();
        System.out.println(smallestPalindrome(s));
        // ********************* Microsoft online test ************************
    }

    static boolean isPossiblePalindrome(char str[]) {
        int n = str.length;
        for (int i = 0; i < n / 2; i++) {
            if (str[i] != '?' &&
                    str[n - i - 1] != '?' &&
                    str[i] != str[n - i - 1])
                return false;
        }
        return true;
    }

    static String smallestPalindrome(char str[]) {
        if (!isPossiblePalindrome(str))
            return "NO";

        int n = str.length;
        for (int i = 0; i < n; i++) {
            if (str[i] == '?') {
                if (str[n - i - 1] != '?')
                    str[i] = str[n - i - 1];
                else
                    str[i] = str[n - i - 1] = 'a';
            }
        }

        String value = "";
        for(int i = 0; i < n; i++)
            value = value + str[i] + "";

        return value;
    }
}
