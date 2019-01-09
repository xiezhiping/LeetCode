package disjointset;

import java.util.Scanner;

/**
 * 根据警察提供的线索条数判断有几个犯罪团伙（并查集解决森林问题）
 * @author XZP
 * 一条测试数据：
 * 
 10 9
 1 2 
 3 4
 5 2
 4 6
 2 6
 8 7
 9 7
 1 6 
 2 4
 */
public class FindCriminalGangs {
	private static int N, M; // N表示强盗的人数， M表示警方收集到的线索数
	private static int[] f = new int[1000];
	private static int k = 0;
	private static int sum;
	public static void main(String[] args) {
		int i, x, y;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 必须初始化
		init();
		for (i = 1; i <= M;i++) {
			// 开始合并犯罪团伙
			x = sc.nextInt();
			y = sc.nextInt();
			merge(x, y);
		}
		// 最后扫描有多少个独立的犯罪团伙
		for (i = 1; i <= N; i++) {
			if (f[i] == i) {
				sum++;
			}
		}
		System.out.println("一共有 " + sum + " 个犯罪团伙");
	}
	// 找'BOSS'的递归函数
	public static int getF(int v) {
		if (f[v] == v) {
			return v;
		} else {
			// 递归实现，每次在函数返回的时候，顺带将上层找到的‘BOSS'改为最后找到的’BOSS'编号，
			// 也就是最后这个组织的最高领导编号，这样有利于提高找到犯罪团伙团队最高领导人（也就是没颗数的祖先）的速度
			f[v] = getF(f[v]);
			return f[v];
		}
	}
	// 合并两个子集合的函数
	public static void merge(int x, int y) {
		int t1, t2;
		t1 = getF(x);
		t2 = getF(y);
		if (t1 != t2) { // 判断两个节点是否在同一个集合中，即是否祖先相同
			f[t2] = t1; // 靠‘左’原则：将左边变成右边的BOSS
		}
	}
	/**
	 * 初始化每一个强盗的‘BOSS’
	 */
	public static void init() {
		int i;
		for (i = 1; i <= N; i++) {
			f[i] = i; // 初始化使其当前'强盗'(下标索引值)对应的'老大'(数组值)就是他自己
		}
	}
}
