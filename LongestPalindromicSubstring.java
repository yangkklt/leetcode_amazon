public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int n = s.length();
        boolean[][] flag = new boolean[n][n];
        int index = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j || (i - j == 1 && s.charAt(i) == s.charAt(j)) || (i - j > 1 && s.charAt(i) == s.charAt(j) && flag[j + 1][i - 1])) {
                    flag[j][i] = true;
                    if (i - j + 1 > max) {
                        index = j;
                        max = i - j + 1;
                    }
                }  else {
                        flag[j][i] = false;
                }
            }
        }
        return s.substring(index, index + max);
    }
}