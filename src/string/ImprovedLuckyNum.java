package string;

/**
 * 幸运数字
 * 最佳时间43ms，时间复杂度O(logN)
 * 特别注意的是，某几个+=操作，通过寄存器简单的加减指令，可以优化20ms左右，这也是让我更加注重让自己的代码尽量清爽简洁，以便于提升！
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
            	int length = (int)Math.pow(2, i); // 这个区段有多少个这样的数
            	// 判断超过范围即可退出了
            	if (Math.pow(10, i) > b) {
            		break;
            	}
            	if (i == 1) {
            		before[0] = 6;
            		before[1] = 8;
            		after[0] = 6;
            		after[1] = 8;
            	} else {
            		int b_l = (int)Math.pow(2, i - 1); // 表示before数组的包含有效值的长度
            		for (int k = 0; k < b_l; k++) {
            			after[k] = before[k] * 10 + 6;
            			after[k + b_l] = before[k] * 10 + 8;
            		}
            	}
            	
            	// 寻找合适的数
            	for (int j = 0; j < length; j++) {
            		if (after[j] >= a && b >= after[j]) {
            			sum++;
            		}
            		// 记得更新before数组，用于迭代
            		before[j] = after[j];
//            		after[j] = INF + 1;
            	}
            }
            System.out.println(sum);
        }
    }
}