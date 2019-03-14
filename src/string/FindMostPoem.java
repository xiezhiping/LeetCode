package string;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;


public class FindMostPoem {
	private static int wordNum = 1000000; // һ����
	private static String[] words = { // 18��α���������
			"abc","hjfds","gedi","uisds","abc","fhueds"
			,"fduisds","ds","abc","ryeu","fjdfi","uire",
			"dsds","fgyhu","fdf","fdf","rere","fdfd"
	};
	private static String huanhang = "\n";
	public static void main(String[] args) {
		// ����ʹ�������������һϵ��ʫ���ַ���

		File findMostPoem = new File("F:\\java_workspace\\LeetCode\\src\\string\\findMostPoem.txt");
		int wn = 0;
		OutputStreamWriter osw = null;
		try {
			osw = new OutputStreamWriter(new FileOutputStream(findMostPoem));
		Random rand = new Random();
		for (int i = 0; i < wordNum; i++) {
			String s = words[rand.nextInt(18)] + " ";
			if (wn < 30) {
				osw.write(s);
				wn++;
			} else {
				osw.write(s + huanhang);
				wn = 0;
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				osw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ʫ���嵥�Ѿ�������� >>>>>>>>>>>>>>>>>>>>>>>>>>>");
		// ���ַ������루������������������ر������������Ǻܴ�������
		
		HashMap<String, Integer> map = new HashMap<>();
		InputStreamReader isr = null;
		StringBuilder sb = new StringBuilder();
		try {
			isr = new InputStreamReader(new FileInputStream(findMostPoem));
			int len = 0;
			while ((len = isr.read()) > 0) {
				sb.append((char)len);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ͳ�Ʋ�������
		
		String[] strings = sb.toString().split(" ");
		int length = strings.length;
		for (String string : strings) {
			if (map.containsKey(string)) {
			map.put(string, map.get(string) + 1);
		} else {
			map.put(string, 1);
		}
			
	}
		for (String string : strings) {
			System.out.println(string + " : " + map.get(string));
		}
}
}
