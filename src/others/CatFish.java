package others;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 小猫钓鱼纸牌游戏
 *游戏的规则是这样的：将一副扑克牌平均分成两份，每人拿一份。小哼先拿出手中的
 *第一张扑克牌放在桌上，然后小哈也拿出手中的第一张扑克牌，并放在小哼刚打出的扑克牌
 *的上面，就像这样两人交替出牌。出牌时，如果某人打出的牌与桌上某张牌的牌面相同，即可
 *将两张相同的牌及其中间所夹的牌全部取走，并依次放到自己手中牌的末尾。当任意一人
 *手中的牌全部出完时，游戏结束，对手获胜。
 * @author XZP
 *
 */
public class CatFish {

	public static void main(String[] args) {
		Queue<Integer> queueA = new LinkedBlockingQueue<>();
		Queue<Integer> queueB = new LinkedBlockingQueue<>();
		// 测试数据
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
		Stack<Integer> desk = new Stack<>(); // 模拟桌子
		int tempA, tempB, tempTop;
		int[] book = new int[10]; // 用于标记桌子上是否有该牌面的标记数组
		while (!QA.isEmpty() && !QB.isEmpty()) {
			// 首先A开始出牌
			tempA = QA.poll();
			// 桌子上有同tempA牌面相同的
			if (book[tempA] > 0) { // 有就取走放队尾并将标志位-1
				book[tempA]--;
				QA.add(tempA);
				tempTop = desk.pop();
				while (tempTop != tempA) {
					book[tempTop]--;
					QA.add(tempTop);
					tempTop = desk.pop();
				}
				QA.add(tempTop);
			} else { // 没有就直接入栈，并将标记位+1
				desk.push(tempA);
				book[tempA]++;
			}
			// 轮到B出牌
			tempB = QB.poll();
			// 桌子上有同tempB牌面相同的
						if (book[tempB] > 0) { // 有就取走放队尾并将标志位-1
							book[tempB]--;
							QB.add(tempB);
							tempTop = desk.pop();
							while (tempTop != tempB) {
								book[tempTop]--;
								QB.add(tempTop);
								tempTop = desk.pop();
							}
							QB.add(tempTop);
						} else { // 没有就直接入栈，并将标记位+1
							desk.push(tempB);
							book[tempB]++;
						}
		}
		if (QA.isEmpty()) {
			System.out.println("A player won! B手中的牌是：");
			System.out.println(QB);
		} else if (QB.isEmpty()) {
			System.out.println("B player won! A手中的牌是：");
			System.out.println(QA);
		} else {
			System.out.println("no player won!");
		}
	}
}
