package others;


import java.util.Scanner;
public class Main20190115 {
    public static boolean[] isWP = new boolean[10001]; // �洢�Ƿ����������飬true��ʾ�±�ֵ��Ӧ��������
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int q = 0;
        for (int i = 1; i <= n; i++) {
            if (is(i)) {
                isWP[i] = true;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isQ(i)) {
                sum++;
            }
        }
        System.out.println(sum);
    }
    public static boolean isQ(int q) {
        // �ж��Ƿ����� q = p^k
        for (int p = 2; p <= q; p++) {
            for (int k = 1;; k++) {
            	int result = (int)Math.pow(p, k);
            	if (result > q) {
            		break;
            	}
                if (result == q && isWP[p]) {
                    return true;
                }
            }
        }
        return false;
    }
    // �ж��Ƿ��������ķ���
    public static boolean is (int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}