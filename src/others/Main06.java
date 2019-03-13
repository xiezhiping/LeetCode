package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		List<Bank> banks = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			Bank bank = new Bank(a, b);
			banks.add(bank);
		}
		int max = 0;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			flag = false;
			for (int j = (i + d - 1) % n; flag == false ; j++) {
				if (i + d >= n - 1) {
					flag = true;
				}
				int now = banks.get(i).getB() + banks.get(j).getB();
				if (now > max) {
					max = now;
				}
			}
		}
		System.out.println(max);
	}
}
class Bank {
	private int a; // ×ø±ê
	private int b; // ½ðÇ®
	public Bank(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
}
