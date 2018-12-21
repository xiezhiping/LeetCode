package sort;

/**
 * 归并算法
 * @author xzp
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] a = {2, 5, 8, 9, 7, 6, 11, 10, -9, 3}; // 可根据自己需要改
		int length = a.length; // 放到for循环不恰当
		System.out.println("before sort:");
		for (int i= 0; i < length; i++) {
			System.out.print(a[i] + " ");
		}
		mergeSort(a, 0, length - 1);
		System.out.println("\nafter sort:");
		for (int i= 0; i < length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	public static void mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			// 两路归并
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, mid, mid + 1, end);
			// 这里还可以进行多路归并，只需将 mid = (start + end) / 4，然后分别计算每次merge的start1，end1等
			
		}
	}
	public static void merge(int[] array, int start1, int end1, int start2, int end2) {
		int vernier1, vernier2; // vernier1、vernier2分别为表1、表2的游标
		{
			vernier1 = start1;
			vernier2 = start2;
		}
		int k = 0;
		int[] temp = new int[end2 - start1 + 1]; // 建立一个临时长度为两个子列表长度之和的数组
		while (vernier1 <= end1 && vernier2 <= end2) { // 通过循环，依次从两个子表中找出较小元素放入临时数组，并移动游标
			if (array[vernier1] > array[vernier2]) {
				temp[k++] = array[vernier2++];
			} else {
				temp[k++] = array[vernier1++];
			}
		}
		// 将剩下的元素依次放入临时数组中（而且肯定是只剩下一方）
		while (vernier1 <= end1) {
			temp[k++] = array[vernier1++];
		}
		while (vernier2 <= end2) {
			temp[k++] = array[vernier2++];
		}
		k = start1;
		for (int el : temp) { // 将临时数组元素复制给原数组
			array[k++] = el;
		}
	}
}
