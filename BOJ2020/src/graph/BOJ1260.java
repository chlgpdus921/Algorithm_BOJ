package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1260.java
 * @author chlgpdus921
 * @date 2020. 5. 18.
 */
/* DFS와 BFS */
public class BOJ1260 {
	static ArrayList<ArrayList<Integer>> list;
	static int m;
	static StringBuilder sb;
	static Queue<Integer> queue;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		queue = new LinkedList<Integer>();
		stack = new Stack<Integer>();

		int n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		int v = Integer.valueOf(st.nextToken());

		list = new ArrayList<ArrayList<Integer>>(n + 1);
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.valueOf(st.nextToken());
			int v2 = Integer.valueOf(st.nextToken());
			list.get(v1).add(v2);
			list.get(v2).add(v1);
		}

		for (int i = 0; i < list.size(); i++) {
			Collections.sort(list.get(i));
		}

		// DFS
		boolean[] check = new boolean[n + 1];
		check[v] = true;
		stack.add(v);
		sb.append(v + " ");
		dfs(check, v, 0);

		sb.append("\n");

		// BFS
		boolean[] check2 = new boolean[n + 1];
		check2[v] = true;
		queue.add(v);
		sb.append(v + " ");
		bfs(check2, v, queue.size());

		System.out.println(sb);
	}

	public static void dfs(boolean[] check, int cur, int size) {
		int sum = 0;
		for (int i = 0; i < list.get(cur).size(); i++) {
			int value = list.get(cur).get(i);

			if (!check[value]) {
				check[value] = true;
				sb.append(value + " ");
				stack.add(value);
				dfs(check, value, stack.size());
				break;
			} else
				sum++;

		}
		if (sum == list.get(cur).size()) {
			stack.pop();

			if (stack.isEmpty())
				return;
			dfs(check, stack.peek(), stack.size());
		}

	}

	public static void bfs(boolean[] check, int cur, int size) {
		for (int i = 0; i < list.get(cur).size(); i++) {
			int value = list.get(cur).get(i);
			if (!check[value]) {
				check[value] = true;
				queue.add(value);
				sb.append(value + " ");
			}
		}
		queue.poll();// 앞에꺼 지우기
		if (queue.isEmpty())
			return;
		bfs(check, queue.peek(), queue.size());

	}
}
