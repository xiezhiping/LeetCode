package sort;

/**
 * �����˼��ֳ��õ������㷨��
 * 
 * 1. һ�ּ�ֱ�۵������㷨�����ѡ�����򣩣�ÿ�δ�������ѡһ����С�ķŵ������ĩβ
 * (1) ������������0~(n-1)֮�䣻
 * (2) �Ƚϲ���Ϊ(n-1)*n/2;
 * (3) ��ֵ��������0~(n-1)*3��
 * (4) ƽ�����Ӷ�ΪO(n^2).
 * 2. ��������
 * 3. ���ַ� ���� 
 * @author xzp
 *
 */
public class SimpleSorts {

	public static void main(String[] args) {
		int[] a = {2, 5, 8, 9, 7, 6, 11, 10, -9, 3}; // �ɸ����Լ���Ҫ��
		int length = a.length; // �ŵ�forѭ����ǡ��
		System.out.println("before sort:");
		for (int i= 0; i < length; i++) {
			System.out.print(a[i] + " ");
		}
//		selectSort(a, length); // ʹ��ֱ�۵�ѡ������
//		insertSort(a, length); // ʹ�ò�������
//		binarySort(a, length); // ʹ�ö�������
		quickSort(a, 0, length-1);
		System.out.println("\nafter sort:");
		for (int i= 0; i < length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	/**
	 * ��ֱ�۵�ѡ������
	 * @param a ����������
	 * @param length ���鳤��
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
	 * ��������
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
	 * �������򣺴�i = 1��ʼ����ÿ�δ�����ĵ�һ��Ԫ��ѡ�����뵽���򲿷ֶ��ַ��ҵ����±�λ��
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
	 * ���ţ�ѡȡһ�����ֵ�������б����ķű��ֵ�ұߣ�����С�ķ���ߣ�Ȼ��ݹ����
	 * @param source ����������
	 * @param low ��ȷ��
	 * @param high ��ȷ��
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
	public static void swap(int[] source, int start, int end) {
		int temp = source[start];
		source[start] = source[end];
		source[end] = temp;
	}
}
