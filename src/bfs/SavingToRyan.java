package bfs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Լ����������ξ�ӵ��ϼ����Ҫȥһ���Թ����ȱ������еĴ��������Թ��ɿյظ��ӺͲ��ɴ�͸��ǽ��ɡ��������մ�(1,1)����ط����䲢�����Թ������ҵ���������·����ͨ�����Ƕ�λ�������������Ϊ(p, q),������⡣
 * @author XZP
 *
 */
public class SavingToRyan {
	// ����һ���Թ���1��ʾǽ��0��ʾ�յؿ�ͨ��
	public static int[][] maze = {
			{0, 0, 1, 0},
			{0, 0, 0, 0},
			{0, 0, 1, 0},
			{0, 1, 0, 0},
			{0, 0, 0, 1}
	};
	// ��ʼ��һ�����Ʒ��������
	public static int[][] direction = {
				{0, 1}, // ��
				{1, 0}, // ��
				{0, -1}, // ��
				{-1, 0}  // ��
		};
	public static int[][] book = new int[5][4]; // ��Ǹø����Ƿ��߹�
	// �Թ�������
	public static int row = 5;
	public static int col = 4;
	// ���ճ���������x,y
	public static int startx = 1; 
	public static int starty = 1;
	// ���������λ��p,q
	public static int p = 4;
	public static int q = 3;
	// ��¼�߹��Ĳ���
	public static int step = 0;
	// �Ƿ��ҵ��ı��
	public static boolean flag = false;
	// �洢�������ʵĸ��Ӷ���
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
		book[x - 1][y - 1] = 1; // ���Ϊ�Ѿ����ʹ�
		//���ýڵ���һ���ܵ��ļ��㶼push��������
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
