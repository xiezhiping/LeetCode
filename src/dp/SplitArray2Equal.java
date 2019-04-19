package dp;

import java.util.Scanner;

/**
 * ����0,1��������ı��壺��������������Ϊ�����ǿ����飬Ҫ������������ĺ����
 * @author xzp
 *˼·��
 *��������������ĺ�һ�����ܺ͵�һ��
 *����һ�ֱ��壺��������Ĳ���С����ʵ�������һ������
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
		int[][] dp = new int[len+1][half + 1]; // dp[i][j]��ʾֻ��ǰi����Ʒʱ��װ������j�ı�����������
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
