package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1967 {
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
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.valueOf(st.nextToken());
			int v2 = Integer.valueOf(st.nextToken());
			int d = Integer.valueOf(st.nextToken());
			
			list[v1].add(v2);
			list[v2].add(v1);
			distance[v1].add(d);
			distance[v2].add(d);
		
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
