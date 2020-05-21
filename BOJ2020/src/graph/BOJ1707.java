package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1707.java
 * @author chlgpdus921
 * @date 2020. 5. 19.
 */
/* 이분 그래프 */
public class BOJ1707 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.valueOf(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.valueOf(st.nextToken());
			int E = Integer.valueOf(st.nextToken());

			ArrayList<Integer>[] list = new ArrayList[V + 1]; // 인접 리스트
			boolean[] check = new boolean[V + 1];
			int[] color = new int[V + 1];

			for (int k = 0; k <= V; k++) {
				list[k] = new ArrayList<Integer>();
			}

			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int v1 = Integer.valueOf(st.nextToken());
				int v2 = Integer.valueOf(st.nextToken());

				list[v1].add(v2);
				list[v2].add(v1);
			}
			// DFS
			for (int j = 1; j <= V; j++) {
				dfs(list, check, color, j);
			}
			if (color[0] == 3)
				sb.append("NO\n");
			else
				sb.append("YES\n");
		}
		System.out.println(sb);

	}

	public static void dfs(ArrayList<Integer>[] list, boolean[] check, int[] color, int v) {
		check[v] = true;

		for (int i = 0; i < list[v].size(); i++) {
			int cur = list[v].get(i);
			if (!check[cur]) {
				check[cur] = true;
				if (color[v] == 0) // 초기값 setting 색깔 1로
					color[v] = 1;

				color[cur] = 3 - color[v]; // 색깔 1,2 설정

				dfs(list, check, color, cur);
			}

			else { // 이미 지나온 길
				if (color[v] == color[cur]) {
					// 이미 색깔이 지정되어 있는데, 같은 색깔이면, 이분그래프 X
					color[0] = 3;
					return;
				}
			}
		}
	}
}
