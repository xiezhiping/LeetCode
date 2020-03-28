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
		int i, j; // i, j �ֱ�Ϊ�����ڱ�
		char temp;
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
	public static void swap(char[] source, int start, int end) {
		char temp = source[start];
		source[start] = source[end];
		source[end] = temp;
	}
}
