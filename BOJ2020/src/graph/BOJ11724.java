package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ11724.java
 * @author chlgpdus921
 * @date 2020. 5. 19.
 */
/* 연결 요소의 개수 */
public class BOJ11724 {
	static boolean[] check;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());

		list = new ArrayList[N + 1];
		check = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	public static void dfs(int v) {
		
		for (int i = 0; i < list[v].size(); i++) {
			int cur = list[v].get(i);

			if (!check[cur]) {
				check[cur] = true;
				dfs(cur);
			}
		}
	}

}
