package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @FileName BOJ2667_2.java
 * @author chlgpdus921
 * @date 2020. 5. 21.
 */
/* 단지번호붙이기
 * 모범답안  */
public class BOJ2667_2 {
	static boolean[][] map, color;
	static int cnt;

	static final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static final int ROW = 0;
	static final int COL = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.valueOf(br.readLine());

		map = new boolean[N + 2][N + 2];
		color = new boolean[N + 2][N + 2];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			int j = 0;
			while (j < s.length) {
				map[i][j] = s[j].equals("1") ? true : false;
				j++;
			}
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt = 0;
				if (map[i][j] == true && color[i][j] == false) {
					dfs(i, j);
					if (cnt != 0) {
						list.add(cnt);
					}
				}

			}
		}

		Collections.sort(list);

		sb.append(list.size());
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}

		System.out.println(sb);
	}

	public static void dfs(int i, int j) {
		color[i][j] = true;
		cnt++;

		for (final int[] direction : directions) {
			int nextRow = i + direction[ROW];
			int nextCol = j + direction[COL];

			if (color[nextRow][nextCol] == false && map[nextRow][nextCol]) {
				dfs(nextRow, nextCol);
			}

		}
	}
}
