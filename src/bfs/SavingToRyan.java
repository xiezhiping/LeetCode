package bfs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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
	public static int[][] book = new int[5][4]; // 标记该格子是否走过
	// 迷宫的行列
	public static int row = 5;
	public static int col = 4;
	// 米勒出发的坐标x,y
	public static int startx = 1; 
	public static int starty = 1;
	// 瑞恩被困的位置p,q
	public static int p = 4;
	public static int q = 3;
	// 记录走过的步长
	public static int step = 0;
	// 是否找到的标记
	public static boolean flag = false;
	// 存储即将访问的格子队列
	public static Queue<int[]> search = new LinkedBlockingQueue<int[]>();
	public static void main(String[] args) {
		int[] start = {1, 1};
		search.offer(start);
		while (!search.isEmpty() && !flag) {
			int[] now = search.poll();
			bfs(now[0], now[1]);
			step++;
		}
	}
	public static void bfs (int x, int y) {
		int nx, ny;
		if (x == p && y == q) {
			flag = true;
			System.out.println("step:" + step);
			return;
		}
		book[x - 1][y - 1] = 1; // 标记为已经访问过
		//将该节点下一步能到的几点都push到队列中
		for (int i = 0; i < 4; i++) {
			nx = x + direction[i][0];
			ny = y + direction[i][1];
			if (nx < 1 || nx > 5 || ny < 1 || ny > 4) {
				continue;
			}
			if (book[nx - 1][ny - 1] == 0 && maze[nx -1][ny - 1] == 0) {
				book[nx - 1][ny - 1] =1;
				int[] temp = {nx, ny};
				search.offer(temp);
			}
		}
		return;
	}
}
