import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] array = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// ³õÊ¼»¯
				if (array[i][j] == 1) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = 0;
				}
				if (i < 1) {
					continue;
				} else if (j < 1) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
				} else {
					if (array[i][j] == 1) {
						if (array[i - 1][j] == array[i][j-1] && array[i][j-1] == 1) {
							dp[i][j] = dp[i-1][j -1] + 1;
						} else {
							dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j -1]), dp[i][j]);
						}
					} else {
						dp[i][j] = dp[i - 1][j - 1];
					}
				}
			}
		}
		System.out.println(dp[N-1][N-1]);
	}

}
