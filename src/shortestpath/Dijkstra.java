package shortestpath;

import java.util.Scanner;
/**
 * �Ӽ�������һ��ͼ����Dijkstra�㷨���ָ������֮��ľ��룬Ϊ��ͳһ������Ҳ��0��ʼ
 * ��Ȼ����һЩ�ط������öѡ��ڽӱ����Ż��������ע�㲻�ڴˡ�
 * @author XZP
 * һ��������ݣ�
 6 9
 0 2
 0 1 1
 0 2 12
 1 2 9
 1 3 3
 2 4 5
 3 2 4
 3 4 13
 3 5 15
 4 5 4
 *
 */
public class Dijkstra {
	public static int[][] e;
	public static int[] dis;
	public static int INF = 99999;
	public static int M = 0; // �������
	public static int N = 0; // �ߵ�����
	public static int v1, v2; // ��һ���͵ڶ�������ı��
	public static int v3, v4; // v3����ʼ���㣬v4���յ�
	public static int weight = INF; // ���������Ӧ�ߵ�Ȩ��
	public static int[] book; // ������Ǹõ��Ƿ��Ѿ����¹�
	public static int target; // ���ڴ洢��ѡ���ĵ�
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// �������붥������ͱߵ�����
			M = sc.nextInt();
			N = sc.nextInt();
			// ����Ҫ�����֮�������������
			v3 = sc.nextInt();
			v4 = sc.nextInt();
			// Ȼ���ʼ��
			init();
			// ���еĶ���ʼ�����֮��ʼΪ��������֮��������Ϊ��Ȩ��ֵ
			for (int i = 0; i < N; i++) { // N��������Ҫѭ��N��
				v1 = sc.nextInt();
				v2 = sc.nextInt();
				weight = sc.nextInt();
				e[v1][v2] = weight; // ע�ⶥ������㣬Ҫ��Ӧһ��
			}
			dijkstra(); // �����·�����������ɳڡ��������dis����
			System.out.println("����" + v3 + "������" + v4 + "֮������·��Ϊ��" + dis[v4]);
			for (int i = 0; i < M; i++) {
				System.out.print(dis[i] + " ");
			}
		}
	}
	public static void dijkstra() {
		initDis();
		for (int i = 0; i < M; i++) {
			// ÿ��ѡȡ��δ��ǵ�ʣ����е���v3����ĵ�
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				if (book[j] == 0 && dis[j] < min && j != v3) {
					min = dis[j];
					target = j;
				}
			}
			book[target] = 1;
			// ������target�ĳ��߽����ɳ�
			for (int j = 0; j < M; j++) {
				if (dis[j] > dis[target] + e[target][j]) {
					dis[j] = dis[target] + e[target][j];
				}
			}
		}
	}
	/**
	 * ����ά����e����ȷ��ֵ֮����Ҫ��ʼ����Դ����v3��������֮��ľ�������dis
	 */
	public static void initDis() {
		// ��ʼ��dis����
		for (int i = 0; i < M; i++) {
				if (i == v3) {
					dis[v3] = 0;
					book[v3] = 1;
				} else {
					dis[i] = e[v3][i];
				}
			}
	}
	public static void init() {
		// ��ʼ���洢�ߵ�����
		e = new int [M][M];
		// ��ʼ���洢����֮����С���������dis
		dis = new int[M];
	    // ��ʼ���������
		book = new int[M];
		// ��ʼ�����������Ϣ
		for (int i = 0; i < M; i++) {
			for (int j = 0;j < M; j++) {
				if (i == j) {
					e[i][j] = 0; // ͬһ����֮��ľ���Ϊ0
				} else {
					e[i][j] = INF; // ������ʼ��Ϊ�������
				}
			}
		}
	}
}
