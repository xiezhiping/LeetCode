# 动态规划（Dynamic Programming）
## 题目描述
我们有两个字符串m和n，如果它们的子串a和b内容相同，则称a和b是m和n的公共子序列。子串中的字符不一定在原字符串中连续。
例如字符串“abcfbc”和“abfcab”，其中“abc”同时出现在两个字符串中，因此“abc”是它们的公共子序列。此外，“ab”、“af”等都是它们的字串。
现在给你两个任意字符串（不包含空格），请帮忙计算它们的最长公共子序列的长度。
### 输入描述：
输入包含多组数据。

每组数据包含两个字符串m和n，它们仅包含字母，并且长度不超过1024。
### 输出描述：
对应每组输入，输出最长公共子序列的长度。
### 实例
> 输入

>> abcfbc abfcab

>> programming contest

>> abcd mnp

> 输出
>> 4

>> 2

>> 0
## 解题思路

这道题，要想在本地测试通过自己的测试用例是不难的。但是要完全AC就要注意，作者就是因为踩了坑，所以才特地记录，并稍微深入找了下踩坑原因。先来说一下大致思路：

- 第一点，动态规划的老套路：画表格找规律。至于具体怎么画表格，作者也是半瓶水，这里不展开，不清楚的可以网上找资料，已经有比较多了，或者私信留言作者。
- 第二点，找边界条件（或者说出口条件）。因为动态规划往往是将大问题分成各个**不独立**的子问题，也就是说这个子问题总要有一个是最小的那个子问题，然后才去递归或者公式推导（这就需要上面的找规律结论）。一般来讲，出口条件也基本上是一些边界值，比如数组0,1
- 第三点，选择解题方法，主要有两种方式：（1）递归；（2）矩阵标记值，推导的方式。

拿这道题举例来说，假设m,n分别为字符串1（str1）和字符串2(str2)的长度, 设(m,n)表示str1前m个字符和str2前n个字符的最长子序列.通过找规律，发现要求(m,n),则先求解子问题。即这个问题转换为：当两个字符串长分别为m-1，n-1求得最长公共子序列，然后在各自添加一个字符，求解，即求解(m,n)。这样一来，问题被分成两个子问题，也就是两种情况，str1新添加的字符与str2新添加的字符是否相等？

### 相等的情况
(m,n) = (m-1,n-1) + 1（这个1，表示在原有基础上有多了一个相等字符，总数加1）

### 不相等的情况
通过规律发现，如果各自新加入一个字符字之后不相等，那么此时取该空格处左边、上边两处空格中的较大值（具体可以先去画个表格研究下），即(m,n) = max( (m-1,n), (m,n-1) )

分析完之后是不是比较清晰了呢？下面简要说一下两种解决此问题的方法：递归、矩阵标记值（为了好记）
#### 递归解题
自顶向下，比如让你求(m,n)，然后你要知道（m-1,n-1）(m-2,n-2)...这样逐层递归，知道上面说的跳出条件，这个递归才结束，最后以调用栈的方式逐层返回值
#### 矩阵标记值
自底向上。首先从边界值开始然后填满 dp（m,n）的矩阵，最后那个就是要求的值。

## 我的解题历程
- 首先，作者习惯用递归来解，所以一上来就用递归走了一波，代码如下：

```

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


```

但是后来一运行发现本地用例都ok，但是并没有AC，因为超时！
后来采用后者，原因是递归的话，每次计算的结果并没有保存下来，会反复计算（当然也可以通过其他方式优化），后来作者直接采用矩阵标记计算结果的方式，然后提交就AC了，直接上代码:

```
import java.util.Scanner;

public class LCSS2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str1 = sc.next();
			String str2 = sc.next();
			System.out.println(length(str1.toCharArray(), str2.toCharArray()));
		}
	}
	private static int length(char[] str1, char[] str2) {
		int m = str1.length;
		int n = str2.length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m;i++) {
			for (int j = 0;j < n; j++) {
				if ( i < 1) {
					if (str1[0] == str2[j] || str1[0] == str2[0]) {
						dp[i][j] = 1;
					} else {
						dp[i][j] =0;
					}
				} else if (j < 1) {
					if (str1[i] == str2[j] || str2[0] == str1[0] || dp[i-1][0] == 1) {
						dp[i][j] = 1;
					} else {
						dp[i][j] =0;
					}
				} else {
					if (str1[i] == str2[j]) {
						dp[i][j] = dp[i-1][j-1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
				
			}
		}
		return dp[m-1][n-1];
	}
}

```
## 踩坑总结

- 时间复杂度

- 边界值

适当注意一下边界值，有时候自己容易想当然的认为！