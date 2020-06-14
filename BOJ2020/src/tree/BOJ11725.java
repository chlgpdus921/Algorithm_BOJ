package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ11725.java
 * @author chlgpdus921
 * @date 2020. 6. 9.
 */
/* BOJ11725 트리의 부모 찾기 */
public class BOJ11725 {
	static int[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		boolean[] check = new boolean[n + 1];
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		result = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.valueOf(st.nextToken());
			int v2 = Integer.valueOf(st.nextToken());
			list[v1].add(v2);
			list[v2].add(v1);
		}
		bfs(list, check);
		for (int i = 2; i <= n; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs(ArrayList<Integer>[] list, boolean[] check) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		check[1] = true;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				if (check[next] == false) {
					result[next] = cur;
					check[next] = true;
					queue.add(next);
				}
			}

		}
	}
}
