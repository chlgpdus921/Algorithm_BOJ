package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1167.java
 * @author chlgpdus921
 * @date 2020. 6. 9.
 */
/* 트리의 지름 
 * 한 정점에서 BFS탐색해서 가장 거리가 먼 정점을 구하고,
 * 그 정점에서 BFS탐색을 하면 가장 큰 지름을 구할 수 있다. 
 * */
public class BOJ1167 {
	static int n;
	static ArrayList<Integer>[] list, distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		StringTokenizer st;
		list = new ArrayList[n + 1];
		distance = new ArrayList[n + 1];

		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
			distance[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.valueOf(st.nextToken());
			while (st.hasMoreElements()) {
				int v2 = Integer.valueOf(st.nextToken());
				if (v2 != -1) {
					int d = Integer.valueOf(st.nextToken());
					list[v1].add(v2);
					distance[v1].add(d);
				}
			}
		}

		int[] result = new int[n + 1];

		bfs(1, result);
		int start = 1;
		for (int i = 2; i <= n; i++) {
			if (result[i] > result[start]) {
				start = i;
			}
		}
		result = new int[n + 1];
		bfs(start, result);
		
		Arrays.sort(result);
		System.out.println(result[n]);
	}

	public static void bfs(int start, int[] result) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] check = new boolean[n + 1];
		queue.add(start);
		check[start] = true;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);

				if (check[next] == false) {
					check[next] = true;
					result[next] = result[cur] + distance[cur].get(i);
					queue.add(next);
				}
			}

		}
	}
}
