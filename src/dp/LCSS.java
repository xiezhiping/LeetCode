package dp;

import java.util.Date;
import java.util.Scanner;

public class LCSS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str1 = sc.next();
			String str2 = sc.next();
			long start = System.currentTimeMillis();
			int m = str1.length();
			int n = str2.length();
			boolean flag = str1.charAt(0) == str2.charAt(0);
			System.out.println(num(str1,str2,m-1,n-1, flag));
			System.out.println(System.currentTimeMillis()-start);
		}
	}
    public static int num(String str1, String str2, int m, int n, boolean flag) {
        if (m < 1 || n < 1) {
        	if (flag) {
        		return 1;
        	}
        	else {
        		return 0;
        	}
        }
        if (str1.charAt(m) == str2.charAt(n)) {
            return num(str1, str2, m-1, n-1, flag) +1;
        } else {
            return Math.max(num(str1, str2, m-1, n, flag),num(str1, str2, m, n-1, flag));
        }
    }
}
