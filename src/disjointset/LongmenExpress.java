package disjointset;

import java.util.Scanner;

/**
 * ��С����������
 * @author XZP
 * һ���������
 6 9
2 4 11
3 5 13
4 6 3
5 6 4
2 3 6
4 5 7
1 2 1
3 4 9
1 3 2
 */
public class LongmenExpress {

	public static void main(String[] args) {
		int i = 0; // ѭ����������
		int a, b, c; // a�ǵ�b�ǵĻ���c
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ��������
		int m = sc.nextInt(); // ��·����
		int[][] cost = new int[n + 1][n + 1]; // cost[i][j]��ʾi���е�j���л������ӵ���Ŀ
		Cost[] costs = new Cost[m + 1]; // ��������
		int[] f = new int[n + 1]; // �洢ÿ���ڵ�ĸ��ڵ�
		initCost(cost, n); // ��ʼ����������
		initF(f, n);
		for (i = 1; i <= m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			costs[i] = new Cost(a, b, c); // ��costs��ÿ������ֵָ��һ��Cost����
			cost[a][b] = c;
		}
		sort(costs, 1, m); // �������Ĵ�С��·�߰���С��������
		
	}
	/**
	 * ʹ�ÿ�������costs�����������
	 * @param costs
	 * @param low
	 * @param high
	 */
	public static void sort(Cost[] costs, int low, int high) {
		if (low > high) {
			return;
		}
		int i, j ;
		Cost temp;
		Cost t;
		temp = costs[low];
		i = low;
		j = high;
		while (i != j) {
			while(costs[j].getC() >= temp.getC() && i < j) {
				j--;
				}
			while (costs[i].getC() <= temp.getC() && i < j) {
				i++;
			}
			if (i < j) { // ������������������������е�λ��
				t = costs[i];
				costs[i] = costs[j];
				costs[j] = t;
			}
		}
		// ���ս���׼����Ϊ
		costs[low] = costs[i];
		costs[i] = temp;
		sort(costs, low, i -1);
		sort(costs, i + 1, high);
	}
	/**
	 * ��ʼ��ÿ���ڵ�ĸ��ڵ�Ϊ����
	 * @param f
	 * @param n
	 */
	public static void initF(int[] f, int n) {
		for (int i =1; i <= n; i++) {
			f[i] = i;
		}
	}
	/**
	 * ��ʼ��������֮��Ļ���
	 * @param cost
	 * @param n
	 */
	public static void initCost(int[][] cost, int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1;j <= n;j++) {
				cost[i][j] = 0;
			}
		}
	}

}
// ����һ�������ṹ�����
class Cost {
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public int getC() {
		return c;
	}
	private int a; // ����a
	private int b; // ����b
	private int c; // a��b������֮��Ŀ���
	public Cost(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
