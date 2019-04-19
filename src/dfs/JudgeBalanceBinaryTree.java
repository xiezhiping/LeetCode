package dfs;

/**
 * 判断一个树是否是平衡二叉树
 * @author XZP
 * 
 *思路：从父节点开始迭代，采用后序遍历的方式，如果左右两子树满足平衡二叉树，那么父节点高度为孩子节点的最大高度+1,注意到孩子节点如果为空会有
 *空指针异常。
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
	 * 判断一棵树是否是平衡二叉树的方法
	 */
	public static boolean isBalance(TreeNode root) {
		root.heigh = 0; // 当前节点的高度
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
		} else if (root.right == null && root.left == null) { // 如果没有孩子节点，此时父节点高度为1
			root.heigh = 1;
			return true;
		}
		return false;
	}
}
// 定义一个树节点数据结构
class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	int heigh; // 记录当前高度
	public TreeNode(int value) {
		this.value = value;		
	}
}
