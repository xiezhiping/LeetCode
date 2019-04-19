package temp;

public class Solution {
	public static void main(String[] args) {
		String[] strings = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strings));
	}
    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len < 2) {
            return strs[0]; 
        }
        String s = longestCommonPrefix(strs[0], strs[1]);
        for (int i = 2; i < len; i++) {
            s = longestCommonPrefix(s, strs[i]);
        }
        return s;
    }
    public static String longestCommonPrefix(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
//        String[][] dp = new String[len1 + 1][len2 + 1];
//        for (int i = 0; i <= len1; i++) {
//            dp[i][0] = "";
//        }
//        for (int i = 0; i <= len2; i++) {
//            dp[0][i] = "";
//        }
//        for (int i = 0; i < len1; i++) {
//            for (int j = 0; j < len2; j++) {
//                if (s1.charAt(i) == s2.charAt(j)) {
//                    dp[i + 1][j + 1] = dp[i][j] + s1.charAt(i);
//                } else {
//                    dp[i + 1][j + 1] = dp[i+ 1][j].length() > dp[i][j + 1].length() ? dp[i+ 1][j] : dp[i][j + 1];
//                }
//            }
//        }
//        return dp[len1][len2];
        String s = "";
        for (int i = 0; i < len1 && i < len2; i++) {
        	if (s1.charAt(i) == s2.charAt(i)) {
        		s += s1.charAt(i);
        	} else {
        		return s;
        	}
        }
        return s;
    }
}
