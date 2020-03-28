package temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		String[] strings = string.split(" ");
		char[] head = new char[strings.length];
		char[] tail = new char[strings.length];
		int i =0;
		for (String str:strings) {
			head[i] = str.charAt(0);
			tail[i] = str.charAt(str.length()-1);
			i++;
		}
		quicksort(head, 0, head.length-1);
		quicksort(tail, 0, tail.length-1);
		for (int j = 0; j < head.length; j++) {
			if (head[j] != tail[j]) {
				System.out.println(false);
				return;
			}
		}
		System.out.println(true);
	}
	public static void quicksort(char[] array, int left, int right) {
		if (left > right) {
			return;
		}
		int i, j; // i, j 分别为左右哨兵
		char temp;
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
		quicksort(array, i + 1, right); // 递归处理右边的
	}
	public static void swap(char[] source, int start, int end) {
		char temp = source[start];
		source[start] = source[end];
		source[end] = temp;
	}
}
