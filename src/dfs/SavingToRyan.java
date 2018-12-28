package dfs;

/**
 * 约翰·米勒上尉接到上级命令，要去一个迷宫拯救被困其中的大兵瑞恩。迷宫由空地格子和不可穿透的墙组成。现在米勒从(1,1)这个地方降落并进入迷宫，问找到瑞恩的最短路径。通过卫星定位到瑞恩所在坐标为(p, q),让你求解。
 * @author XZP
 *
 */
public class SavingToRyan {
	// 给定一个迷宫，1表示墙，0表示空地可通过
	public static int[][] maze = {
			{0, 0, 1, 0},
			{0, 0, 0, 0},
			{0, 0, 1, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 1}
	};
	// 初始化一个控制方向的向量
	public static int[][] direction = {
			{0, 1}, // 左
			{1, 0}, // 下
			{0, -1}, // 右
			{-1, 0}  // 上
	};
	public static int[][] book = new int[5][4]; // 用于标记该格子是否走过
	// 迷宫的行列
	public static int row = 5;
	public static int col = 4;
	// 米勒出发的坐标x,y
	public static int startx = 1; 
	public static int starty = 1;
	// 瑞恩被困的位置p,q
	public static int p = 4;
	public static int q = 3;
	// 初始化一个全局变量保存最短路径
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		book[0][0] = 1;
		dfs(1, 1, 0);
		System.out.println("救出瑞恩的最短路径为：" + min);
	}
	public static void dfs(int x, int y, int step) {
		int nx, ny;
		// 首先是当前的状态
		if (x == p && y == q) { // 找到瑞恩
			if (step < min) {
				min = step;
				System.out.println("x:" + x + " y:" + y + " p:" + p + " q:" + q + " step:" + step);
			}
			return;
		}
		System.out.println("x:" + x + " y:" + y);
		for (int k = 0; k < 4; k++) {
			nx = x + direction[k][0]; // 下一步的x,y值
			ny = y + direction[k][1];
			if (nx < 1 || nx > 5 || ny < 1 || ny > 4) {
				continue;
			}
			if (book[nx-1][ny - 1] == 0 && maze[nx - 1] [ny -1] == 0) { // 在迷宫内且没有障碍物，没有走过
				book[nx - 1][ny -1] = 1; // 这步很重要，如果没有就会栈溢出
				dfs(nx, ny, step + 1);
				book[nx - 1][ny - 1] = 0; // 回退到这步要将其重新标记为能走的
			}
		}
	}
}
