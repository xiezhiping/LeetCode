package recurrence;

import java.util.Scanner;

/**
 * 数的全排列
 * 输入n
 * 输出0~n（ n < 10）之间除0以外所有数字的全排列数
 * @author XZP
 *
 */
public class NumberPermutation {
	public static int[][] dp = new int[10][362881]; // 下标从1开始
	public static int[] num = new int[10]; // n!的缓存
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		while (sc.hasNext()) {
			n = sc.nextInt();
			if (n < 1 || n > 10) {
				System.out.println("输入n不合法！");
				return;
			}
			
		}
	}
	public static void fun(int n) {
		if (n < 2) {
			dp[1][1] = 1;
			return;
		} else {
			int tempI = num(n); // 对应n的全排列数的个数，后面tempJ对应n -1的全排列数的个数
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
	 * 给定一个数number，然后将n依次插入到不同位置，得到一组新的数
	 * 比如number 为12 ，n 为3时，分别插入到第一、第二、第三位，得到312,132,123
	 * @param n 插入的数
	 * @param number 一个具有多位的数
	 * @return 返回插入得到的一组数
	 */
	public static int[] getNums(int n, int number) {
		int[] result = new int[n];
		int[] temp = new int[10]; // temp[i]对应于number的每一位
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
	 * 给定一个数，求这个数的n!
	 * @param n 1-9的整数
	 * @return
	 */
	public static int num(int n) {
		if ( n < 2) {
			return 1;
		} else if (num[n -1] != 0) {
			return n * num[n-1];
		}
		else {
			num[n-1] = num(n -1); // 用了一下缓存
			return n * num[n - 1];
		}
	}
}
