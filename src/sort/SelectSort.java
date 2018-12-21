package sort;
/**
 * һ�ּ�ֱ�۵������㷨��ÿ�δ�������ѡһ����С�ķŵ������ĩβ
 * ������������0~(n-1)֮�䣻
 * �Ƚϲ���Ϊ(n-1)*n/2;
 * ��ֵ��������0~(n-1)*3��
 * ƽ�����Ӷ�ΪO(n^2).
 * @author xzp
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] a = {2, 5, 8, 9, 7, 6, 11, 10, -9, 3}; // �ɸ����Լ���Ҫ��
		int length = a.length; // �ŵ�forѭ����ǡ��
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
