package dfs;

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
	public static int[][] book = new int[5][4]; // ���ڱ�Ǹø����Ƿ��߹�
	// �Թ�������
	public static int row = 5;
	public static int col = 4;
	// ���ճ���������x,y
	public static int startx = 1; 
	public static int starty = 1;
	// ���������λ��p,q
	public static int p = 4;
	public static int q = 3;
	// ��ʼ��һ��ȫ�ֱ����������·��
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		book[0][0] = 1;
		dfs(1, 1, 0);
		System.out.println("�ȳ���������·��Ϊ��" + min);
	}
	public static void dfs(int x, int y, int step) {
		int nx, ny;
		// �����ǵ�ǰ��״̬
		if (x == p && y == q) { // �ҵ����
			if (step < min) {
				min = step;
				System.out.println("x:" + x + " y:" + y + " p:" + p + " q:" + q + " step:" + step);
			}
			return;
		}
		System.out.println("x:" + x + " y:" + y);
		for (int k = 0; k < 4; k++) {
			nx = x + direction[k][0]; // ��һ����x,yֵ
			ny = y + direction[k][1];
			if (nx < 1 || nx > 5 || ny < 1 || ny > 4) {
				continue;
			}
			if (book[nx-1][ny - 1] == 0 && maze[nx - 1] [ny -1] == 0) { // ���Թ�����û���ϰ��û���߹�
				book[nx - 1][ny -1] = 1; // �ⲽ����Ҫ�����û�оͻ�ջ���
				dfs(nx, ny, step + 1);
				book[nx - 1][ny - 1] = 0; // ���˵��ⲽҪ�������±��Ϊ���ߵ�
			}
		}
	}
}
