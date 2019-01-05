package shortestpath;

import java.util.Scanner;
/**
 * 从键盘输入一张图，用Dijkstra算法求解指定两点之间的距离，为了统一顶点编号也从0开始
 * 当然还有一些地方可以用堆、邻接表来优化，这里关注点不在此。
 * @author XZP
 * 一组测试数据：
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
	public static int M = 0; // 顶点个数
	public static int N = 0; // 边的条数
	public static int v1, v2; // 第一个和第二个顶点的编号
	public static int v3, v4; // v3是起始顶点，v4是终点
	public static int weight = INF; // 两个顶点对应边的权重
	public static int[] book; // 用来标记该点是否已经更新过
	public static int target; // 用于存储被选到的点
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// 首先输入顶点个数和边的条数
			M = sc.nextInt();
			N = sc.nextInt();
			// 输入要求距离之间的两个顶点编号
			v3 = sc.nextInt();
			v4 = sc.nextInt();
			// 然后初始化
			init();
			// 所有的都初始化完毕之后开始为两两顶点之间输入人为的权重值
			for (int i = 0; i < N; i++) { // N条边所有要循环N次
				v1 = sc.nextInt();
				v2 = sc.nextInt();
				weight = sc.nextInt();
				e[v1][v2] = weight; // 注意顶点编号起点，要对应一下
			}
			dijkstra(); // 求最短路径，并将“松弛”结果更新dis数组
			System.out.println("顶点" + v3 + "到顶点" + v4 + "之间的最短路径为：" + dis[v4]);
			for (int i = 0; i < M; i++) {
				System.out.print(dis[i] + " ");
			}
		}
	}
	public static void dijkstra() {
		initDis();
		for (int i = 0; i < M; i++) {
			// 每次选取还未标记的剩余点中的离v3最近的点
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				if (book[j] == 0 && dis[j] < min && j != v3) {
					min = dis[j];
					target = j;
				}
			}
			book[target] = 1;
			// 对所有target的出边进行松弛
			for (int j = 0; j < M; j++) {
				if (dis[j] > dis[target] + e[target][j]) {
					dis[j] = dis[target] + e[target][j];
				}
			}
		}
	}
	/**
	 * 当二维数组e有了确切值之后，需要初始化单源顶点v3到各个点之间的距离数组dis
	 */
	public static void initDis() {
		// 初始化dis数组
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
		// 初始化存储边的数组
		e = new int [M][M];
		// 初始化存储顶点之间最小距离的数组dis
		dis = new int[M];
	    // 初始化标记数组
		book = new int[M];
		// 初始化边数组的信息
		for (int i = 0; i < M; i++) {
			for (int j = 0;j < M; j++) {
				if (i == j) {
					e[i][j] = 0; // 同一顶点之间的距离为0
				} else {
					e[i][j] = INF; // 其他初始化为“无穷大”
				}
			}
		}
	}
}
