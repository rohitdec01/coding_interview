package chapter1;

public class Problem2 {
    /*     Reverse of a c-Style string e.g abcd (IN java there is no null character
    at the end of the String but in C language its there)*/
    public static void main(String[] args) {
        System.out.println("Using Pointer -- " + reverse1("rohit"));
        System.out.println("Using Recursion -- " + reverse2("rohit"));
    }

    // Using pointer method
    private static String reverse1(String str) {
        if (str.isEmpty()) {
            return str;
        }
        int len = str.length();
        int pointer1 = 0;
        int pointer2 = len - 1;
        char[] charInput = str.toCharArray();

        while (pointer1 < pointer2) {
            char temp = charInput[pointer1];
            charInput[pointer1] = charInput[pointer2];
            charInput[pointer2] = temp;
            pointer1++;
            pointer2--;
        }

        return new String(charInput);
    }

    // Using Recursion
    private static String reverse2(String str) {
        if (str.isEmpty()) {
            return str;
        }
        int len = str.length();
        return str.charAt(len - 1) + reverse2(str.substring(0, len));
    }
}
