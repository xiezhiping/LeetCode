package recurrence;

import java.util.Scanner;

/**
 * ����ȫ����
 * ����n
 * ���0~n�� n < 10��֮���0�����������ֵ�ȫ������
 * @author XZP
 *
 */
public class NumberPermutation {
	public static int[][] dp = new int[10][362881]; // �±��1��ʼ
	public static int[] num = new int[10]; // n!�Ļ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		while (sc.hasNext()) {
			n = sc.nextInt();
			if (n < 1 || n > 10) {
				System.out.println("����n���Ϸ���");
				return;
			}
			
		}
	}
	public static void fun(int n) {
		if (n < 2) {
			dp[1][1] = 1;
			return;
		} else {
			int tempI = num(n); // ��Ӧn��ȫ�������ĸ���������tempJ��Ӧn -1��ȫ�������ĸ���
			int tempJ = 0;
			for (int i = 1; i <= tempI;) {
				tempJ = num(n-1);
				for (int j = 1; j <= tempJ;) {
					int temp = dp[n-1][j];
				}
			}
		}
	}
	/**
	 * ����һ����number��Ȼ��n���β��뵽��ͬλ�ã��õ�һ���µ���
	 * ����number Ϊ12 ��n Ϊ3ʱ���ֱ���뵽��һ���ڶ�������λ���õ�312,132,123
	 * @param n �������
	 * @param number һ�����ж�λ����
	 * @return ���ز���õ���һ����
	 */
	public static int[] getNums(int n, int number) {
		int[] result = new int[n];
		int[] temp = new int[10]; // temp[i]��Ӧ��number��ÿһλ
		int i = 1;
		while(number > 0) {
			temp[i++] = number % 10;
			number /= 10;
		}
		for (int j = 1; j <= n; j++ ) {
			
		}
		return result;
	}
	/**
	 * ����һ���������������n!
	 * @param n 1-9������
	 * @return
	 */
	public static int num(int n) {
		if ( n < 2) {
			return 1;
		} else if (num[n -1] != 0) {
			return n * num[n-1];
		}
		else {
			num[n-1] = num(n -1); // ����һ�»���
			return n * num[n - 1];
		}
	}
}
