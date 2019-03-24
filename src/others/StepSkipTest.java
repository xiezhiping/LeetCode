package others;


public class StepSkipTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2, 3, 1, 1 ,4};
//		int[] dp = new int[5]; // ��ʾ������i����Ҫ�Ĳ���
//		for (int i = 0; i < 5; i++) {
//			// �����ڵ�ǰ��������Ծ����Զ����
//			int maxLocation = Math.min(i + array[i], 4);
//			for (int j = i + 1; j <= maxLocation; j++) {
//				if (dp[j] == 0) { // ��һ������
//					dp[j] = dp[i] + 1;
//				}
//			}
//			if(dp[4] != 0) {
//				System.out.println(dp[4]);
//			return;
//			}
//		}
//		mergeSort(array, 0, 4); // �鲢�����ȶ�
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
		int i = left; // ���������α�ָ��
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
		// ��������λ��
		array[left] = array[i];
		array[i] = base;
		quickSort(array, left, i-1);
		quickSort(array, i + 1, right);
	}
	/**
	 * ����������
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
	 * �鲢����ʵ��
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
		int[] temp = new int[len]; // ������ʱ����ϲ�ֵ������
		int i = start1;
		int j = start2; // �ֱ��������α�ָ��
		int index = 0;
		while(i <= end1 && j <= end2) {
			if (array[i] < array[j]) {
				temp[index] = array[i];
				i++; // i���ƶ�
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
		// �������õ����鸳ֵ��ԭ����
		while(i < len) {
			array[i] = temp[i];
			i++;
		}
	}
}
