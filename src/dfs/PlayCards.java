package dfs;

import java.util.Scanner;
/**
 * �����б�������1~n��n���˿ˣ�Ҫһ��һ�ķŵ�n��box����ȥ��������Щ������
 * ȫ�������⣡����
 * @author XZP
 *
 */
public class PlayCards {
	public static int[] book;
	public static int[] box;
	public static int count = 0; // ��Բ�ͬ�����ַ��÷�ʽ������
	public static int cards = 0; // ��Ƭ������
	public static int stemp = 1; // ÿ�ζ��Ǵӵ�һ��box��ʼ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			cards = sc.nextInt();
			if (cards < 1 || cards > 9) {
				System.out.println("���뿨Ƭ�������Ϸ�");
				return;
			}
			box = new int[cards+1]; // �±��0��ʼ��ÿ��box��Ӧ����һ�ſ�Ƭ
			book = new int[cards + 1]; // ���ڱ�ǵ�i�ſ�Ƭ�Ƿ��Ѿ�ʹ�ã�0��ʾ�������1��ʾ�Ѿ��Ž�box�����ˣ��±��1��ʼ
			System.out.println("���ÿ�Ƭ��ʼ��");
			dfs(1);
			System.out.println("һ���� " + count + "�֣�");
			
		}
	}
	public static void dfs (int step) {
		if (step == cards + 1) { // ���վ�ڵ�n + 1��box��ǰ�����ʾһ�˷��ý����������������ص���ջ
			System.out.println("\n��εķ��ý���ǣ�");
			for (int i = 1; i < box.length; i++) {
				System.out.print(box[i]);
			}
			count++;
			return;
		}
		// ��ʱվ�ڵ�step��������ǰ��Ӧ�÷����������أ�����1,2,3��˳��һһ����
		for (int i = 1; i <= cards; i++) {
			if (book[i] == 0) { // �ж��˿���i�Ƿ��Ѿ��Ž�box�ˣ����û�������
				box[step] = i;
				book[i] = 1;
				dfs(step + 1); // ��step��box�Ѿ����úã���Ҫ�����ߣ�������һ�����ݹ鷵���������ǵ�step == cards + 1
				book[i] = 0;  // �ⲽ�ܹؼ���һ��ʼ��û�����ף�ֱ���������Ժ���ʵ���ǽ���i���˿��ջ��������·��ã��������ν�����У�����������
			}
		}
	}
}
