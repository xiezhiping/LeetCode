package dp;

import java.util.Scanner;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str1 = sc.next(); // 获取以空格分割的字符串
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
				if ( i < 1) { // 第一行
					if (str1[0] == str2[j] || str1[0] == str2[0]) { // 边界值容易错
						dp[i][j] = 1;
					} else {
						dp[i][j] =0;
					}
				} else if (j < 1) { // 第一列
					if (str1[i] == str2[j] || str2[0] == str1[0] || dp[i-1][0] == 1) {
						dp[i][j] = 1;
					} else {
						dp[i][j] =0;
					}
				} else { // m、n大于等于1的情况
					if (str1[i] == str2[j]) {
						dp[i][j] = dp[i-1][j-1] + 1; // 先加入的两个字符相等的情况
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // 不等的情况取左边格子、上边格子两个中的较大值
					}
				}
				
			}
		}
		return dp[m-1][n-1];
	}
}
