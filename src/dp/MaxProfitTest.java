package dp;

public class MaxProfitTest {
	public static void main(String[] args) {
		int[] array = {2,3,4,1,4,1,5,9};
		int len = array.length;
		// dp[i][j]表示第i天买进j卖出的最大利润
		int[][] dp = new int[len][len];
		int max = 0; 
		for (int i =0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (array[j] > array[i]) {
					dp[i][j] = Math.max(array[j]- array[i], dp[i][j-1]);
				} else {
					dp[i][j] = dp[i][j-1];
				}
				if (max < dp[i][j]) {
					max = dp[i][j];
				}
			}
		}
		System.out.println("最大利润:" + max);
	}
}
