package dfs;

import java.util.Scanner;
/**
 * 给定1~9的9个数，拿去填9个盒子使其：ABC + DEF = GHI
 * 其实是上一种的变体，只是多个判断而已，我只是想看一下数据，所以单独改写一下，后面的注释就懒得改了！！！！
 * 全排列问题！！！
 * @author XZP
 *
 */
public class AddEquation {
	public static int[] book;
	public static int[] box;
	public static int count = 0; // 针对不同的数字放置方式的总数
	public static int cards = 0; // 卡片的张数
	public static int stemp = 1; // 每次都是从第一个box开始放置
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			cards = sc.nextInt();
			if (cards < 1 || cards > 9) {
				System.out.println("输入卡片张数不合法");
				return;
			}
			box = new int[cards+1]; // 下标从0开始，每个box对应放置一张卡片
			book = new int[cards + 1]; // 用于标记第i张卡片是否已经使用，0表示还在手里，1表示已经放进box里面了，下标从1开始
			System.out.println("放置卡片开始：");
			dfs(1);
			System.out.println("\n一共有 " + count + "种！");
			
		}
	}
	public static void dfs (int step) {
		if (step == cards + 1) { // 如果站在第n + 1个box面前，则表示一趟放置结束，输出结果并返回调用栈
			// 改动的地方在这里
			if ((box[1] + box[4])*100 + (box[2] + box[5]) * 10 + box[3] + box[6] == box[7] * 100 + box[8] * 10 + box[9]) {
				System.out.println("\n使等式：ABC + DEF = GHI成立的三个数分别是：");
					System.out.print(box[1]+ "" +box[2] + "" +box[3] + "+" + box[4] + "" + box[5] + "" + box[6] + "=" + box[7] + "" + box[8] + "" + box[9]);
				count++;
				
			}
			return;
		}
		// 此时站在第step个盒子面前，应该放置那张牌呢？按照1,2,3的顺序一一尝试
		for (int i = 1; i <= cards; i++) {
			if (book[i] == 0) { // 判断扑克牌i是否已经放进box了，如果没有则放置
				box[step] = i;
				book[i] = 1;
				dfs(step + 1); // 第step个box已经放置好，需要往后走，放置下一个，递归返回条件就是当step == cards + 1
				book[i] = 0;  // 这步很关键，一开始我没想明白，直到单步调试后，其实就是将第i张扑克收回来再重新放置，这就是所谓的排列！！！！！！
			}
		}
	}
}
