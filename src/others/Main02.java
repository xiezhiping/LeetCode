package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Point p = new Point(x, y);
			list.add(p);
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				for (int k = j+1;k < n;k++) {
					double l1 = len(list.get(i), list.get(j));
					double l2 = len(list.get(i), list.get(k));
					double l3 = len(list.get(j), list.get(k));
					if (l1 + l2 > l3 && l1 + l3 > l2 && l2 + l3 > l1) {
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}
	private static double len(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
	}
}

class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
