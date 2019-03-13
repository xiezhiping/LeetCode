package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		int[] a = new int[n]; // 存放位置的索引
		int[] b = new int[n]; // 存放金钱的索引
		for (int i = 0; i < n; i++) {
			int aa = sc.nextInt();
			a[i] = aa;
			int bb = sc.nextInt();
			b[i] = bb;
			map.put(bb, aa);
			map2.put(aa, bb);
		}
		binarySort(a, n);
		binarySort(b, n);
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = n-1; j >= 0; j--) {
				if (Math.abs(map.get(b[j]) - a[i]) >= 3) {
					if (b[j] + map2.get(a[i]) > max) {
						max = b[j] + map2.get(a[i]);
					}
					continue;
				}
			}
		}
		System.out.println(max);
	}
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
}

