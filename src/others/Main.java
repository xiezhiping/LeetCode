package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static List<String> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dfs('(', 1, n*2, 1, 0, "");
		for (int i = 0; i < list.size();i++) {
			if (i != list.size() - 1) {
				System.out.print(list.get(i) + ",");
			} else {
				System.out.print(list.get(i));
			}
		}
	}
	/**
	 * 深度搜索
	 * @param c 当前节点字符
	 * @param now 当前搜索的深度
	 * @param n 树的总深度:2*n
	 * @param left 左括号的数量
	 * @param right 右括号的数量
	 */
	private static void dfs(char c, int now, int n, int left, int right, String s) {
		if (left > n/2 || right > n/2) { // 任意一种括号多余半数就不用再继续深度搜索了
			return;
		} else if (right > left) { // 右括号比左括号多也不行
			return;
		}
		if (now == n) {
			list.add(s+c);
		}
		dfs('(', now + 1, n, left+1, right, s+c);
		dfs(')', now+1, n, left, right+1, s+c);
	}
}