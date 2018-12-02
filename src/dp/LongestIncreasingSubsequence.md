# 动态规划经典问题二：最长增长子序列（Longest Increasing Subsequence）
## 题目描述
广场上站着一支队伍，她们是来自全国各地的扭秧歌代表队，现在有她们的身高数据，请你帮忙找出身高依次递增的子序列。 例如队伍的身高数据是（1、7、3、5、9、4、8），其中依次递增的子序列有（1、7），（1、3、5、9），（1、3、4、8）等，其中最长的长度为4。
### 输入描述:
输入包含多组数据，每组数据第一行包含一个正整数n（1≤n≤1000）。

紧接着第二行包含n个正整数m（1≤n≤10000），代表队伍中每位队员的身高。
### 输出描述:
对应每一组数据，输出最长递增子序列的长度。
### 示例1
#### 输入
> 7

> 1 7 3 5 9 4 8

> 6

> 1 3 5 2 4 6

#### 输出
> 4

> 4
## 解题

在一列数中寻找一些数，这些数满足：任意两个数a[i]和a[j]，若i<j，必有a[i]<a[j]，这样最长的子序列称为最长递增（上升）子序列。
设dp[i]表示以i为结尾的最长递增子序列的长度，则状态转移方程为：dp[i] = max{dp[j]+1}, 1<=j<i,a[j]<a[i].时间复杂度为O(n*n)；

考虑两个数a[x]和a[y]，x<y且a[x]<a[y],且dp[x]=dp[y]，那么我们该选择哪个呢？显然a[x],因为它更有潜力，也就是说我们可以用a[x]来替换掉a[y]，也就是说我们需要维护一个数据结构来存储可能的递增子序列的元素，并且需要在某些时候进行替换。因此我们可以用一个链表来存储，并且在查找替换位置的时候用二分查找来实现，这样时间复杂度为O(nlogn)。

```
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

```