package others;
/**
 * 只有五行的最短路径求解算法 ——FloydWarshall
 * @author XZP
 * 0表示自身
 * INF表示图中两点不可达
 * 大于零的数字表示两点直接的直接距离
 *
 */
public class FloydWarshall {
//	public static int INF = Integer.MAX_VALUE; // 表示图中两顶点不可达
	public static int INF = 99999; // 注意后面两个INF相加可能溢出的情况，这些都是需要注意的细节
	public static int[][] graph = {
			{0, 2, 6, 4 },
			{INF, 0, 3, INF},
			{7, INF, 0, 1},
			{5, INF, 12, 0}
	};
	public static int size = graph.length;
	public static void main(String[] args) {
		floyd(graph);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	/**
	 * 该算法的核心代码，只有五行！
	 * 时间复杂度：O(N^3)
	 * @param matrix
	 */
	public static void floyd(int[][] matrix) {
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j =0; j <size; j++) {
					// 动态规划的思想，k表示经过k点中转，如果经过k中转距离更好则替换之
					if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
				}
			}
		}
	}
}
