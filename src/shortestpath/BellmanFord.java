package shortestpath;

import java.util.Scanner;

/**
 * �������Ȩ�ߵ����·���㷨����BellmanFord
 * @author XZP
 *
 */
public class BellmanFord {

	public static void main(String[] args) {
		int INF = 9999; // ����һ����Ϊ�����ֵ
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ������
		int M = sc.nextInt(); // ����
		int[] dis = new int[N]; // �����·���ľ���
		// ����uvw�������飬���ڱ�ʾu[i]��v[i]��������֮���Ȩ��Ϊw[i]
		int[] u = new int[N];
		int[] v = new int[N];
		int[] w = new int[N];
		// �����
		for (int i = 0; i < M; i++) {
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		
		// ��ʼ��dis����:1�Ŷ��㵽��������֮��ĳ�ʼ·��(�±�0��ʼ)
		for (int i = 1; i < N; i++) {
			dis[i] = INF;
		}
		dis[0] = 0;
		// BellmanFord�㷨�ĺ������
		for (int k = 0; k < N -1; k++) { // n�����������£�����һ�����㵽�������ж���֮��������n-1���ߣ�����n-1���ɳ�
			for (int i = 0 ; i < M; i++) {
				if (dis[v[i]] > dis[u[i]] + w[i]) {
					dis[v[i]] = dis[u[i]] + w[i];
				}
			}
		}
		
		// ������
		for (int i = 0; i < N; i++) {
			System.out.print(dis[i] + " ");
		}
	}

}
