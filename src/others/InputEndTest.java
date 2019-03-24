package others;

import java.util.ArrayList;
import java.util.Scanner;

public class InputEndTest {
	public static final int[][] direction = { // ���巽������
			{1, 0}, // �� -> ˳ʱ����ת
			{0, 1},
			{-1, 0},
			{0, -1}
	};
	public static final int[][] book = new int[50][50]; // ��Ǹø����Ƿ��߹�
	public static boolean flag = false;
	public static boolean end = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> strings = new ArrayList<>();
		do {
			String s = sc.nextLine();
			if (s.equals("")) {
				break;
			}
			String[] ss = s.split(" ");
			for (String ssString : ss) {
				strings.add(ssString);
			}
		} while(true);
		int len = strings.size();
		int M = (int)Math.sqrt(len);
		int[][] array = new int[M][M];
		int index = 0; // �ַ�������
		int max = Integer.MIN_VALUE; // �ҵ������������ݵ����ֵ
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.valueOf(strings.get(index));
				index++;
				if (array[i][j] > max) {
					max = array[i][j];
				}
			}
		}
		
		// ��ʼdfs���б���
		dfs(array, 0, 0, 0, array[0][0], max);
	}
	public static void dfs(int[][] array, int x, int y, int step, int now, int max) {
		int M = array.length;
		if (now == max) {
			System.out.println(step);
			flag = true;
			return;
		}
		for (int i = 0; i < 4; i++) { // �ĸ��������γ���
			int nx = x + direction[i][0];
			int ny = y + direction[i][1];
			if (nx < 0 || ny < 0 || nx > M -1 || ny > M -1) {
				continue;
			}
			if (array[nx][ny] == now + 1 && book[nx][ny] == 0) {
				book[nx][ny] = 1;
				dfs(array, nx, ny, step + 1, now + 1, max);
				book[nx][ny] = 0;
			}
			if (i == 3) {
				end =true;
			}
		}
		if (!flag && end) { // ���������ֵ�һ������ʱ���޷���������в��ҹ��޻�û�д��꣬�Ǿͱ�ʾ������ɴ������
			System.out.println(-1);
		}
	}
}
