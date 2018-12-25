package sort;

/**
 * 罗列了几种常用的排序算法：
 * 
 * 1. 一种简单直观的排序算法（针对选择排序）：每次从无序中选一个最小的放到有序的末尾
 * (1) 交换操作介于0~(n-1)之间；
 * (2) 比较操作为(n-1)*n/2;
 * (3) 赋值操作介于0~(n-1)*3；
 * (4) 平均复杂度为O(n^2).
 * 2. 插入排序
 * 3. 二分法 排序
 * 4. 快速排序 
 * @author xzp
 *
 */
public class SimpleSorts {

	public static void main(String[] args) {
		int[] a = {2, 5, 8, 9, 7, 6, 11, 10, -9, 3}; // 可根据自己需要改
		int length = a.length; // 放到for循环不恰当
		System.out.println("before sort:");
		for (int i= 0; i < length; i++) {
			System.out.print(a[i] + " ");
		}
//		selectSort(a, length); // 使用直观的选择排序
//		insertSort(a, length); // 使用插入排序
//		binarySort(a, length); // 使用二分排序
		quicksort(a, 0, length-1);
		System.out.println("\nafter sort:");
		for (int i= 0; i < length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	/**
	 * 简单直观的选择排序
	 * @param a 待排序数组
	 * @param length 数组长度
	 */
	public static void selectSort(int[] a, int length) {
		for (int i = 0; i < length; i++) {
			for (int j = i +1; j < length; j++) {
				if (a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
	}
	/**
	 * 插入排序
	 * @param source 
	 * @param length
	 */
	public static void insertSort(int[] source, int length) {
		for (int i = 0; i < length; i++) {
			for (int j = i; (j > 0) && source[j] < source[j-1]; j--) {
				swap(source, j, j-1);
			}
		}
	}
	/**
	 * 二分排序：从i = 1开始往后每次从无序的第一个元素选来插入到有序部分二分法找到的下标位置
	 * @param source
	 * @param length
	 */
	public static void binarySort(int[] source, int length) {
		int low, high, mid, temp;
		for (int i = 1; i < length; i++) {
			temp = source[i];
			low = 0;
			high = i-1;
			while (low <= high) {
				mid = (low + high) / 2;
				if (source[mid] > temp) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			for ( int j = i - 1; j > high; j--) {
				source[j + 1] = source[j];
			}
			source[high + 1] = temp;
		}
	}
	/**
	 * 快排：选取一个标记值，将所有比这大的放标记值右边，所有小的放左边，然后递归快排
	 * @param source 待排序数组
	 * @param low 下确界
	 * @param high 上确界
	 */
	public static void quickSort(int[] source, int low, int high) {
		int i, j, x;
		if (low < high) {
			i = low;
			j = high;
			x = source[i];
			while (i < j) {
				while (i < j && source[j] > x) {
					j--;
				}
				if (i < j) {
					source[i] = source[j];
					i++;
				}
				while (i < j && source[i] < x) {
					i++;
				}
				if (i < j) {
					source[j] = source[i];
					j--;
				}
			}
			source[i] = x;
			quickSort(source, 0, i-1);
			quickSort(source, i+1, high);
		}
	}
	/**
	 * 更加清晰的一种快排实现方式，本质就是跳跃式的不断将基数归位
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void quicksort(int[] array, int left, int right) {
		if (left > right) {
			return;
		}
		int i, j, temp; // i, j 分别为左右哨兵
		temp = array[left]; // temp存的就是基准数
		i = left;
		j = right;
		while (i < j) {
			// 顺序很重要，要先从右往左找
			while (array[j] >= temp && i < j) {
				j--;
			}
			// 再从左往右找
			while (array[i] <= temp && i < j) {
				i++;
			}
			// 交换两个数在数组中的位置
			if (i < j) { // 当哨兵i, j 没有相遇的时
				swap(array, i, j);
			}
		}
		// 最终将基准数归为，如此往复
		array[left] = array[i]; // 注意边界值
		array[i] = temp;
		quicksort(array, left, i-1); // 递归处理左边的
		quickSort(array, i + 1, right); // 递归处理右边的
	}
	public static void swap(int[] source, int start, int end) {
		int temp = source[start];
		source[start] = source[end];
		source[end] = temp;
	}
}
