package cut.point;

import java.util.Scanner;

/**
 * "轰炸重要城市"问题：
 * 假设当前我们拥有一个 地区的城市地图，但是只有一个原子弹，为了让这颗原子弹发挥最大的效果，要阻断这个地区各个城市中最关键的一个交通要塞，那么这个原子弹该投放在哪里？
 * 其实真有原子弹就不会考虑这么多了（~……~），扯回正题。这种问题模型化之后，就是让我们从一个无向连通图中选择一个“割点”，去掉这个点之后，不再是连通图。
 * 关键词：DFS、割点、无向连通图、重要城市
 * @author XZP
 *一组测试数据：
6 7 
1 4 
1 3 
4 2
3 2
2 5 
2 6
5 6
 */
public class BombingImportantCity {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 顶点数
		int m = sc.nextInt(); // 边的条数
		
	}

}
