package Intern;

import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ���Ը���
		int[] result = new int[N];
		for (int k = 0; k < N; k++) {
			int num = sc.nextInt(); // �μӱ���������
			int[] grade = new int[num+1]; // ��ʾ��i���˶�Ӧ�ķ���
			for (int i = 1; i <= num; i++) {
				grade[i] = sc.nextInt();
			}
			result[k] = dp(num, grade);
		}
		for (int k = 0; k < N; k++) {
			System.out.println(result[k]);
		}
	}
	public static int dp(int num, int[] grade) {
		int[] dp = new int[num+1]; // ��ʾ����i�����ٵý���
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 1; i <= num; i++) {
			dp[i] = 1; // ��ʼ��
		}
		int left = 0; // ���������˵�����
		int right = 0;
		for (int i = 1; i <= num; i++) {
			if (i == 1 && num >=2) {
				left = num;
				right = i + 1;
			} else if (i == num && i >= 1) {
				left = num - 1;
				right = 1;
			} else {
				left = i - 1;
				right = i + 1;
			}
			if (grade[i] > grade[left] && grade[i] <= grade[right]) {
				dp[i] = grade[left] + 1;
			} else if (grade[i] > grade[left] && grade[i] > grade[right]) {
				dp[i] = Math.max(dp[left], dp[right]) + 1;
			} else if (grade[i] > grade[right] && grade[i] <= grade[left]) {
				dp[i] = grade[right] + 1;
			}
		}
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum+= dp[i];
		}
		return sum;
	}
}

