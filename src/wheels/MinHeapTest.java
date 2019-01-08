package wheels;

import java.util.Scanner;

public class MinHeapTest {

	public static void main(String[] args) {
		MinHeap myHeap = new MinHeap(10);
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			for (int i = 0; i < 10; i++) {
				myHeap.push(sc.nextInt());
			}
			for (int i = 0; i < 10; i++) {
				System.out.print(myHeap.pop() + " ");
			}
			System.out.println();
		}
	}

}
