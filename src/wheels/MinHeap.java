package wheels;

/**
 * 最小堆的简单实现
 * @author XZP
 * 一组测试数据： 12 45 -11 69 1 95 9 78 64 21
 */
public class MinHeap {
	private int INF = 9999999; // 认为规定的最大值
	private int[] arr;
	public MinHeap (int size) {
		arr = new int[size + 1]; // 下标从1开始
		for (int i = 0; i <= size; i++) { // 牺牲空间和一定时间来保证数组能存零值
			arr[i] = INF;
		}
	}
	/**
	 * 向最小堆中插入一个元素使其任然满足最小堆
	 * @param data 待插入数据
	 * @return 成功为true，失败将打印异常栈
	 */
	public boolean push(int data) {
		int index = this.index();
		try {
			this.arr[index] = data;
			siftup(index);  // 插入数组末尾之后需要向上调整使其满足最小堆
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * @return 数组能存储的最大size
	 */
	public int size() {
		return arr.length - 1;
	}
	/**
	 * 获取当前能插入值得数组下标
	 * @return 数组中已有值长度  + 1
	 */
	private int index() {
		int usedLength = 0;
		for (int i = 1; i <= this.size(); i++) {
			if (this.arr[i] != INF) {
				usedLength++;
			}
		}
		return usedLength + 1;
	}
	/**
	 * 从最小堆中取最小的那个元素，并调整使其一直满足最小堆
	 * @return 数组不为空则返回最小的元素，否则返回人为规定的INF值
	 */
	public int pop() {
		if (!isLegal(1)) { // 每次取第一个元素（下标值为1，而不是0）
			return INF;
		}
		int value = this.arr[1];
		int end = this.index() - 1; // 数组中最后一个有效元素
		if (!isLegal(end)) { // 这个元素不合法说明此时数组中只有索引为1这个值有效
			this.arr[1] = INF;
			return value;
		}
		this.arr[1] = this.arr[end]; // 将末尾有效值（层数最深最右边的叶子结点）置为根节点并向下调整
		this.arr[end] = INF;
		siftdown(1);
		return value;
	}
	/**
	 * 向上调整的方法
	 * @param i 待调整的孩子节点
	 */
	private void siftup(int i) {
		if (i <= 1) {
			return; // 1 左移一位是0了
		}
		int parent = i >> 1;
		boolean flag = true; // 是否需要调整
		while (parent >= 1 && flag) {
			if (this.arr[parent] > this.arr[i]) {
				swap(parent, i);
				parent = parent >> 1;
				siftup(parent);
			} else {
				flag = false;
			}
		}
	}
	/**
	 * 向下调整的方法
	 * @param i 待调整的节点下标
	 */
	private void siftdown (int i) {
		int parent = i;
		int left = this.left(i);
		int right = this.right(i);
		int min = this.getMin(left, right);
		boolean flag = true;
		while (parent <= this.size() / 2 && flag && isLegal(min)) {
			if (this.arr[min] < this.arr[i]) {
				swap(min, i);
				parent = min;
				siftdown(parent);
			} else {
				flag = false;
			}
		}
	}
	/**
	 * 获取根节点左孩子的下标值
	 * @param i
	 * @return
	 */
	private int left(int i) {
		return i << 1;  //左孩子的坐标为右移一位
	}
	/**
	 * 获取根节点右孩子的的下标值
	 * @param i
	 * @return
	 */
	private int right(int i) {
		return (i << 1) + 1; // 右孩子为右移一位 + 1
	}
	/**
	 * 获取值较小的下标值
	 * @param i 左孩子下标值
	 * @param j 右孩子下标值
	 * @return 如果有下标值有一个没有越界，返回较小的那个。如果都越界，则返回无效索引值0
	 */
	private int getMin(int i, int j) {
		if (isLegal(i) && isLegal(j)) { // 如果两个都没有越界，返回较小的下标值
			return this.arr[i] > this.arr[j] ? j : i;
		} else if (isLegal(i)) { // 返回左孩子下标
			return i;
		} else if (isLegal(j)) { // 返回右孩子下标
			return j;
		} else { // 返回备用索引0
			return 0;
		}
	}
	/**
	 * 交换两下标对应的值
	 * @param i
	 * @param j
	 */
	private void swap(int i, int j) {
		int temp = this.arr[i];
		this.arr[i] = this.arr[j];
		this.arr[j] = temp;
	}
	/**
	 * 检查一个下标是否魏越界或者是否存储了实际值
	 * @param i
	 * @return 在数组范围内返回true，越界返回false
	 */
	private boolean isLegal(int i) {
		return 1 <= i && i <= this.size() ? this.arr[i] != INF ? true : false : false; // 首先判断数组下标越界与否，在没有越界的基础上还需要判断是否是有效值
	}
}
