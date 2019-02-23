package string;

import java.util.Scanner;

public class PrintFirstLetter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String target = scanner.next();
		char result = findLetter(target);
		System.out.println(result);
	}
	public static char findLetter(String string) {
		int len = string.length();
		int[] count = new int[52]; // ���ڼ�¼��Ӧ�ַ����ֵĴ���
		// ��һ��ѭ��ͳ�ƴ���
		for(int i = 0; i < len; i++) {
			char temp = string.charAt(i);
			if ('A' <= temp && temp <= 'Z') {
				count[temp - 65]++;
			} else {
				count[temp - 71]++;
			}
		}
		// �ڶ��α������Ƿ��ؽ��
		for(int i = 0; i < len; i++) {
			char temp = string.charAt(i);
			if ('A' <= temp && temp <= 'Z' && count[temp - 65] == 1) {
				return temp;
			} else if(count[temp - 71] == 1) {
				return temp;
			}
		}
		return '0';
	}
}
