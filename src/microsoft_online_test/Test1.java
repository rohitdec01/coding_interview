package microsoft_online_test;

public class Test1 {

    public static void main(String[] args) {
        System.out.println(abc());
    }

    private static boolean abc() {
        String S = "ba1";
        String T = "1Ad";
        int len1 = 0;
        int len2 = 0;

        String[] parts1 = S.split("[^\\d]+");
        String[] parts2 = T.split("[^\\d]+");

        for(int i = 0; i < parts1.length; i++) {
            if(!parts1[i].equals("")){
                len1 += Integer.parseInt(parts1[i]);
            }
        }

        for(int i = 0; i < parts2.length; i++) {
            if(!parts2[i].equals("")){
                len2 += Integer.parseInt(parts2[i]);
            }
        }

        for(int i = 0; i < S.length(); i++) {
            if(!Character.isDigit(S.charAt(i))){
                len1 += 1;
            }
        }

        for(int i = 0; i < T.length(); i++) {
            if(!Character.isDigit(T.charAt(i))){
                len2 += 1;
            }
        }

        if(len2 != len1) {
            return false;
        }

        // Convert String S from "A2Le" to "A..Le"
        char[] sArray = S.toCharArray();
        char[] sArrayFiltered = new char[len1 + 1];
        int sIndex = 0;
        for(int i = 0; i < sArray.length; i++) {
            if(Character.isDigit(sArray[i])) {
                sIndex += Character.getNumericValue(sArray[i]);
                System.out.println("Digit Index: " + sIndex + ", Char: " + sArray[i] + ", Index: " + i);
            } else {
                sArrayFiltered[sIndex] = sArray[i];
                sIndex++;
                System.out.println("Char Index: " + sIndex + ", Char: " + sArray[i] + ", Index: " + i);
            }
        }
        return false;
    }
}
