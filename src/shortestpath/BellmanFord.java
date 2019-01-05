package shortestpath;

import java.util.Scanner;

/**
 * 解决带负权边的最短路径算法——BellmanFord
 * @author XZP
 *
 */
public class BellmanFord {

	public static void main(String[] args) {
		int INF = 9999; // 定义一个认为的最大值
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 顶点数
		int M = sc.nextInt(); // 边数
		int[] dis = new int[N]; // 放最短路径的距离
		// 声明uvw三个数组，用于表示u[i]到v[i]两个顶点之间的权重为w[i]
		int[] u = new int[N];
		int[] v = new int[N];
		int[] w = new int[N];
		// 读入边
		for (int i = 0; i < M; i++) {
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		
		// 初始化dis数组:1号顶点到其他顶点之间的初始路程(下标0开始)
		for (int i = 1; i < N; i++) {
			dis[i] = INF;
		}
		dis[0] = 0;
		// BellmanFord算法的核心语句
		for (int k = 0; k < N -1; k++) { // n个顶点的情况下，其中一个顶点到其他所有顶点之间至多有n-1条边，进行n-1次松弛
			for (int i = 0 ; i < M; i++) {
				if (dis[v[i]] > dis[u[i]] + w[i]) {
					dis[v[i]] = dis[u[i]] + w[i];
				}
			}
		}
		
		// 输出结果
		for (int i = 0; i < N; i++) {
			System.out.print(dis[i] + " ");
		}
	}

}
