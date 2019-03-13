import java.util.Scanner;

public class Main {
	// 初始化一个控制方向的向量
		public static int[][] direction = {
				{0, 1}, // 左
				{1, 0}, // 下
				{0, -1}, // 右
				{-1, 0}  // 上
		};
		public static boolean isPrint = false;
		public static boolean flag = false;
	public static int[][] book = new int[50][50]; // 用于标记该格子是否走过
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int M = sc.nextInt();
	int[][] array = new int[M][M];
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < M; j++) {
			array[i][j] = sc.nextInt();
			if (array[i][j] > max) {
				max = array[i][j]; // 记录最大级别的怪兽，用于最后的判断
			}
		}
	}
	dfs(array, 0, 0, 0,array[0][0], max, M);
	}
	public static void dfs(int[][] array,int x, int y, int step, int before, int max, int M) {
		int nx, ny;
		// 首先是当前的状态
		if (array[x][y] == max) { // 找到
			System.out.println(step);
			flag = true;
			return;
		}
		for (int k = 0; k < 4; k++) {
			nx = x + direction[k][0]; // 下一步的x,y值
			ny = y + direction[k][1];
			if (nx < 0 || nx >= M || ny < 0 || ny >= M) {
				continue;
			}
			if (book[nx][ny] == 0 && array[nx] [ny] == before+1) {
				book[nx][ny] = 1; // 这步很重要，如果没有就会栈溢出
				dfs(array,nx, ny, step + 1, array[nx] [ny],max,M);
				book[nx][ny] = 0; // 回退到这步要将其重新标记为能走的
			}
		}
		if (!flag && !isPrint) {
			System.out.println(-1);
			isPrint = true;
			return;
		}
	}
}
