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
		int a, b, c; // a城到b城的花销c
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 城市总数
		int m = sc.nextInt(); // 道路总数
		int[][] cost = new int[n + 1][n + 1]; // cost[i][j]表示i城市到j城市话费银子的数目
		Cost[] costs = new Cost[m + 1]; // 开销数组
		int[] f = new int[n + 1]; // 存储每个节点的父节点
		initCost(cost, n); // 初始化开销数组
		initF(f, n);
		for (i = 1; i <= m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			costs[i] = new Cost(a, b, c); // 将costs的每个索引值指向一个Cost对象
			cost[a][b] = c;
		}
		sort(costs, 1, m); // 根据消耗大小将路线按从小到大排序
		
	}
	/**
	 * 使用快速排序将costs数组进行排序
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
	/**
	 * 初始化梁城市之间的花销
	 * @param cost
	 * @param n
	 */
	public static void initCost(int[][] cost, int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1;j <= n;j++) {
				cost[i][j] = 0;
			}
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
