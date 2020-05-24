package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ4963.java
 * @author chlgpdus921
 * @date 2020. 5. 21.
 */
/* 섬의 개수 */
public class BOJ4963 {
	static final int[][] directions = { { -1, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { 1, 1 }, { 0, -1 }, { 0, 1 },
			{ 1, -1 } };
	static int cnt = 0;
	static final int ROW = 0;
	static final int COL = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int W = 1;
		int H = 1;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			W = Integer.valueOf(st.nextToken());
			H = Integer.valueOf(st.nextToken());
			
			if (W == 0 && H == 0)
				break;
			
			boolean[][] map = new boolean[H + 2][W + 2];
			boolean[][] check = new boolean[H + 2][W + 2];
			for (int i = 1; i <= H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int j = 1;
				while (st.hasMoreElements()) {
					map[i][j] = (st.nextToken()).equals("1") ? true : false;
					j++;
				}
			}
			int sum = 0;
			for (int x = 1; x <= H; x++) {
				for (int y = 1; y <= W; y++) {
					cnt = 0;
					if (map[x][y] == true && check[x][y] == false) {
						dfs(map, check, x, y);
						if (cnt != 0)
							sum++;
					}

				}
			}

			sb.append(sum).append("\n");

		}
		System.out.println(sb);
	}

	public static void dfs(boolean[][] map, boolean[][] check, int i, int j) {
		check[i][j] = true;
		cnt++;

		for (final int[] direction : directions) {
			int newRow = i + direction[ROW];
			int newCol = j + direction[COL];

			if (map[newRow][newCol] == true && check[newRow][newCol] == false) {
				dfs(map, check, newRow, newCol);
			}
		}
	}

}
