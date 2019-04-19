package others;


public class StepSkipTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2, 3, 1, 1 ,4};
//		int[] dp = new int[5]; // 表示跳到第i格需要的步数
//		for (int i = 0; i < 5; i++) {
//			// 计算在当前格下能跳跃的最远距离
//			int maxLocation = Math.min(i + array[i], 4);
//			for (int j = i + 1; j <= maxLocation; j++) {
//				if (dp[j] == 0) { // 第一到最少
//					dp[j] = dp[i] + 1;
//				}
//			}
//			if(dp[4] != 0) {
//				System.out.println(dp[4]);
//			return;
//			}
//		}
//		mergeSort(array, 0, 4); // 归并排序：稳定
		quickSort(array, 0, 4);
		for (int el : array) {
			System.out.println(el + " ");
		}
	}
	public static void quickSort(int[] array, int left, int right) {
		if (left > right) {
			return;
		}
		int base = array[left];
		int i = left; // 定义两个游标指针
		int j = right;
		while(i < j) {
			while(i < j && array[j] >= base) {
				j--;
			}
			while(i < j && array[i] <= base) {
				i++;
			}
			if (i < j) {
				swap(array, i, j);
			}
			System.out.println("first time:" + i + " " + j);
		}
		// 交换两个位置
		array[left] = array[i];
		array[i] = base;
		quickSort(array, left, i-1);
		quickSort(array, i + 1, right);
	}
	/**
	 * 交换两个数
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	/**
	 * 归并排序实现
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void mergeSort(int[] array, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSort(array, 0, left);
		mergeSort(array, mid + 1, right);
		merge(array, 0, mid, mid + 1, right);
	}
	public static void merge(int[] array, int start1, int end1, int start2, int end2) {
		int len = end2 - start1 + 1;
		int[] temp = new int[len]; // 用于临时保存合并值得数组
		int i = start1;
		int j = start2; // 分别定义两个游标指针
		int index = 0;
		while(i <= end1 && j <= end2) {
			if (array[i] < array[j]) {
				temp[index] = array[i];
				i++; // i后移动
				index++;
			} else {
				temp[index] = array[j];
				j++;
				index++;
			}
		}
		while(i <= end1) {
			temp[index] = array[i];
			i++;
			index++;
		}
		while(j <= end2) {
			temp[index] = array[j];
			j++;
			index++;
		}
		i = 0;
		// 最后将排序好的数组赋值给原数组
		while(i < len) {
			array[i] = temp[i];
			i++;
		}
	}
}
