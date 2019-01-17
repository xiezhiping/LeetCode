package string;

/**
 * ��������
 * ���ʱ��43ms��ʱ�临�Ӷ�O(logN)
 * �ر�ע����ǣ�ĳ����+=������ͨ���Ĵ����򵥵ļӼ�ָ������Ż�20ms���ң���Ҳ�����Ҹ���ע�����Լ��Ĵ��뾡����ˬ��࣬�Ա���������
 */
import java.util.Scanner;
public class ImprovedLuckyNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int INF = 1000000000;
        int[] before = new int[512];
        int[] after = new int[512];
        if ((1 <= a && a <= INF && a <= b && b <= INF) == false) {
            System.out.println(-1);
        } else {
        	int sum = 0;
            for (int i = 1; i <= 9; i++) {	
            	int length = (int)Math.pow(2, i); // ��������ж��ٸ���������
            	// �жϳ�����Χ�����˳���
            	if (Math.pow(10, i) > b) {
            		break;
            	}
            	if (i == 1) {
            		before[0] = 6;
            		before[1] = 8;
            		after[0] = 6;
            		after[1] = 8;
            	} else {
            		int b_l = (int)Math.pow(2, i - 1); // ��ʾbefore����İ�����Чֵ�ĳ���
            		for (int k = 0; k < b_l; k++) {
            			after[k] = before[k] * 10 + 6;
            			after[k + b_l] = before[k] * 10 + 8;
            		}
            	}
            	
            	// Ѱ�Һ��ʵ���
            	for (int j = 0; j < length; j++) {
            		if (after[j] >= a && b >= after[j]) {
            			sum++;
            		}
            		// �ǵø���before���飬���ڵ���
            		before[j] = after[j];
//            		after[j] = INF + 1;
            	}
            }
            System.out.println(sum);
        }
    }
}