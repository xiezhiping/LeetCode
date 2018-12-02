package dp;

import java.util.Scanner;

public class PlayApple {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(num(m,n));	
		}
	}
	public static int num(int m, int n) {
		if (m < 0) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		return num(m, n-1) + num(m-n, n);
	}
}
