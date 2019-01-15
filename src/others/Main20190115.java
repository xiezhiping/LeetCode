package others;

import java.util.Scanner;
public class Main20190115 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int q = 0;
        for (int i = 2; i <= n; i++) {
            if (isQ(i)) {
                sum++;
            }
        }
        System.out.println(sum);
    }
    public static boolean isQ(int q) {
        // ÅÐ¶ÏÊÇ·ñÂú×ã q = p^k
        for (int p = 2; p <= q; p++) {
            for (int k = 1;Math.pow(p, k) <= q; k++) {
                if (is(p) && Math.pow(p, k) == q) {
                    return true;
                }
            }
        }
        return false;
    }
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