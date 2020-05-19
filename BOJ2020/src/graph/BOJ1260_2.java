package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 
 * @FileName BOJ1260_2.java
 * @author chlgpdus921
 * @date 2020. 5. 19.
 */
/* DFS와 BFS 모범 답*/
public class BOJ1260_2 {
	static int N, M, V, s, e;
	static ArrayList<Integer>[] list;
	static boolean visit[];
	static StringBuilder sb;
	static Queue<Integer> que;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		que = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}

		sb = new StringBuilder();
		visit = new boolean[N + 1];
		dfs(V, sb);
		System.out.println(sb.toString());

		sb = new StringBuilder();
		visit = new boolean[N + 1];
		bfs(V, sb);
		System.out.println(sb.toString());

	}

	public static void bfs(int V, StringBuilder sb) {
		int a = V;
		que.add(a);
		visit[a] = true;
		
		while (!que.isEmpty()) {
			int curr = que.poll();
			sb.append(curr).append(" ");
			for (int j = 0; j < list[curr].size(); j++) {
				int next = list[curr].get(j);
				if (visit[next] == false) {
					visit[next] = true;
					que.add(next);
				}
			}
		}

	}

	public static void dfs(int V, StringBuilder sb) {
		int a = V;
		visit[a] = true;
		sb.append(a).append(" ");
		
		for (int i = 0; i < list[a].size(); i++) {
			int next = list[a].get(i);
			if (visit[next] == false) {
				dfs(next, sb);
			}
		}
	}
}
