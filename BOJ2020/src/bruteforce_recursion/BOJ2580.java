package bruteforce_recursion;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ2580.java
 * @author chlgpdus921
 * @date 2020. 7. 28.
 */
/* 스도쿠 */
public class BOJ2580 {
	static int[][] d;
	static boolean[][] row, col, square;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		d = new int[9][9];
		row = new boolean[9][10];
		col = new boolean[9][10];
		square = new boolean[9][10];

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while (st.hasMoreElements()) {
				d[i][j] = Integer.valueOf(st.nextToken());
				if (d[i][j] != 0) {
					row[i][d[i][j]] = true;
					col[j][d[i][j]] = true;
					square[checkSqaureIndex(i, j)][d[i][j]] = true;
				}
				j++;
			}
		}
		dfs(0);

	}

	public static void dfs(int cnt) {
		if (cnt >= 81) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(d[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		int x = cnt / 9;
		int y = cnt % 9;

		if (d[x][y] != 0) {
			dfs(cnt + 1);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (!row[x][i] && !col[y][i] && !square[checkSqaureIndex(x, y)][i]) {
					d[x][y] = i;
					row[x][i] = true;
					col[y][i] = true;
					square[checkSqaureIndex(x, y)][i] = true;
					dfs(cnt + 1);
					d[x][y] = 0;
					row[x][i] = false;
					col[y][i] = false;
					square[checkSqaureIndex(x, y)][i] = false;

				}
			}
		}

	}

	public static int checkSqaureIndex(int i, int j) {
		return i / 3 * 3 + j / 3;
	}

}
