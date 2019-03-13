package others;

import java.util.Scanner;

public class Main05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean flag = false;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			flag = false;
			String s1 = s.charAt(i) + "";
			for (int j = i + 1; j < len; j++) {
				String s2 = s.charAt(j) + "";
				if (s1.toLowerCase().equals(s2.toLowerCase())) {
					flag = true;
				}
				
			}
			if (!flag) {
				System.out.println(s1.toLowerCase());
				return;
			}
		}
	}
}
