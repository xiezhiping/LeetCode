package cut.point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.text.AsyncBoxView.ChildState;

/**
 * "轰炸重要城市"问题：
 * 假设当前我们拥有一个 地区的城市地图，但是只有一个原子弹，为了让这颗原子弹发挥最大的效果，要阻断这个地区各个城市中最关键的一个交通要塞，那么这个原子弹该投放在哪里？
 * 其实真有原子弹就不会考虑这么多了（~……~），扯回正题。这种问题模型化之后，就是让我们从一个无向连通图中选择一个“割点”，去掉这个点之后，不再是连通图。
 * 关键词：DFS、割点、无向连通图、重要城市
 * 特殊说明：有些方法的参数比较多，主要是这次不想用一些全局静态变量来处理，所以就全部通过传参解决！
 * @author XZP
 *一组测试数据：
6 7 
1 4 
1 3 
4 2
3 2
2 5 
2 6
5 6
 */
public class BombingImportantCity {

	public static void main(String[] args) {
		int INF = 99999; // 人为设定的最大值
		Scanner sc = new Scanner(System.in);
		int i; // 游标
		int v1, v2; //暂时存储边两个顶点的编号
		int n = sc.nextInt(); // 顶点数
		int m = sc.nextInt(); // 边的条数
//		Edge[] edges = new Edge[m + 1]; // 存储边的数组，下标从1开始
		int[][] edges = new int[n + 1][n +1]; // 存放边的邻接矩阵
		int[] num = new int[n + 1]; // 存储第一遍从顶点1dfs遍历情况下的时间戳，数组下标代表顶点编号，值表示第几个访问到（时间戳）
		int[] low = new int [n + 1]; // 表示每个顶点在不经过父顶点能回到的最小时间戳（比较拗口，大致可以理解为：根据num数组找到父节点，然后用dfs遍历，能够达到的最小时间戳）
		// 初始化low数组，比较重要
		for (i = 1; i <= n; i++) {
			low[i] = INF;
		}
		
		// 读入m条边
		for (i =1; i <= m; i++) {
			v1 = sc.nextInt();
			v2 = sc.nextInt();
			edges[v1][v2] = 1; // 其他都为零表示两点之间不可达或者是自身
			edges[v2][v1] = 1; // 无向图对称
		}
		// 求num数组（每个顶点对应的时间戳）
		dfs(1, edges, num, n, low);
		
		// 得到割点
		int cutPoint = judgeCutPoint(low, edges, n, num, 1);
		if (cutPoint == 0) {
			System.out.println("没有割点！");
		} else {
			System.out.println("割点编号为： " + cutPoint);
		}
	}
	/**
	 * 以当前节点为起始点排除父节点的情况下深度优先遍历以获取当前点能访问的最小时间戳
	 * @param low 待计算、更新的最小访问时间戳
	 * @param child 当前节点
	 * @param parent 当前节点的父节点（根据num矩阵来的）
	 * @param edges 边的邻接矩阵
	 * @param num 时间戳矩阵
	 * @param n 顶点个数
	 */
	public static void dfsExParent(int[] low, int child,int parent, int[][] edges, int[] num, int n, int start) {
		int[] book = new int[n + 1]; // 用于判断一个顶点是否已经被放到栈里面去过了，避免环引起的错误
		Stack<Integer> search = new Stack<Integer>();
		search.push(child);
		book[child] = 1;
		while (!search.isEmpty()) {
			// 首先从栈顶去一个元素，并将这个顶点相连的顶点入栈
			int top = search.pop();
			// 用更小的时间戳替换掉
			if (num[top] < low[child]) {
				low[child] = num[top];
			}
			for (int i = 1; i <=n; i++) {
				if (i !=parent && edges[top][i] == 1 && book[i] == 0) {
					search.push(i);
					book[i] = 1;
				} else if (parent == start && i == start && edges[top][i] == 1 && book[i] == 0) {
					search.push(i);
					book[i] = 1;
					break;
				}
			}
		}
	}
	/**
	 * 判断一个点是否是割点的方法
	 * @param low low数组，存储当前节点在不经过父节点的情况下能够访问节点的最小时间戳
	 * @param edges 边的邻接矩阵
	 * @param n 顶点个数
	 * @param num 时间戳数组
	 * @param start 起始点
	 * @return
	 */
	public static int judgeCutPoint(int[] low, int[][] edges, int n, int[] num, int start) {
		for (int i = 1; i <= n; i++) { // 依次计算节点i的low[i]值
			int parent = findParent(i, num, n);
			// 排除掉父节点的情况下，使用dfs遍历，将遍历到的时间戳值用更小的替换大的时间戳值，不断更新low[i]的值
			dfsExParent(low, i, parent, edges, num, n, start);
			if (i != start && low[i] >= num[parent]) { // 要注意排除起始点，否则程序在第一个点处就返回了，显然这是不对的
				// 还要判断是否是根节点
				if (i != start) {
					return parent;
				} else {
					// 判断根节点且至少有两个孩子，这两个孩子没有其他可达到的的其他路径的情况下才是割点
					if (isRootCutPoint(edges, start, n)) {
						return start;
					}
				}
			}
		}
		return 0;
	}
	public static boolean isRootCutPoint(int[][] edges, int root, int n) {
		boolean flag = false;
		List<Integer> child = new ArrayList<>();
		// 计算孩子数
		for (int i = 1; i <= n; i++) {
			if (edges[root][i] == 1) {
				child.add(i);
			}
		}
		int size = child.size();
		for (int i = 0; i< size; i++) {
			for (int j = i + 1; j < size; j ++) {
				if (!isReachable(child.get(i), child.get(j), edges, n, root)) {
					return true;
				}
			}
		}
		return flag;
	}
	public static boolean isReachable(int a, int b, int[][] edges, int n, int root) {
		int[] book = new int[n + 1]; // 用于判断一个顶点是否已经被放到栈里面去过了，避免环引起的错误
		Stack<Integer> search = new Stack<Integer>();
		search.push(a);
		book[a] = 1;
		while (!search.isEmpty()) {
			// 首先从栈顶去一个元素，并将这个顶点相连的顶点入栈
			int top = search.pop();
			if (top == b) {
				return true;
			}
			for (int i = 1; i <=n; i++) {
				if (i != root && edges[top][i] == 1 && book[i] == 0) {
					search.push(i);
					book[i] = 1;
				}
			}
		}
		return false;
	}
	/**
	 * 根据时间戳数组找一个节点的父节点
	 * @param i 当前节点编号
	 * @param num 时间戳数组
	 * @param n 顶点个数
	 * @return 正确情况下返回父节点的编号，如果返回为0表示出错了！
	 */
	public static int findParent(int i, int[] num, int n) {
		if (num[i] == i) {
			return i;
		} else {
			int parent = num[i] - 1; // 父节点的时间戳为当前的时间戳减一
			for (int j = 1; j <= n; j++) {
				if (num[j] == parent) {
					return j;
				}
			}
			return 0; // 是一种出错的返回
		}
	}
	/**
	 * 计算num数组的dfs方法
	 * @param start 起始点
	 * @param edges 边数组
	 * @param num num数组
	 * @param n 顶点个数
	 */
	public static void dfs(int start, int[][] edges, int[] num, int n, int[] low) {
		int[] book = new int[n + 1]; // 用于判断一个顶点是否已经被放到栈里面去过了，避免环引起的错误
		int number = 1; // 被访问到的编号
		Stack<Integer> search = new Stack<Integer>();
		search.push(start);
		book[start] = 1;
		while (!search.isEmpty()) {
			// 首先从栈顶去一个元素，并将这个顶点相连的顶点入栈
			int top = search.pop();
			num[top] = number; // 为num数组赋值
			low[top] = number; // 最开始就是自己
			number++;
			for (int i = 1; i <=n; i++) {
				if (edges[top][i] == 1 && book[i] == 0) {
					search.push(i);
					book[i] = 1;
				}
			}
		}
	}
}

//***********实践证明：这种存储方式在某些情况下比较优化，但是由于dfs便于找到下一个顶点，最好还是用邻接矩阵*******************
/**
 * 表示一条边的对象
 * @author XZP
 *
 */
class Edge {
	private int v1;
	private int v2;
	public Edge(int v1, int v2) {
		this.v1 = v1;
		this.v2 = v2;
	}
	// getter
	public int getV1() {
		return v1;
	}
	public int getV2() {
		return v2;
	}
}
