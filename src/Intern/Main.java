package Intern;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ��У���ַ�������
		String[] strings = new String[N];
		for (int i = 0; i < N; i++) {
			strings[i] = sc.next();
		}
		for (int i = 0; i < N; i++) {
			System.out.println(change(strings[i]));
//			change(strings[i]);
		}
	}
	public static String change(String string) { // ���������ַ���У�����֮�󷵻���ȷ��
		int len = string.length();
		for (int i = 0; i < len - 2; i++) {
			if (string.charAt(i) == string.charAt(i + 1) 
					&& string.charAt(i) == string.charAt(i + 2)) { // ������ĸ����һ������
//				System.out.println(string.replaceFirst(string.charAt(i) + "", ""));
				return change(string.replaceFirst(string.charAt(i) + "", ""));
			} else if (i + 3 < len && string.charAt(i) == string.charAt(i + 1) 
					&& string.charAt(i + 2) == string.charAt(i + 3)) { // �ڶ������
//				System.out.println(string.replaceFirst(string.charAt(i + 2) + "", ""));
				return change(string.replaceFirst(string.charAt(i + 2) + "", ""));
			}
		}
		return string;
	}
}
