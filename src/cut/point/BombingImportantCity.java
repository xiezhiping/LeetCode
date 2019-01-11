package cut.point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.text.AsyncBoxView.ChildState;

/**
 * "��ը��Ҫ����"���⣺
 * ���赱ǰ����ӵ��һ�� �����ĳ��е�ͼ������ֻ��һ��ԭ�ӵ���Ϊ�������ԭ�ӵ���������Ч����Ҫ����������������������ؼ���һ����ͨҪ������ô���ԭ�ӵ���Ͷ�������
 * ��ʵ����ԭ�ӵ��Ͳ��ῼ����ô���ˣ�~����~�����������⡣��������ģ�ͻ�֮�󣬾��������Ǵ�һ��������ͨͼ��ѡ��һ������㡱��ȥ�������֮�󣬲�������ͨͼ��
 * �ؼ��ʣ�DFS����㡢������ͨͼ����Ҫ����
 * ����˵������Щ�����Ĳ����Ƚ϶࣬��Ҫ����β�����һЩȫ�־�̬�������������Ծ�ȫ��ͨ�����ν����
 * @author XZP
 *һ��������ݣ�
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
		int INF = 99999; // ��Ϊ�趨�����ֵ
		Scanner sc = new Scanner(System.in);
		int i; // �α�
		int v1, v2; //��ʱ�洢����������ı��
		int n = sc.nextInt(); // ������
		int m = sc.nextInt(); // �ߵ�����
//		Edge[] edges = new Edge[m + 1]; // �洢�ߵ����飬�±��1��ʼ
		int[][] edges = new int[n + 1][n +1]; // ��űߵ��ڽӾ���
		int[] num = new int[n + 1]; // �洢��һ��Ӷ���1dfs��������µ�ʱ����������±�������ţ�ֵ��ʾ�ڼ������ʵ���ʱ�����
		int[] low = new int [n + 1]; // ��ʾÿ�������ڲ������������ܻص�����Сʱ������Ƚ��ֿڣ����¿������Ϊ������num�����ҵ����ڵ㣬Ȼ����dfs�������ܹ��ﵽ����Сʱ�����
		// ��ʼ��low���飬�Ƚ���Ҫ
		for (i = 1; i <= n; i++) {
			low[i] = INF;
		}
		
		// ����m����
		for (i =1; i <= m; i++) {
			v1 = sc.nextInt();
			v2 = sc.nextInt();
			edges[v1][v2] = 1; // ������Ϊ���ʾ����֮�䲻�ɴ����������
			edges[v2][v1] = 1; // ����ͼ�Գ�
		}
		// ��num���飨ÿ�������Ӧ��ʱ�����
		dfs(1, edges, num, n, low);
		
		// �õ����
		int cutPoint = judgeCutPoint(low, edges, n, num, 1);
		if (cutPoint == 0) {
			System.out.println("û�и�㣡");
		} else {
			System.out.println("�����Ϊ�� " + cutPoint);
		}
	}
	/**
	 * �Ե�ǰ�ڵ�Ϊ��ʼ���ų����ڵ�������������ȱ����Ի�ȡ��ǰ���ܷ��ʵ���Сʱ���
	 * @param low �����㡢���µ���С����ʱ���
	 * @param child ��ǰ�ڵ�
	 * @param parent ��ǰ�ڵ�ĸ��ڵ㣨����num�������ģ�
	 * @param edges �ߵ��ڽӾ���
	 * @param num ʱ�������
	 * @param n �������
	 */
	public static void dfsExParent(int[] low, int child,int parent, int[][] edges, int[] num, int n, int start) {
		int[] book = new int[n + 1]; // �����ж�һ�������Ƿ��Ѿ����ŵ�ջ����ȥ���ˣ����⻷����Ĵ���
		Stack<Integer> search = new Stack<Integer>();
		search.push(child);
		book[child] = 1;
		while (!search.isEmpty()) {
			// ���ȴ�ջ��ȥһ��Ԫ�أ�����������������Ķ�����ջ
			int top = search.pop();
			// �ø�С��ʱ����滻��
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
	 * �ж�һ�����Ƿ��Ǹ��ķ���
	 * @param low low���飬�洢��ǰ�ڵ��ڲ��������ڵ��������ܹ����ʽڵ����Сʱ���
	 * @param edges �ߵ��ڽӾ���
	 * @param n �������
	 * @param num ʱ�������
	 * @param start ��ʼ��
	 * @return
	 */
	public static int judgeCutPoint(int[] low, int[][] edges, int n, int[] num, int start) {
		for (int i = 1; i <= n; i++) { // ���μ���ڵ�i��low[i]ֵ
			int parent = findParent(i, num, n);
			// �ų������ڵ������£�ʹ��dfs����������������ʱ���ֵ�ø�С���滻���ʱ���ֵ�����ϸ���low[i]��ֵ
			dfsExParent(low, i, parent, edges, num, n, start);
			if (i != start && low[i] >= num[parent]) { // Ҫע���ų���ʼ�㣬��������ڵ�һ���㴦�ͷ����ˣ���Ȼ���ǲ��Ե�
				// ��Ҫ�ж��Ƿ��Ǹ��ڵ�
				if (i != start) {
					return parent;
				} else {
					// �жϸ��ڵ����������������ӣ�����������û�������ɴﵽ�ĵ�����·��������²��Ǹ��
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
		// ���㺢����
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
		int[] book = new int[n + 1]; // �����ж�һ�������Ƿ��Ѿ����ŵ�ջ����ȥ���ˣ����⻷����Ĵ���
		Stack<Integer> search = new Stack<Integer>();
		search.push(a);
		book[a] = 1;
		while (!search.isEmpty()) {
			// ���ȴ�ջ��ȥһ��Ԫ�أ�����������������Ķ�����ջ
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
	 * ����ʱ���������һ���ڵ�ĸ��ڵ�
	 * @param i ��ǰ�ڵ���
	 * @param num ʱ�������
	 * @param n �������
	 * @return ��ȷ����·��ظ��ڵ�ı�ţ��������Ϊ0��ʾ�����ˣ�
	 */
	public static int findParent(int i, int[] num, int n) {
		if (num[i] == i) {
			return i;
		} else {
			int parent = num[i] - 1; // ���ڵ��ʱ���Ϊ��ǰ��ʱ�����һ
			for (int j = 1; j <= n; j++) {
				if (num[j] == parent) {
					return j;
				}
			}
			return 0; // ��һ�ֳ���ķ���
		}
	}
	/**
	 * ����num�����dfs����
	 * @param start ��ʼ��
	 * @param edges ������
	 * @param num num����
	 * @param n �������
	 */
	public static void dfs(int start, int[][] edges, int[] num, int n, int[] low) {
		int[] book = new int[n + 1]; // �����ж�һ�������Ƿ��Ѿ����ŵ�ջ����ȥ���ˣ����⻷����Ĵ���
		int number = 1; // �����ʵ��ı��
		Stack<Integer> search = new Stack<Integer>();
		search.push(start);
		book[start] = 1;
		while (!search.isEmpty()) {
			// ���ȴ�ջ��ȥһ��Ԫ�أ�����������������Ķ�����ջ
			int top = search.pop();
			num[top] = number; // Ϊnum���鸳ֵ
			low[top] = number; // �ʼ�����Լ�
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

//***********ʵ��֤�������ִ洢��ʽ��ĳЩ����±Ƚ��Ż�����������dfs�����ҵ���һ�����㣬��û������ڽӾ���*******************
/**
 * ��ʾһ���ߵĶ���
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
