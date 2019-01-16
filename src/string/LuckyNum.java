package string;

import java.util.Scanner;
public class LuckyNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int INF = 1000000000;
        if ((1 <= a && a <= INF && a <= b && b <= INF) == false) {
            System.out.println(-1);
        } else {
        	int sum = 0;
            for (int i = a; i <= b; i++) {
                if(is(i) == true) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
    // 判断一个数是不是幸运数
    public static boolean is (int n) {
        String s = n + "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '6' || s.charAt(i) == '8') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}