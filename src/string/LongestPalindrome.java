package string;

//Longest Palindromic Substring | Set 1
public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        longestPalindrome(str);
    }

    private static void longestPalindrome(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        boolean table[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                table[i][i + 1] = true;
            }
        }
        for (int i = 3; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int k = i + j;
                if (table[j + 1][k - 1] && chars[j] == chars[k]) {
                    table[j][k] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(table[i][j]){
                    System.out.println(str.substring(i,j+1));
                }
            }
        }

    }
}
