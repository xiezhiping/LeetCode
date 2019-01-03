package recurrence;
/**
 * 给定m数额的火柴棍，使用火柴棍摆加法等式，问能摆出多少种？
 * 1. 加号和等号各自需要两根火柴棍
 * 2. 如果A!= B,则A+B = C与B+ A = C视为不同的等式（A， B， C都大于0）
 * 3. 所有火柴棍都要求全部用上
 * @author XZP
 *
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MatchEquation {
	public static Map<Integer, Integer> match = new HashMap<>(); // 首先初始化一个存储每个数字对应使用多少火柴棍的map
	public static void main(String[] args) {
		int m; // 火柴棍的数量
		Scanner sc = new Scanner(System.in);
		init(); // 初始化
		while(sc.hasNext()) {
			int count = 0; // 等式的总数
			int sum = 0; // 用于表示A + B 之后的和
			m = sc.nextInt();
			if (m < 5) { // 考虑'+'和'='
				System.out.println("输入的火柴棍不合法！");
				return;
			}
			double start = System.currentTimeMillis();
			for (int i = 0; i < 1112; i++) { // 如果限定了数字是0-9相对简单，但是题目并没有限制A, B, C 的范围,只是给了m <= 24(好消息！)
				for (int j = 0; j < 1112; j++) {
					sum = i + j;
					if (getNeedMatchNum(i) + getNeedMatchNum(j) + getNeedMatchNum(sum) == m - 4) {
						System.out.println("i: " + i + " j:" + j);
						count++;
					}
				}
			}
			System.out.println("一共" + count + "种" + "耗时：" + (System.currentTimeMillis() - start) + "ms");
		}
	}
	/**
	 * 获取一个整数需要的火柴棍
	 * @param num 一个自然整数
	 * @return
	 */
	public static int getNeedMatchNum(int num) {
		int i10000,i1000,i100,i10,i0; //分别用来存储当num大于9时的所在位的数值
		int result = 0;
		if (num > 9999) {
			i10000 = num / 10000;
			i1000 = num / 1000 % 10;
			i100 = num / 100 % 10;
			i10 = num / 10 % 10;
			i0 = num % 10;
			result = match.get(i10000) + match.get(i1000) + match.get(i100) + match.get(i10) + match.get(i0);
		} else if(num > 999) {
			i1000 = num / 1000;
			i100 = num / 100 % 10;
			i10 = num / 10 % 10;
			i0 = num % 10;
			result = match.get(i1000) + match.get(i100) + match.get(i10) + match.get(i0);
		} else if(num > 99) {
			i100 = num / 100;
			i10 = num / 10 % 10;
			i0 = num % 10;
			result = match.get(i100) + match.get(i10) + match.get(i0);
		} else if (num > 9) {
			i10 = num / 10;
			i0 = num % 10;
			result = match.get(i10) + match.get(i0);
		} else {
			result = match.get(num);
		}
		return result;
	}
	/**
	 * 初始化每个数字对应的火柴棍
	 */
	public static void init() {
		match.put(0, 6);
		match.put(1, 2);
		match.put(2, 5);
		match.put(3, 5);
		match.put(4, 4);
		match.put(5, 5);
		match.put(6, 6);
		match.put(7, 3);
		match.put(8, 7);
		match.put(9, 6);
	}
}
