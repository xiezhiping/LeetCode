package disjointset;

import java.util.Scanner;

/**
 * 最小生成树问题
 * @author XZP
 * 一组测试用例
 6 9
2 4 11
3 5 13
4 6 3
5 6 4
2 3 6
4 5 7
1 2 1
3 4 9
1 3 2
 */
public class LongmenExpress {

	public static void main(String[] args) {
		int i = 0; // 循环计数变量
		int j = 1;
		int a, b, c; // a城到b城的花销c
		int count = 0; // 已经找到边的条数
		int sum = 0; // 最小生成树的开销总和
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 城市总数
		int m = sc.nextInt(); // 道路总数
		Cost[] costs = new Cost[m + 1]; // 开销数组
		int[] book = new int [m + 1]; // 存储costs数组中对应的边是否被纳入最小生成树
		int[] f = new int[n + 1]; // 存储每个节点的父节点
		initF(f, n);
		for (i = 1; i <= m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			costs[i] = new Cost(a, b, c); // 将costs的每个索引值指向一个Cost对象
//			merge(f, a, b);
		}
		sort(costs, 1, m); // 根据消耗大小将路线按从小到大排序
		for (; j <= m; j++  ) {
			a = costs[j].getA();
			b = costs[j].getB();
			c = costs[j].getC();
			// 判断两个点是否已经在一个阵营
			if (getF(a, f) != getF(b, f)) { // 这个地方注意一下，不要用f[a] != f[b]来判断，getF会根据调用栈，迭代更新，但是f[x]则不会，所以要用getF()函数判断
				merge(f, a, b);
				book[j] = 1;
				sum += c;
				count++; // 找到一条有效边即加一
			}
			if (count == n-1) {
				break;
			}
		}
		// 输出
		System.out.println("最小生成树总花销为：" + sum);
		for (i = 1; i <= m; i++) {
			if (book[i] == 1) {
				System.out.println("节点 " +costs[i].getA() +  " 到节点 " + costs[i].getB() + "， 这趟花销 " +costs[i].getC());
			}
		}
	}
	public static void merge(int[] f, int a, int b) {
		int t1, t2;
		// 获取两个节点的父节点
		t1 = getF(a, f);
		t2 = getF(b, f); // 懂了，从这里找到b的根节点，这就是所谓的擒贼先擒王！
		if (t1 != t2) { // 当两个节点不在一个阵营时，要根据靠左原则和擒贼先擒王原则将对应的节点信息更新
			f[t2] = t1; // 曾经自己写错过！！！！！错在忽视了擒贼擒王的道理，更新的值不是t1而是a
		}
	}
	/**
	 * 递归寻找节点x的父节点
	 * @param x
	 * @param f
	 * @return
	 */
	public static int getF(int x, int[] f) {
		if (f[x] == x) {
			return x;
		} else {
			f[x] = getF(f[x], f);
			return f[x];
		}
	}
	/**
	 * 使用快速排序将costs数组进行排序（快排时间复杂度O(MlogM)）
	 * @param costs
	 * @param low
	 * @param high
	 */
	public static void sort(Cost[] costs, int low, int high) {
		if (low > high) {
			return;
		}
		int i, j ;
		Cost temp;
		Cost t;
		temp = costs[low];
		i = low;
		j = high;
		while (i != j) {
			while(costs[j].getC() >= temp.getC() && i < j) {
				j--;
				}
			while (costs[i].getC() <= temp.getC() && i < j) {
				i++;
			}
			if (i < j) { // 交换两个对象的引用在数组中的位置
				t = costs[i];
				costs[i] = costs[j];
				costs[j] = t;
			}
		}
		// 最终将基准数归为
		costs[low] = costs[i];
		costs[i] = temp;
		sort(costs, low, i -1);
		sort(costs, i + 1, high);
	}
	/**
	 * 初始化每个节点的父节点为自身
	 * @param f
	 * @param n
	 */
	public static void initF(int[] f, int n) {
		for (int i =1; i <= n; i++) {
			f[i] = i;
		}
	}

}
// 定义一个开销结构体对象
class Cost {
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public int getC() {
		return c;
	}
	private int a; // 城市a
	private int b; // 城市b
	private int c; // a、b两城市之间的开销
	public Cost(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
