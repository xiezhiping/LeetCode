package temp;

import java.util.ArrayList;
import java.util.Scanner;

public class LeastTime {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++)
			graph[i] = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			int from = input.nextInt(), to = input.nextInt();
			from--;
			to--;
			graph[from].add(to);
			graph[to].add(from);
		}
		System.out.println(leastTime(graph));
	}

	private static int leastTime(ArrayList<Integer>[] graph) {
		int result = 0;
		boolean[] visited = new boolean[graph.length];
		visited[0] = true;
		for (int i = 0; i < graph[0].size(); i++) {
			visited[graph[0].get(i)] = true;
			int count = countOfChild(graph, graph[0].get(i), visited);
			result = Math.max(result, count);
		}

		return result;
	}

	private static int countOfChild(ArrayList<Integer>[] graph, Integer x, boolean[] visited) {
		int sum = 1;
		for (int i = 0; i < graph[x].size(); i++) {
			int next = graph[x].get(i);
			if (!visited[next]) {
				visited[next] = true;
				sum += countOfChild(graph, next, visited);
			}
		}
		return sum;
	}
}