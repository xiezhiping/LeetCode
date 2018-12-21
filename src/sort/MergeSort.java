package sort;

/**
 * �鲢�㷨
 * @author xzp
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] a = {2, 5, 8, 9, 7, 6, 11, 10, -9, 3}; // �ɸ����Լ���Ҫ��
		int length = a.length; // �ŵ�forѭ����ǡ��
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
			// ��·�鲢
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, mid, mid + 1, end);
			// ���ﻹ���Խ��ж�·�鲢��ֻ�轫 mid = (start + end) / 4��Ȼ��ֱ����ÿ��merge��start1��end1��
			
		}
	}
	public static void merge(int[] array, int start1, int end1, int start2, int end2) {
		int vernier1, vernier2; // vernier1��vernier2�ֱ�Ϊ��1����2���α�
		{
			vernier1 = start1;
			vernier2 = start2;
		}
		int k = 0;
		int[] temp = new int[end2 - start1 + 1]; // ����һ����ʱ����Ϊ�������б���֮�͵�����
		while (vernier1 <= end1 && vernier2 <= end2) { // ͨ��ѭ�������δ������ӱ����ҳ���СԪ�ط�����ʱ���飬���ƶ��α�
			if (array[vernier1] > array[vernier2]) {
				temp[k++] = array[vernier2++];
			} else {
				temp[k++] = array[vernier1++];
			}
		}
		// ��ʣ�µ�Ԫ�����η�����ʱ�����У����ҿ϶���ֻʣ��һ����
		while (vernier1 <= end1) {
			temp[k++] = array[vernier1++];
		}
		while (vernier2 <= end2) {
			temp[k++] = array[vernier2++];
		}
		k = start1;
		for (int el : temp) { // ����ʱ����Ԫ�ظ��Ƹ�ԭ����
			array[k++] = el;
		}
	}
}
