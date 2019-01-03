package recurrence;
/**
 * ����m����Ļ�����ʹ�û����ڼӷ���ʽ�����ܰڳ������֣�
 * 1. �Ӻź͵ȺŸ�����Ҫ��������
 * 2. ���A!= B,��A+B = C��B+ A = C��Ϊ��ͬ�ĵ�ʽ��A�� B�� C������0��
 * 3. ���л�����Ҫ��ȫ������
 * @author XZP
 *
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MatchEquation {
	public static Map<Integer, Integer> match = new HashMap<>(); // ���ȳ�ʼ��һ���洢ÿ�����ֶ�Ӧʹ�ö��ٻ�����map
	public static void main(String[] args) {
		int m; // ����������
		Scanner sc = new Scanner(System.in);
		init(); // ��ʼ��
		while(sc.hasNext()) {
			int count = 0; // ��ʽ������
			int sum = 0; // ���ڱ�ʾA + B ֮��ĺ�
			m = sc.nextInt();
			if (m < 5) { // ����'+'��'='
				System.out.println("����Ļ������Ϸ���");
				return;
			}
			double start = System.currentTimeMillis();
			for (int i = 0; i < 1112; i++) { // ����޶���������0-9��Լ򵥣�������Ŀ��û������A, B, C �ķ�Χ,ֻ�Ǹ���m <= 24(����Ϣ��)
				for (int j = 0; j < 1112; j++) {
					sum = i + j;
					if (getNeedMatchNum(i) + getNeedMatchNum(j) + getNeedMatchNum(sum) == m - 4) {
						System.out.println("i: " + i + " j:" + j);
						count++;
					}
				}
			}
			System.out.println("һ��" + count + "��" + "��ʱ��" + (System.currentTimeMillis() - start) + "ms");
		}
	}
	/**
	 * ��ȡһ��������Ҫ�Ļ���
	 * @param num һ����Ȼ����
	 * @return
	 */
	public static int getNeedMatchNum(int num) {
		int i10000,i1000,i100,i10,i0; //�ֱ������洢��num����9ʱ������λ����ֵ
		int result = 0;
		if (num > 9999) {
			i10000 = num / 10000;
			i1000 = num / 1000 % 10;
			i100 = num / 100 % 10;
			i10 = num / 10 % 10;
			i0 = num % 10;
			result = match.get(i10000) + match.get(i1000) + match.get(i100) + match.get(i10) + match.get(i0);
		} else if(num > 999) {
			i1000 = num / 1000;
			i100 = num / 100 % 10;
			i10 = num / 10 % 10;
			i0 = num % 10;
			result = match.get(i1000) + match.get(i100) + match.get(i10) + match.get(i0);
		} else if(num > 99) {
			i100 = num / 100;
			i10 = num / 10 % 10;
			i0 = num % 10;
			result = match.get(i100) + match.get(i10) + match.get(i0);
		} else if (num > 9) {
			i10 = num / 10;
			i0 = num % 10;
			result = match.get(i10) + match.get(i0);
		} else {
			result = match.get(num);
		}
		return result;
	}
	/**
	 * ��ʼ��ÿ�����ֶ�Ӧ�Ļ���
	 */
	public static void init() {
		match.put(0, 6);
		match.put(1, 2);
		match.put(2, 5);
		match.put(3, 5);
		match.put(4, 4);
		match.put(5, 5);
		match.put(6, 6);
		match.put(7, 3);
		match.put(8, 7);
		match.put(9, 6);
	}
}
