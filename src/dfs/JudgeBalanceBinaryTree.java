package dfs;

/**
 * �ж�һ�����Ƿ���ƽ�������
 * @author XZP
 * 
 *˼·���Ӹ��ڵ㿪ʼ���������ú�������ķ�ʽ�������������������ƽ�����������ô���ڵ�߶�Ϊ���ӽڵ�����߶�+1,ע�⵽���ӽڵ����Ϊ�ջ���
 *��ָ���쳣��
 */
public class JudgeBalanceBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println(isBalance(p1));
	}
	/*
	 * �ж�һ�����Ƿ���ƽ��������ķ���
	 */
	public static boolean isBalance(TreeNode root) {
		root.heigh = 0; // ��ǰ�ڵ�ĸ߶�
		return isBalance(root, root.heigh);
	}
	public static boolean isBalance(TreeNode root, int height) {
		if (root == null) {
			return true;
		}
		if (root.left != null && root.right != null 
				&& isBalance(root.left, root.left.heigh) 
				&& isBalance(root.right, root.right.heigh)) {
			if (root.left.heigh - root.right.heigh <= 1 && root.left.heigh - root.right.heigh >= -1) {
				root.heigh = root.left.heigh > root.right.heigh ? root.left.heigh + 1 : root.right.heigh + 1;
				return true;
			}
		} else if (root.left != null && isBalance(root.left, root.left.heigh)) {
			if (root.left.heigh <= 1) {
				root.heigh = root.left.heigh + 1;
				return true;
			}
		} else if (root.right != null && isBalance(root.right, root.right.heigh)) {
			if (root.right.heigh <= 1) {
				root.heigh = root.right.heigh + 1;
				return true;
			}
		} else if (root.right == null && root.left == null) { // ���û�к��ӽڵ㣬��ʱ���ڵ�߶�Ϊ1
			root.heigh = 1;
			return true;
		}
		return false;
	}
}
// ����һ�����ڵ����ݽṹ
class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	int heigh; // ��¼��ǰ�߶�
	public TreeNode(int value) {
		this.value = value;		
	}
}
