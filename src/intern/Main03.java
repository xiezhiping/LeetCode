package intern;

import java.util.Scanner;

public class Main03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���еڶ���
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] h = new int[n]; // hi
		for (int i = 0; i < n; i++) {
			h[i] = sc.nextInt();
		}
		binarySort(h, n); // ��Ϊ����
		
		int[] dp = new int[n]; // ��ʾ�е�i��������Ҫ�����ٵ���
		dp[0] = 0;
		int duoyu = 0; // ��ʾ����ʣ�µ�
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
	 * �������򣺴�i = 1��ʼ����ÿ�δ�����ĵ�һ��Ԫ��ѡ�����뵽���򲿷ֶ��ַ��ҵ����±�λ��
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
