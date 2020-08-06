package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ14502.java
 * @author chlgpdus921
 * @date 2020. 8. 3.
 */
/* 연구소 */
public class BOJ14502 {
	static int[][] ori;
	static int n, m;
	static int MAX = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		ori = new int[n][m];
		int[][] d = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while (st.hasMoreElements()) {
				ori[i][j] = Integer.valueOf(st.nextToken());
				j++;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy(d, ori);
				if (d[i][j] == 0) {
					d[i][j] = 1;
					dfs(1, d);
					d[i][j] = 0;
				}

			}
		}
		System.out.println(MAX);
	}

	public static void dfs(int cnt, int[][] d) {

		if (cnt == 3) {
			checkvirus(d);
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (d[i][j] == 0) {
					d[i][j] = 1;
					dfs(cnt + 1, d);
					d[i][j] = 0;
				}
			}

		}
	}

	public static void checkvirus(int[][] d) {
		int[][] distance = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		int row = 0, col = 1;
		boolean[][] check = new boolean[n][m];
		Queue<Research> q = new LinkedList<Research>();

		int[][] temp = new int[n][m];
		copy(temp, d);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 2) {
					q.add(new Research(i, j));
					check[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Research r = q.poll();
			int x = r.x;
			int y = r.y;
			for (final int[] dis : distance) {
				int nextX = x + dis[row];
				int nextY = y + dis[col];

				if (nextX < n && nextX >= 0 && nextY < m && nextY >= 0 && temp[nextX][nextY] == 0
						&& !check[nextX][nextY]) {
					temp[nextX][nextY] = 2;
					check[nextX][nextY] = true;
					q.add(new Research(nextX, nextY));
				}
			}

		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0)
					cnt++;
			}
		}
		if (cnt > MAX)
			MAX = cnt;
	}

	public static void copy(int[][] c, int[][] copy) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				c[i][j] = copy[i][j];
			}
		}
	}
}

class Research {
	int x, y;

	Research(int x, int y) {
		this.x = x;
		this.y = y;
	}
}