package wheels;

import java.util.Scanner;

public class MaxHeapTest {

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(10);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i =0; i < 10; i++) {
			maxHeap.push(sc.nextInt());
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(maxHeap.pop() + " ");
		}
	}

}
