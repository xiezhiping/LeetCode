package string;

import java.util.Scanner;

public class IsIpSame {
	public static String result = ""; // 用于存储ip1与mask与之后的结果
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ip1 = sc.next();
		String ip2 = sc.next();
		String mask = sc.next();
		System.out.println(isSameSeg(ip1, ip2, mask) + " " + result);
	}
	public static boolean isSameSeg(String ip1, String ip2, String mask) {
		int[] ipOne = new int[4];
		int[] ipTwo = new int[4];
		int[] maskInt = new int[4];
		String[] strings1 = ip1.split("\\.");
		String[] strings2 = ip2.split("\\.");
		String[] strings3 = mask.split("\\.");
		for (int i = 0; i < 4; i++) {
			ipOne[i] = Integer.valueOf(strings1[i]);
			ipTwo[i] = Integer.valueOf(strings2[i]);
			maskInt[i] = Integer.valueOf(strings3[i]);
		}
		result = (ipOne[0] & maskInt[0]) + "." + (ipOne[1] & maskInt[1])
				 + "." + (ipOne[2] & maskInt[2]) + "." + (ipOne[3] & maskInt[3]);
		return (ipOne[0] & maskInt[0]) == (ipTwo[0] & maskInt[0]) // 测试使用，不是很优雅
				&& (ipOne[1] & maskInt[1]) == (ipTwo[1] & maskInt[1])
				&& (ipOne[2] & maskInt[2]) == (ipTwo[2] & maskInt[2])
				&& (ipOne[3] & maskInt[3]) == (ipTwo[3] & maskInt[3]);
	}
}
