package string;

import java.util.Scanner;
public class ImprovedLuckyNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int INF = 1000000000;
        int[][] dp = new int[10][512]; // dp[i][j]表示当i的情况下有幸运数2的i次幂
        if ((1 <= a && a <= INF && a <= b && b <= INF) == false) {
            System.out.println(-1);
        } else {
        	int sum = 0;
            for (int i = 1; i <= 9; i++) {
            	for (int j = 0; j < Math.pow(2, i); j++) {
            		if (j == 0) {
            			dp[i][0] = 6;
            			dp[i][1] = 8;
            		} else {
            			
            		}
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