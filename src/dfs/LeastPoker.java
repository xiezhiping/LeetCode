package dfs;

import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class LeastPoker {
	public static int num = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		getLeastPoger(arr, 0);
		System.out.println(num);
	}
	public static void getLeastPoger(int[] arr, int ans) {
		int i = 0;
		// num = Math.max(num, ans);
		for (;i < 10; i++) {
			if (arr[i] > 0) {
				break;
			}
		}
		if (i == 10) {
			num = Math.min(num, ans);
			return;
		}
			// 三对
			if (i < 8 && arr[i] > 1 && arr[i+1] > 1 && arr[i+2] > 1) {
				arr[i]-=2;
				arr[i+1]-=2;
				arr[i+2]-=2;
				getLeastPoger(arr, ans+1);
			}
			// 五张顺子
			if (i < 6 && arr[i] > 0 && arr[i+1] > 0 && arr[i+2] > 0
					&& arr[i+3] > 0 && arr[i+4] > 0) {
				arr[i]-=1;
				arr[i+1]-=1;
				arr[i+2]-=1;
				arr[i+3]-=1;
				arr[i+4]-=1;
				getLeastPoger(arr, ans+1);
			}
			// 对子
			if (arr[i] >1) {
				arr[i]-=2;
				getLeastPoger(arr, ans+1);
			}
			// 单牌
			if (arr[i] > 0) {
				arr[i]-=1;
				getLeastPoger(arr, ans+1);
			}
	}

}
