package dp;
import java.util.*;

public class Palindrome {
    public String addToPalindrome(String A, int n) {
        // write code here
        String dp = String.valueOf(A.charAt(0)); // 要添加进去的字符
        boolean flag = true;
        for (int i = 1; i < n - 1; i++) { // 最后一个字符不算进去
            if (A.charAt(i+1) == A.charAt(i) && flag) {
                dp = dp;
                flag = false;
            } else {
                dp =  String.valueOf(A.charAt(i)) + dp;
            }
            
        }
        return dp;
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(sc.hasNext()) {
    		String A = sc.nextLine();
    		int n = sc.nextInt();
    		System.out.println(new Palindrome().addToPalindrome(A, n));
    	}
    }
}