package dp;

import java.util.Scanner;
public class LongestIncreasingSubsequence {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     while(sc.hasNext()) {
         int n = sc.nextInt();
         int[] nums = new int[n];
         for(int i = 0;i < n; i++) { // 输入存为整型数组
             nums[i] = sc.nextInt();
         }
         System.out.println(length(nums));
     }
 }
 public static int length(int[] nums) {
     if (nums == null || nums.length < 1) { // 如果数组不存在的边界要考虑，return 0
         return 0;
     }
     int max = 1;
     int n = nums.length;
     int[] dp = new int[n];
     for(int i = 0; i < n; i++) {
         dp[i] = 1; // 初始化dp[i]
         for (int j = 0; j < i; j++) {
             if (nums[i] > nums[j]) {
                 dp[i] = Math.max(dp[i], dp[j]+1); // 更新i处结尾的最长递增子序列的长度
                 max = Math.max(dp[i], max); // 在所有值中维护一个最大值，循环完毕之后为最终所求结果
             }
         }
     }
     return max;
 }
}
