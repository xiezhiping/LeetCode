package dp;

import java.util.Scanner;
public class LongestIncreasingSubsequence {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     while(sc.hasNext()) {
         int n = sc.nextInt();
         int[] nums = new int[n];
         for(int i = 0;i < n; i++) { // �����Ϊ��������
             nums[i] = sc.nextInt();
         }
         System.out.println(length(nums));
     }
 }
 public static int length(int[] nums) {
     if (nums == null || nums.length < 1) { // ������鲻���ڵı߽�Ҫ���ǣ�return 0
         return 0;
     }
     int max = 1;
     int n = nums.length;
     int[] dp = new int[n];
     for(int i = 0; i < n; i++) {
         dp[i] = 1; // ��ʼ��dp[i]
         for (int j = 0; j < i; j++) {
             if (nums[i] > nums[j]) {
                 dp[i] = Math.max(dp[i], dp[j]+1); // ����i����β������������еĳ���
                 max = Math.max(dp[i], max); // ������ֵ��ά��һ�����ֵ��ѭ�����֮��Ϊ����������
             }
         }
     }
     return max;
 }
}
