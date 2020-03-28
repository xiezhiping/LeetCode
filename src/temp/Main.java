package temp;

import java.util.Scanner;

import com.sun.swing.internal.plaf.basic.resources.basic;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str1 = in.nextLine();
		String str2 = in.nextLine();
		int[] A = convert(str1);
		int[] B = convert(str2);
		int[] set = findILR(A);
		// ��������B
		quicksort(B, 0, B.length-1);
		
		int max = findMax(set, B);
		if (max == Integer.MIN_VALUE) {
			System.out.println("NO");
		} else {
			for (int i = 0; i < A.length;i++) {
				if (i == set[0]) {
					System.out.print(max);
					if (i != A.length-1) {
						System.out.print(" ");
					}
				} else {
					System.out.print(A[i]);
					if (i != A.length-1) {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
	// �����ֵ
	private static int findMax(int[] set, int[] B) {
		// ���������
		int max = Integer.MIN_VALUE;
		for (int i = B.length-1; i>=0; i--) {
			// ��һ���ҵ��ľ������ֵ
			if (B[i] > set[1] && B[i] < set[2]) {
				return B[i];
			}
		}
		return max;
	}
	public static void quicksort(int[] array, int left, int right) {
		if (left > right) {
			return;
		}
		int i, j, temp; // i, j �ֱ�Ϊ�����ڱ�
		temp = array[left]; // temp��ľ��ǻ�׼��
		i = left;
		j = right;
		while (i < j) {
			// ˳�����Ҫ��Ҫ�ȴ���������
			while (array[j] >= temp && i < j) {
				j--;
			}
			// �ٴ���������
			while (array[i] <= temp && i < j) {
				i++;
			}
			// �����������������е�λ��
			if (i < j) { // ���ڱ�i, j û��������ʱ
				swap(array, i, j);
			}
		}
		// ���ս���׼����Ϊ���������
		array[left] = array[i]; // ע��߽�ֵ
		array[i] = temp;
		quicksort(array, left, i-1); // �ݹ鴦����ߵ�
		quicksort(array, i + 1, right); // �ݹ鴦���ұߵ�
	}
	public static void swap(int[] source, int start, int end) {
		int temp = source[start];
		source[start] = source[end];
		source[end] = temp;
	}
	/**
	 * ��������ֵint[] ���飬���ζ�Ӧindex,��ֵ����ֵ
	 * @param array
	 * @return
	 */
	private static int[] findILR(int[] array) {
		int[] set = new int[3];
		int len = array.length;
		if (array == null || len < 1) {
			return null;
		}
		int i = len-1;
		if (len < 3) {
			set[0] = 1;
			set[1] = array[0];
			set[2] = Integer.MAX_VALUE;
			return set;
		}
		// ���ڵ���3
		for (; i >= 0; i--) {
			if (i ==0) {
				if (array[i] >= array[i+1]) {
					set[0] = i;
					set[1] = Integer.MIN_VALUE;
					set[2] = array[i+1];
					return set;
				}
			} else if (i == len-1) {
				if (array[i] <= array[i-1]) {
					set[0] = i;
					set[1] = array[i-1];
					set[2] = Integer.MAX_VALUE;
					return set;
				}
			} else {
				// ��ͷ����ֵ�����
				if (array[i] >= array[i-1] && array[i] >= array[i+1]) {
					set[0] = i;
					set[1] = array[i-1];
					set[2] = array[i+1];
					return set;
				} else if (array[i] <= array[i-1] && array[i] <= array[i+1]) {
					set[0] = i;
					set[1] = array[i-1];
					set[2] = array[i+1];
					return set;
				}
			}
		}
		return set;
	}
	private static int[] convert(String str) {
		if (str == null) {
			return new int[1];
		}
		String[] strings = str.split(" ");
		int[] arr = new int[strings.length];
		int i = 0;
		for (String string : strings) {
			arr[i] = Integer.parseInt(string);
			i++;
		}
		return arr;
	}

}
