package sort;
/**
 * 一种简单直观的排序算法：每次从无序中选一个最小的放到有序的末尾
 * 交换操作介于0~(n-1)之间；
 * 比较操作为(n-1)*n/2;
 * 赋值操作介于0~(n-1)*3；
 * 平均复杂度为O(n^2).
 * @author xzp
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] a = {2, 5, 8, 9, 7, 6, 11, 10, -9, 3}; // 可根据自己需要改
		int length = a.length; // 放到for循环不恰当
		System.out.println("before sort:");
		for (int i= 0; i < length; i++) {
			System.out.print(a[i] + " ");
		}
		selectSort(a, length);
		System.out.println("\nafter sort:");
		for (int i= 0; i < length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	public static void selectSort(int[] a, int length) {
		for (int i = 0; i < length; i++) {
			for (int j = i +1; j < length; j++) {
				if (a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
	}
	public static void swap(int[] source, int start, int end) {
		int temp = source[start];
		source[start] = source[end];
		source[end] = temp;
	}
}
