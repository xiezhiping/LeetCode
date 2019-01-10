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
		int j = 1;
		int a, b, c; // a�ǵ�b�ǵĻ���c
		int count = 0; // �Ѿ��ҵ��ߵ�����
		int sum = 0; // ��С�������Ŀ����ܺ�
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ��������
		int m = sc.nextInt(); // ��·����
		Cost[] costs = new Cost[m + 1]; // ��������
		int[] book = new int [m + 1]; // �洢costs�����ж�Ӧ�ı��Ƿ�������С������
		int[] f = new int[n + 1]; // �洢ÿ���ڵ�ĸ��ڵ�
		initF(f, n);
		for (i = 1; i <= m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			costs[i] = new Cost(a, b, c); // ��costs��ÿ������ֵָ��һ��Cost����
//			merge(f, a, b);
		}
		sort(costs, 1, m); // �������Ĵ�С��·�߰���С��������
		for (; j <= m; j++  ) {
			a = costs[j].getA();
			b = costs[j].getB();
			c = costs[j].getC();
			// �ж��������Ƿ��Ѿ���һ����Ӫ
			if (getF(a, f) != getF(b, f)) { // ����ط�ע��һ�£���Ҫ��f[a] != f[b]���жϣ�getF����ݵ���ջ���������£�����f[x]�򲻻ᣬ����Ҫ��getF()�����ж�
				merge(f, a, b);
				book[j] = 1;
				sum += c;
				count++; // �ҵ�һ����Ч�߼���һ
			}
			if (count == n-1) {
				break;
			}
		}
		// ���
		System.out.println("��С�������ܻ���Ϊ��" + sum);
		for (i = 1; i <= m; i++) {
			if (book[i] == 1) {
				System.out.println("�ڵ� " +costs[i].getA() +  " ���ڵ� " + costs[i].getB() + "�� ���˻��� " +costs[i].getC());
			}
		}
	}
	public static void merge(int[] f, int a, int b) {
		int t1, t2;
		// ��ȡ�����ڵ�ĸ��ڵ�
		t1 = getF(a, f);
		t2 = getF(b, f); // ���ˣ��������ҵ�b�ĸ��ڵ㣬�������ν��������������
		if (t1 != t2) { // �������ڵ㲻��һ����Ӫʱ��Ҫ���ݿ���ԭ�������������ԭ�򽫶�Ӧ�Ľڵ���Ϣ����
			f[t2] = t1; // �����Լ�д����������������ں��������������ĵ������µ�ֵ����t1����a
		}
	}
	/**
	 * �ݹ�Ѱ�ҽڵ�x�ĸ��ڵ�
	 * @param x
	 * @param f
	 * @return
	 */
	public static int getF(int x, int[] f) {
		if (f[x] == x) {
			return x;
		} else {
			f[x] = getF(f[x], f);
			return f[x];
		}
	}
	/**
	 * ʹ�ÿ�������costs����������򣨿���ʱ�临�Ӷ�O(MlogM)��
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
