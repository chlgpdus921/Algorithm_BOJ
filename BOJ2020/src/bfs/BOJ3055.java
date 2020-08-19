package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 
 * @FileName BOJ3055.java
 * @author chlgpdus921
 * @date 2020. 8. 16.
 */
/* 탈출 */
public class BOJ3055 {
	static final int[][] Distance = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static final int row = 0, col = 1;
	static String[][] data;
	static int n, m, cnt = 0;
	static String result = "";
	static Queue<Escape> q, water;
	static boolean[][] check, checkWater;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		data = new String[n][m];
		for (int i = 0; i < n; i++) {
			data[i] = br.readLine().split("");
		}

		q = new LinkedList<Escape>();
		water = new LinkedList<Escape>();

		check = new boolean[n][m];
		checkWater = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (data[i][j].equals("S")) {
					q.add(new Escape(i, j));
					check[i][j] = true;
				} else if (data[i][j].equals("*")) {
					water.add(new Escape(i, j));
					checkWater[i][j] = true;
				}
			}
		}

		bfs(0);
		if (cnt == 0)
			result = "KAKTUS";
		else
			result = String.valueOf(cnt);
		System.out.println(result);

	}

	public static void bfs(int depth) {
		int waterSize = water.size();
		int a = 0;

		while (a < waterSize) {
			Escape waterL = water.poll();
			for (final int[] distance : Distance) {
				int waterR = waterL.x + distance[row];
				int waterC = waterL.y + distance[col];

				if (waterR < 0 || waterR >= n || waterC < 0 || waterC >= m)
					continue;

				if (!checkWater[waterR][waterC] && !data[waterR][waterC].equals("D")
						&& !data[waterR][waterC].equals("X")) {
					data[waterR][waterC] = "*";
					checkWater[waterR][waterC] = true;
					water.add(new Escape(waterR, waterC));
				}
			}
			a++;
		}

		int b = 0;
		int queueSize = q.size();

		if (queueSize == 0) {
			return;
		}

		while (b < queueSize) {
			Escape cur = q.poll();

			if (data[cur.x][cur.y].equals("D")) {
				cnt = depth;
				return;
			}
			for (final int[] distance : Distance) {
				int nextR = cur.x + distance[row];
				int nextC = cur.y + distance[col];

				if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m)
					continue;

				if (!check[nextR][nextC] && !data[nextR][nextC].equals("*") && !data[nextR][nextC].equals("X")) {
					q.add(new Escape(nextR, nextC));

					check[nextR][nextC] = true;
				}
			}
			b++;
		}

		bfs(depth + 1);

	}

}

class Escape {
	int x, y;

	Escape(int x, int y) {
		this.x = x;
		this.y = y;
	}
}