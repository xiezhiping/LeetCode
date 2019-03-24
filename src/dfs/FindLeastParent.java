package dfs;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * 找给定任意子节点的最小公共父节点（深度最深的共同父节点）
 * @author XZP
 * 给左右孩子节点编号，根节点编号为0，左孩子编号为0，右孩子为1
 */
public class FindLeastParent {

	public static void main(String[] args) {
		TreeNode p1 = new TreeNode(1);
		TreeNode p2 = new TreeNode(2);
		TreeNode p3 = new TreeNode(3);
		TreeNode p4 = new TreeNode(4);
		TreeNode p5 = new TreeNode(5);
		TreeNode p6 = new TreeNode(6);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.right = p6;
		// 为简化起见，通过两个value来判定节点相等
		Scanner sc = new Scanner(System.in);
		int v1 = sc.nextInt(); // 输入比较的两个节点
		int v2 = sc.nextInt();
		leastParent(p1, v1, v2);
		
	}
	/**
	 * 获取最小父节点的值
	 * @param root 一棵二叉树的根节点
	 * @param v1 A点
	 * @param v2 B点
	 * @return
	 */
	public static int leastParent(TreeNode root, int v1, int v2) {
		HashMap<Integer, String> result = dfs(root, v1, v2);
		String s1 = result.get(v1);
		String s2 = result.get(v2);
		System.out.println("s1: " + s1 + " s2:" + s2);
		int len1 = s1.length();
		int len2 = s2.length();
		for (int i = 0; i < Math.min(len1, len2); i++) {
			if (len1 < 2 || len2 < 2) {
				if (s1.charAt(0) == s2.charAt(0)) {
					System.out.println("共同父节点为根节点：" + root.value);
				} else {
					return -1; // 这个时候没有共同父节点
				}
			} else {
				if (i + 1 < Math.min(len1, len2) && s1.charAt(i) == s2.charAt(i) && s1.charAt(i +  1) != s2.charAt(i + 1)) {
					
					// 实际当中还要找到这个父结点，所以在return之前，用这个i去找
					TreeNode nowNode = root;
					if (i == 0) {
						System.out.println("找到共同父节点： " + nowNode.value);
					} else {
						for (int j = 1;; j++) {
							char now = s1.charAt(j);
							if (now == '0') {
								nowNode = nowNode.left;
							} else {
								nowNode = nowNode.right;
							}
							if (i == j) {
								System.out.println("找到共同父节点： " + nowNode.value);
								break;
							}
						}	
					}
					return i; // 共同父节点所在的访问顺序
				}
			}
		}
		return -1; // 返回-1表示没有公共父节点
	}
	public static HashMap<Integer, String> dfs(TreeNode root, int v1, int v2) {
		if (root == null) {
			return null;
		}
		HashMap<Integer, String> result = new HashMap<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		result.put(root.value, "0");
		while(stack.isEmpty() == false) {
			TreeNode node = stack.pop();
			String pre = result.get(node.value);
			if (node.left != null) {
				stack.push(node.left);
				result.put(node.left.value, pre + "0"); // 左孩子编号0
			}
			if (node.right != null) {
				stack.push(node.right);
				result.put(node.right.value, pre + "1");
			}
		}
		return result;
	}
}
// 定义一个树节点数据结构
class Tree {
	int value;
	Tree left;
	Tree right;
	public Tree(int value) {
		this.value = value;		
	}
}
