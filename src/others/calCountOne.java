package others;

import java.util.Scanner;

public class calCountOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		System.out.println(Long.bitCount(n)); // api×Ô´ø
		System.out.println(count(n));
	}
	public static int count(long num) {
		int result = 0;
		while(num!= 0) {
			result++;
			num = num & (num -1);
		}
		return result;
	}
}
