package others;
/**
 * ֻ�����е����·������㷨 ����FloydWarshall
 * @author XZP
 * 0��ʾ����
 * INF��ʾͼ�����㲻�ɴ�
 * ����������ֱ�ʾ����ֱ�ӵ�ֱ�Ӿ���
 *
 */
public class FloydWarshall {
//	public static int INF = Integer.MAX_VALUE; // ��ʾͼ�������㲻�ɴ�
	public static int INF = 99999; // ע���������INF��ӿ���������������Щ������Ҫע���ϸ��
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
	 * ���㷨�ĺ��Ĵ��룬ֻ�����У�
	 * ʱ�临�Ӷȣ�O(N^3)
	 * @param matrix
	 */
	public static void floyd(int[][] matrix) {
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j =0; j <size; j++) {
					// ��̬�滮��˼�룬k��ʾ����k����ת���������k��ת����������滻֮
					if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
				}
			}
		}
	}
}
