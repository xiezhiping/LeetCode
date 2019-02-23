package string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class PrintFirstLetter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String target = scanner.next();
		char result = findLetter3(target);
		System.out.println(result);
	}
	/**
	 * 通过类似hash表的方式来统计字符串出现次数，时间复杂度O(N)
	 * @param string
	 * @return
	 */
	public static char findLetter(String string) {
		int len = string.length();
		int[] count = new int[52]; // 用于记录对应字符出现的次数
		// 第一遍循环统计次数
		for(int i = 0; i < len; i++) {
			char temp = string.charAt(i);
			if ('A' <= temp && temp <= 'Z') {
				count[temp - 65]++;
			} else {
				count[temp - 71]++;
			}
		}
		// 第二次遍历就是返回结果
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
	/**
	 * 第二种用哈希表的方式来统计，时间复杂度为O(N)
	 * @param string
	 * @return
	 */
	public static char findLetter2(String string) {
		int len = string.length();
		HashMap<Character, Integer> hashMap = new HashMap<>();
		// 第一次遍历是统计次数
		for (int i = 0; i < len; i++) {
			if (hashMap.containsKey(string.charAt(i))) {
				int value = hashMap.get(string.charAt(i));
				hashMap.put(string.charAt(i), value+1);
			} else {
				hashMap.put(string.charAt(i), 1);
			}
		}
		// 第二次遍历是获取结果
		for (int i = 0; i < len; i++) {
			if (hashMap.get(string.charAt(i)) == 1) {
				return string.charAt(i);
			}
		}
		return '0';
	}
	// 第三种利用LinkedHashMap自身有序的特性，使用迭代进行结果求取
	public static char findLetter3(String string) {
		int len = string.length();
		LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
		// 第一次遍历统计
		for (int i = 0; i < len; i++) {
			char temp = string.charAt(i);
			if (linkedHashMap.containsKey(temp)) {
				int value = linkedHashMap.get(temp);
				linkedHashMap.put(temp, value + 1);
			} else {
				linkedHashMap.put(temp, 1);
			}
		}
		// 再进行一次迭代器遍历
		for(Character key : linkedHashMap.keySet()) {
			if (linkedHashMap.get(key) == 1) {
				return key;
			}
		}
		return '0';
	}
}
