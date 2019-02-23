package string;

import java.util.HashMap;
import java.util.Scanner;

public class PrintFirstLetter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String target = scanner.next();
		char result = findLetter2(target);
		System.out.println(result);
	}
	/**
	 * ͨ������hash��ķ�ʽ��ͳ���ַ������ִ�����ʱ�临�Ӷ�O(N)
	 * @param string
	 * @return
	 */
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
	public static char findLetter2(String string) {
		int len = string.length();
		HashMap<Character, Integer> hashMap = new HashMap<>();
		// ��һ�α�����ͳ�ƴ���
		for (int i = 0; i < len; i++) {
			if (hashMap.containsKey(string.charAt(i))) {
				int value = hashMap.get(string.charAt(i));
				hashMap.put(string.charAt(i), value+1);
			} else {
				hashMap.put(string.charAt(i), 1);
			}
		}
		// �ڶ��α����ǻ�ȡ���
		for (int i = 0; i < len; i++) {
			if (hashMap.get(string.charAt(i)) == 1) {
				return string.charAt(i);
			}
		}
		return '0';
	}
}
