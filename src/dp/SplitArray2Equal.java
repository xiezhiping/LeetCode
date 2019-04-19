package dp;

import java.util.Scanner;

/**
 * 经典0,1背包问题的变体：将给定的数组拆分为两个非空数组，要求两个子数组的和相等
 * @author xzp
 *思路：
 *首先两个子数组的和一定是总和的一半
 *还有一种变体：两个数组的差最小，其实跟这个是一个道理。
 *
 */
public class SplitArray2Equal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] strings = s.split(" ");
		int len = strings.length;
		int[] arr1 = new int[len];
		int total = 0;
		for(int i = 0; i < len; i++) {
			arr1[i] = strings[i].charAt(0) - '0';
			total += arr1[i];
		}
		int half = total/2;
		int[][] dp = new int[len+1][half + 1]; // dp[i][j]表示只有前i件物品时，装入容量j的背包的最大策略
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= half; j++) {
				if (j >= arr1[i -1]) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr1[i - 1]] + arr1[i - 1]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		if (total == dp[len][half] * 2) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
	
}
