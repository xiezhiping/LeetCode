package disjointset;

import java.util.Scanner;

/**
 * ���ݾ����ṩ�����������ж��м��������Ż���鼯���ɭ�����⣩
 * @author XZP
 * һ���������ݣ�
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
	private static int N, M; // N��ʾǿ���������� M��ʾ�����ռ�����������
	private static int[] f = new int[1000];
	private static int k = 0;
	private static int sum;
	public static void main(String[] args) {
		int i, x, y;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// �����ʼ��
		init();
		for (i = 1; i <= M;i++) {
			// ��ʼ�ϲ������Ż�
			x = sc.nextInt();
			y = sc.nextInt();
			merge(x, y);
		}
		// ���ɨ���ж��ٸ������ķ����Ż�
		for (i = 1; i <= N; i++) {
			if (f[i] == i) {
				sum++;
			}
		}
		System.out.println("һ���� " + sum + " �������Ż�");
	}
	// ��'BOSS'�ĵݹ麯��
	public static int getF(int v) {
		if (f[v] == v) {
			return v;
		} else {
			// �ݹ�ʵ�֣�ÿ���ں������ص�ʱ��˳�����ϲ��ҵ��ġ�BOSS'��Ϊ����ҵ��ġ�BOSS'��ţ�
			// Ҳ������������֯������쵼��ţ���������������ҵ������Ż��Ŷ�����쵼�ˣ�Ҳ����û���������ȣ����ٶ�
			f[v] = getF(f[v]);
			return f[v];
		}
	}
	// �ϲ������Ӽ��ϵĺ���
	public static void merge(int x, int y) {
		int t1, t2;
		t1 = getF(x);
		t2 = getF(y);
		if (t1 != t2) { // �ж������ڵ��Ƿ���ͬһ�������У����Ƿ�������ͬ
			f[t2] = t1; // ������ԭ�򣺽���߱���ұߵ�BOSS
		}
	}
	/**
	 * ��ʼ��ÿһ��ǿ���ġ�BOSS��
	 */
	public static void init() {
		int i;
		for (i = 1; i <= N; i++) {
			f[i] = i; // ��ʼ��ʹ�䵱ǰ'ǿ��'(�±�����ֵ)��Ӧ��'�ϴ�'(����ֵ)�������Լ�
		}
	}
}
