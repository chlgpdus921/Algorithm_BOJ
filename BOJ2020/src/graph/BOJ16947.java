package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ16947.java
 * @author chlgpdus921
 * @date 2020. 5. 29.
 */
/* 서울 지하철 2호선 */
public class BOJ16947 {

	static ArrayList<Integer>[] list;
	static int n;
	static int first = 1;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.valueOf(br.readLine());
		list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.valueOf(st.nextToken());
			int v2 = Integer.valueOf(st.nextToken());
			list[v1].add(v2);
			list[v2].add(v1);
		}

		cnt = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			boolean[] check = new boolean[n + 1];
			first = i;
			DFS(check, i, 0);
		}

		for (int i = 1; i <= n; i++) {
			boolean[] visit = new boolean[n + 1];
			if (cnt[i] >= 1) {
				sb.append("0 ");
			} else {
				int result = bfs(i, visit);
				sb.append(result + " ");
			}
		}

		System.out.println(sb);

	}

	public static int bfs(int V, boolean[] visit) {
		Queue<Point2> que = new LinkedList<Point2>();
	
		int a = V;
		que.add(new Point2(a, 0));
		visit[a] = true;

		while (!que.isEmpty()) {
			Point2 cur = que.poll();
			int curr = cur.v;
			int curTime = cur.distance;
			
			if (cnt[curr] == 1) //깊이가 cycle 만날 때 까지
				return curTime;

			for (int j = 0; j < list[curr].size(); j++) {
				int next = list[curr].get(j);
				if (visit[next] == false) {
					que.add(new Point2(next, curTime + 1));
					visit[next] = true;
				}
			}
		}
		return 0;
	}

	public static void DFS(boolean[] check, int v, int c) {
		if (check[v] && v == first && c >= 2) {
			cnt[v] = 1;
			return;
		}//사이클임
		
		check[v] = true;
		for (int i = 0; i < list[v].size(); i++) {
			int cur = list[v].get(i);

			if (!check[cur]) {
				DFS(check, cur, c + 1);
			} else if (cur == first && c >= 2)
				DFS(check, cur, c); //싸이클 일경우 cnt[v] =1 해줘야해서
			}
	}
}

class Point2 {
	int v, distance;

	Point2(int v, int distance) {
		this.v = v;
		this.distance = distance;
	}
}