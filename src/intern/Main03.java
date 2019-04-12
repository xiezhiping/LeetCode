package intern;

import java.util.Scanner;

public class Main03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 招行第二题
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] h = new int[n]; // hi
		for (int i = 0; i < n; i++) {
			h[i] = sc.nextInt();
		}
		binarySort(h, n); // 变为升序
		
		int[] dp = new int[n]; // 表示切第i个蛋糕需要的最少刀数
		dp[0] = 0;
		int duoyu = 0; // 表示切了剩下的
		int xuyaoqie = 0;
		int min = h[0];
		for (int i = 1; i < n; i++) {
			if (h[i] <= min) {
				dp[i] = dp[i-1];
			}else {
				xuyaoqie = h[i] - min + duoyu;
				if (xuyaoqie <= k) {
					dp[i] = dp[i-1] + 1;
					duoyu = xuyaoqie - k;
				} else {
					dp[i] = dp[i-1] + (xuyaoqie / k);
					duoyu = xuyaoqie % k;
				}
			}
			if (xuyaoqie > 0 && i == n -1) {
				dp[i] = dp[i -1] + 1;
			}
		}
		System.out.println(dp[n-1]);
	}
	/**
	 * 二分排序：从i = 1开始往后每次从无序的第一个元素选来插入到有序部分二分法找到的下标位置
	 * @param source
	 * @param length
	 */
	public static void binarySort(int[] source, int length) {
		int low, high, mid, temp;
		for (int i = 1; i < length; i++) {
			temp = source[i];
			low = 0;
			high = i-1;
			while (low <= high) {
				mid = (low + high) / 2;
				if (source[mid] > temp) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			for ( int j = i - 1; j > high; j--) {
				source[j + 1] = source[j];
			}
			source[high + 1] = temp;
		}
	}
}
