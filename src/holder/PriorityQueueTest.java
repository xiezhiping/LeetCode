package holder;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new PriorityQueue<>(10, 
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						int result = o1 % 2 - o2 % 2;
						if (result == 0) {
							result = o1 - o2;
						}
						return result;
					}
			
				});
		for (int i = 0; i < 10; i++) {
			queue.offer(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(queue.poll());
		}
	}

}
