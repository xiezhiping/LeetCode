package dfs;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * �Ҹ��������ӽڵ����С�������ڵ㣨�������Ĺ�ͬ���ڵ㣩
 * @author XZP
 * �����Һ��ӽڵ��ţ����ڵ���Ϊ0�����ӱ��Ϊ0���Һ���Ϊ1
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
		// Ϊ�������ͨ������value���ж��ڵ����
		Scanner sc = new Scanner(System.in);
		int v1 = sc.nextInt(); // ����Ƚϵ������ڵ�
		int v2 = sc.nextInt();
		leastParent(p1, v1, v2);
		
	}
	/**
	 * ��ȡ��С���ڵ��ֵ
	 * @param root һ�ö������ĸ��ڵ�
	 * @param v1 A��
	 * @param v2 B��
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
					System.out.println("��ͬ���ڵ�Ϊ���ڵ㣺" + root.value);
				} else {
					return -1; // ���ʱ��û�й�ͬ���ڵ�
				}
			} else {
				if (i + 1 < Math.min(len1, len2) && s1.charAt(i) == s2.charAt(i) && s1.charAt(i +  1) != s2.charAt(i + 1)) {
					
					// ʵ�ʵ��л�Ҫ�ҵ��������㣬������return֮ǰ�������iȥ��
					TreeNode nowNode = root;
					if (i == 0) {
						System.out.println("�ҵ���ͬ���ڵ㣺 " + nowNode.value);
					} else {
						for (int j = 1;; j++) {
							char now = s1.charAt(j);
							if (now == '0') {
								nowNode = nowNode.left;
							} else {
								nowNode = nowNode.right;
							}
							if (i == j) {
								System.out.println("�ҵ���ͬ���ڵ㣺 " + nowNode.value);
								break;
							}
						}	
					}
					return i; // ��ͬ���ڵ����ڵķ���˳��
				}
			}
		}
		return -1; // ����-1��ʾû�й������ڵ�
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
				result.put(node.left.value, pre + "0"); // ���ӱ��0
			}
			if (node.right != null) {
				stack.push(node.right);
				result.put(node.right.value, pre + "1");
			}
		}
		return result;
	}
}
// ����һ�����ڵ����ݽṹ
class Tree {
	int value;
	Tree left;
	Tree right;
	public Tree(int value) {
		this.value = value;		
	}
}
