import java.util.Scanner;

public class Main {
	// ��ʼ��һ�����Ʒ��������
		public static int[][] direction = {
				{0, 1}, // ��
				{1, 0}, // ��
				{0, -1}, // ��
				{-1, 0}  // ��
		};
		public static boolean isPrint = false;
		public static boolean flag = false;
	public static int[][] book = new int[50][50]; // ���ڱ�Ǹø����Ƿ��߹�
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int M = sc.nextInt();
	int[][] array = new int[M][M];
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < M; j++) {
			array[i][j] = sc.nextInt();
			if (array[i][j] > max) {
				max = array[i][j]; // ��¼��󼶱�Ĺ��ޣ����������ж�
			}
		}
	}
	dfs(array, 0, 0, 0,array[0][0], max, M);
	}
	public static void dfs(int[][] array,int x, int y, int step, int before, int max, int M) {
		int nx, ny;
		// �����ǵ�ǰ��״̬
		if (array[x][y] == max) { // �ҵ�
			System.out.println(step);
			flag = true;
			return;
		}
		for (int k = 0; k < 4; k++) {
			nx = x + direction[k][0]; // ��һ����x,yֵ
			ny = y + direction[k][1];
			if (nx < 0 || nx >= M || ny < 0 || ny >= M) {
				continue;
			}
			if (book[nx][ny] == 0 && array[nx] [ny] == before+1) {
				book[nx][ny] = 1; // �ⲽ����Ҫ�����û�оͻ�ջ���
				dfs(array,nx, ny, step + 1, array[nx] [ny],max,M);
				book[nx][ny] = 0; // ���˵��ⲽҪ�������±��Ϊ���ߵ�
			}
		}
		if (!flag && !isPrint) {
			System.out.println(-1);
			isPrint = true;
			return;
		}
	}
}
