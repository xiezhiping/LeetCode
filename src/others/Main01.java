package others;

import java.util.Scanner;

public class Main01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getMax(n));
	}
	public static int getMax(int i) {
		int[] result = {0, 0, 1, 2, 4, 6, 9};
		if (i <= 6) {
			return result[i];
		} else {
			return getMax(i-3)*3;
		}
	}
}
