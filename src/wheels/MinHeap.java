package wheels;

/**
 * ��С�ѵļ�ʵ��
 * @author XZP
 * һ��������ݣ� 12 45 -11 69 1 95 9 78 64 21
 */
public class MinHeap {
	private int INF = 9999999; // ��Ϊ�涨�����ֵ
	private int[] arr;
	public MinHeap (int size) {
		arr = new int[size + 1]; // �±��1��ʼ
		for (int i = 0; i <= size; i++) { // �����ռ��һ��ʱ������֤�����ܴ���ֵ
			arr[i] = INF;
		}
	}
	/**
	 * ����С���в���һ��Ԫ��ʹ����Ȼ������С��
	 * @param data ����������
	 * @return �ɹ�Ϊtrue��ʧ�ܽ���ӡ�쳣ջ
	 */
	public boolean push(int data) {
		int index = this.index();
		try {
			this.arr[index] = data;
			siftup(index);  // ��������ĩβ֮����Ҫ���ϵ���ʹ��������С��
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * @return �����ܴ洢�����size
	 */
	public int size() {
		return arr.length - 1;
	}
	/**
	 * ��ȡ��ǰ�ܲ���ֵ�������±�
	 * @return ����������ֵ����  + 1
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
	 * ����С����ȡ��С���Ǹ�Ԫ�أ�������ʹ��һֱ������С��
	 * @return ���鲻Ϊ���򷵻���С��Ԫ�أ����򷵻���Ϊ�涨��INFֵ
	 */
	public int pop() {
		if (!isLegal(1)) { // ÿ��ȡ��һ��Ԫ�أ��±�ֵΪ1��������0��
			return INF;
		}
		int value = this.arr[1];
		int end = this.index() - 1; // ���������һ����ЧԪ��
		if (!isLegal(end)) { // ���Ԫ�ز��Ϸ�˵����ʱ������ֻ������Ϊ1���ֵ��Ч
			this.arr[1] = INF;
			return value;
		}
		this.arr[1] = this.arr[end]; // ��ĩβ��Чֵ�������������ұߵ�Ҷ�ӽ�㣩��Ϊ���ڵ㲢���µ���
		this.arr[end] = INF;
		siftdown(1);
		return value;
	}
	/**
	 * ���ϵ����ķ���
	 * @param i �������ĺ��ӽڵ�
	 */
	private void siftup(int i) {
		if (i <= 1) {
			return; // 1 ����һλ��0��
		}
		int parent = i >> 1;
		boolean flag = true; // �Ƿ���Ҫ����
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
	 * ���µ����ķ���
	 * @param i �������Ľڵ��±�
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
	 * ��ȡ���ڵ����ӵ��±�ֵ
	 * @param i
	 * @return
	 */
	private int left(int i) {
		return i << 1;  //���ӵ�����Ϊ����һλ
	}
	/**
	 * ��ȡ���ڵ��Һ��ӵĵ��±�ֵ
	 * @param i
	 * @return
	 */
	private int right(int i) {
		return (i << 1) + 1; // �Һ���Ϊ����һλ + 1
	}
	/**
	 * ��ȡֵ��С���±�ֵ
	 * @param i �����±�ֵ
	 * @param j �Һ����±�ֵ
	 * @return ������±�ֵ��һ��û��Խ�磬���ؽ�С���Ǹ��������Խ�磬�򷵻���Ч����ֵ0
	 */
	private int getMin(int i, int j) {
		if (isLegal(i) && isLegal(j)) { // ���������û��Խ�磬���ؽ�С���±�ֵ
			return this.arr[i] > this.arr[j] ? j : i;
		} else if (isLegal(i)) { // ���������±�
			return i;
		} else if (isLegal(j)) { // �����Һ����±�
			return j;
		} else { // ���ر�������0
			return 0;
		}
	}
	/**
	 * �������±��Ӧ��ֵ
	 * @param i
	 * @param j
	 */
	private void swap(int i, int j) {
		int temp = this.arr[i];
		this.arr[i] = this.arr[j];
		this.arr[j] = temp;
	}
	/**
	 * ���һ���±��Ƿ�κԽ������Ƿ�洢��ʵ��ֵ
	 * @param i
	 * @return �����鷶Χ�ڷ���true��Խ�緵��false
	 */
	private boolean isLegal(int i) {
		return 1 <= i && i <= this.size() ? this.arr[i] != INF ? true : false : false; // �����ж������±�Խ�������û��Խ��Ļ����ϻ���Ҫ�ж��Ƿ�����Чֵ
	}
}
