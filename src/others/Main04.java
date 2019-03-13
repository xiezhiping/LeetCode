package others;

import java.util.Scanner;
public class Main04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
        	a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
        	b[i] = in.nextInt();
        }
//        quickSort(a, 0, n-1);
//        quickSort(b, 0, n-1);
        binarySort(a,n);
        binarySort(b,n);
        int result = 0;
        for (int i = 0; i < n; i++) {
        	result += a[i]*b[n-1-i];
        }
        System.out.println(result);
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
}
