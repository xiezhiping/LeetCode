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
	 * �������
	 * @param c ��ǰ�ڵ��ַ�
	 * @param now ��ǰ���������
	 * @param n ���������:2*n
	 * @param left �����ŵ�����
	 * @param right �����ŵ�����
	 */
	private static void dfs(char c, int now, int n, int left, int right, String s) {
		if (left > n/2 || right > n/2) { // ����һ�����Ŷ�������Ͳ����ټ������������
			return;
		} else if (right > left) { // �����ű������Ŷ�Ҳ����
			return;
		}
		if (now == n) {
			list.add(s+c);
		}
		dfs('(', now + 1, n, left+1, right, s+c);
		dfs(')', now+1, n, left, right+1, s+c);
	}
}