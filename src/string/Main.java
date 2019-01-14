package string;

import java.util.Scanner;
/**
 * Ѹ��д��ac�ˣ��´�������д
 * @author XZP
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ss = new String[n];
        for (int i = 0;i < n; i++) {
           ss[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
        	 if (is(ss[i])) {
                 System.out.println("YES");
             } else {
                 System.out.println("NO");
             }
        }
    }
    public static boolean is(String s) {
        int[] book = new int[3]; // 0,1,2�±�ֵ�ֱ��Ӧ�Ƿ������֣�Сд��ĸ����д��ĸ
        int length = s.length();
        if (length < 8) {
            return false;
        }
        for (int i =0; i < length;i++) {
            if (i == 0 && '0' <= s.charAt(0) && s.charAt(0) <= '9') {
                return false;
            }
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                book[0] = 1;
            } else if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                book[1] = 1;
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                book[2] = 1;
            }
        }
        int temp = 0;
        for (int i = 0; i < 3; i++) {
            temp += book[i];
        }
        if (temp < 2) {
            return false;
        }
        return true;
    }
}