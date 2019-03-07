package bfs;

public class JumpGame {
	public static void main(String[] args) {
		int[] array = {2, 3, 1, 1, 4};
		System.out.println(jump(array));
	}
	public static int jump(int[] A) {
		int len = A.length;
		int[] dp = new int[len]; // dp��ŵ��������С����
		for (int i = 0; i < len;i++) {
			int maxP = Math.min(i + A[i], len - 1); // ��i��������ߵ���Զ����
			for (int j = i + 1; j <= maxP; j++) {
				if (dp[j] == 0) {
					dp[j] = dp[i] + 1;
				}
			}
			if (dp[len - 1] != 0) break;
		}
		return dp[len -1];
	}
}
