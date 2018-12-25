package others;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Сè����ֽ����Ϸ
 *��Ϸ�Ĺ����������ģ���һ���˿���ƽ���ֳ����ݣ�ÿ����һ�ݡ�С�����ó����е�
 *��һ���˿��Ʒ������ϣ�Ȼ��С��Ҳ�ó����еĵ�һ���˿��ƣ�������С�߸մ�����˿���
 *�����棬�����������˽�����ơ�����ʱ�����ĳ�˴������������ĳ���Ƶ�������ͬ������
 *��������ͬ���Ƽ����м����е���ȫ��ȡ�ߣ������ηŵ��Լ������Ƶ�ĩβ��������һ��
 *���е���ȫ������ʱ����Ϸ���������ֻ�ʤ��
 * @author XZP
 *
 */
public class CatFish {

	public static void main(String[] args) {
		Queue<Integer> queueA = new LinkedBlockingQueue<>();
		Queue<Integer> queueB = new LinkedBlockingQueue<>();
		// ��������
		queueA.add(2);
		queueA.add(4);
		queueA.add(1);
		queueA.add(2);
		queueA.add(5);
		queueA.add(6);
		queueB.add(3);
		queueB.add(1);
		queueB.add(3);
		queueB.add(5);
		queueB.add(6);
		queueB.add(4);
		judgeWhoWin(queueA, queueB);
	}
	public static void judgeWhoWin(Queue<Integer> QA, Queue<Integer> QB) {
		Stack<Integer> desk = new Stack<>(); // ģ������
		int tempA, tempB, tempTop;
		int[] book = new int[10]; // ���ڱ���������Ƿ��и�����ı������
		while (!QA.isEmpty() && !QB.isEmpty()) {
			// ����A��ʼ����
			tempA = QA.poll();
			// ��������ͬtempA������ͬ��
			if (book[tempA] > 0) { // �о�ȡ�߷Ŷ�β������־λ-1
				book[tempA]--;
				QA.add(tempA);
				tempTop = desk.pop();
				while (tempTop != tempA) {
					book[tempTop]--;
					QA.add(tempTop);
					tempTop = desk.pop();
				}
				QA.add(tempTop);
			} else { // û�о�ֱ����ջ���������λ+1
				desk.push(tempA);
				book[tempA]++;
			}
			// �ֵ�B����
			tempB = QB.poll();
			// ��������ͬtempB������ͬ��
						if (book[tempB] > 0) { // �о�ȡ�߷Ŷ�β������־λ-1
							book[tempB]--;
							QB.add(tempB);
							tempTop = desk.pop();
							while (tempTop != tempB) {
								book[tempTop]--;
								QB.add(tempTop);
								tempTop = desk.pop();
							}
							QB.add(tempTop);
						} else { // û�о�ֱ����ջ���������λ+1
							desk.push(tempB);
							book[tempB]++;
						}
		}
		if (QA.isEmpty()) {
			System.out.println("A player won! B���е����ǣ�");
			System.out.println(QB);
		} else if (QB.isEmpty()) {
			System.out.println("B player won! A���е����ǣ�");
			System.out.println(QA);
		} else {
			System.out.println("no player won!");
		}
	}
}
