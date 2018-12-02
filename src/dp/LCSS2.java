package dp;

import java.util.Scanner;

public class LCSS2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str1 = sc.next();
			String str2 = sc.next();
			System.out.println(length(str1.toCharArray(), str2.toCharArray()));
		}
	}
	private static int length(char[] str1, char[] str2) {
		int m = str1.length;
		int n = str2.length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m;i++) {
			for (int j = 0;j < n; j++) {
				if ( i < 1) {
					if (str1[0] == str2[j] || str1[0] == str2[0]) {
						dp[i][j] = 1;
					} else {
						dp[i][j] =0;
					}
				} else if (j < 1) {
					if (str1[i] == str2[j] || str2[0] == str1[0] || dp[i-1][0] == 1) {
						dp[i][j] = 1;
					} else {
						dp[i][j] =0;
					}
				} else {
					if (str1[i] == str2[j]) {
						dp[i][j] = dp[i-1][j-1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
				
			}
		}
		return dp[m-1][n-1];
	}
}
