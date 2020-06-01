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
 * @FileName BOJ16929.java
 * @author chlgpdus921
 * @date 2020. 5. 29.
 */
/* Two Dots */
public class BOJ16929 {
	static final int[][] DIRECTIONS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static final int ROW = 0;
	static final int COL = 1;

	static char first = 'A';
	static Point p;
	static boolean result = false;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		char[][] map = new char[n + 2][m + 2];
		for (int i = 1; i <= n; i++) {
			String[] s = br.readLine().split("");
			for (int j = 1; j <= s.length; j++) {
				map[i][j] = s[j - 1].charAt(0);
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				boolean[][] check = new boolean[n + 2][m + 2];
				p = new Point(i, j);
				first = map[i][j]; // 첫번째 문자 저장
				DFS(map, check, p, 0);

				if (result)
					break;
			}

		}

		if (result)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	public static void DFS(char[][] map, boolean[][] check, Point pm, int c) {

		int curX = pm.x;
		int curY = pm.y;

		check[curX][curY] = true;

		for (final int[] direction : DIRECTIONS) {
			int newRow = curX + direction[ROW];
			int newCol = curY + direction[COL];

			if (map[newRow][newCol] == first && check[newRow][newCol] && c >= 3) {

				if (newRow == p.x && newCol == p.y) {
					result = true;
					return;
				}
			} else if (map[newRow][newCol] == first && check[newRow][newCol] == false) {

				DFS(map, check, new Point(newRow, newCol), c + 1);

			}

		}

	}
}

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
