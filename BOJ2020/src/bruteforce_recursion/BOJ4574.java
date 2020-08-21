package bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * @FileName BOJ4574.java
 * @author chlgpdus921
 * @date 2020. 8. 4.
 */
/* 스도미노쿠 */
public class BOJ4574 {
	static int[][] dir = { { 0, 1 }, { 1, 0 } };
	static int[][] d;
	static boolean[][] col, row, domino;
	static boolean[][][] square;
	static int n, t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		t = 0;

		while (true) {
			t++;
			n = Integer.valueOf(br.readLine());

			if (n == 0)
				break;

			d = new int[9][9];
			row = new boolean[9][10];
			col = new boolean[9][10];
			square = new boolean[3][3][10];
			domino = new boolean[10][10];

			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());

				int num1 = Integer.valueOf(st.nextToken());
				char[] position1 = st.nextToken().toCharArray();
				int num2 = Integer.valueOf(st.nextToken());
				char[] position2 = st.nextToken().toCharArray();

				int r1 = position1[0] - 'A';
				int c1 = position1[1] - '0' - 1;
				int r2 = position2[0] - 'A';
				int c2 = position2[1] - '0' - 1;

				d[r1][c1] = num1;
				d[r2][c2] = num2;

				row[r1][num1] = true;
				col[c1][num1] = true;
				row[r2][num2] = true;
				col[c2][num2] = true;
				square[r1 / 3][c1 / 3][num1] = true;
				square[r2 / 3][c2 / 3][num2] = true;

				domino[num1][num2] = true;
				domino[num2][num1] = true;
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 9; ++i) {
				char[] position = st.nextToken().toCharArray();
				int r = position[0] - 'A';
				int c = position[1] - '0' - 1;

				row[r][i] = true;
				col[c][i] = true;
				square[r / 3][c / 3][i] = true;
				d[r][c] = i;
			}
			System.out.println("Puzzle " + t);
			dfs(0);
		}
	}

	private static boolean dfs(int cnt) {
		if (cnt == 81) {
			for (int r = 0; r < 9; ++r) {
				for (int c = 0; c < 9; ++c) {
					System.out.print(d[r][c]);
				}
				System.out.println();
			}
			return true;
		}

		int x = cnt / 9;
		int y = cnt % 9;

		// 아직 숫자를 놓지 않았으면서
		if (d[x][y] == 0) {
			// 가로 또는 세로로 놓는 경우
			for (int a = 0; a < 2; a++) {
				int nr = x + dir[a][0];
				int nc = y + dir[a][1];

				if (nr > 8 || nc > 8 || d[nr][nc] != 0)
					continue;

				// 모든 서로 다른 숫자 쌍
				for (int i = 1; i < 9; ++i) {
					for (int j = i + 1; j < 10; ++j) {
						if (domino[i][j] || domino[j][i])
							continue;
						domino[i][j] = domino[j][i] = true;

						// i, j가 행과 열에 사용된적 없어야 하며 3x3 사각형에도 사용된적 없어야 한다.
						if (!row[x][i] && !col[y][i] && !square[x / 3][y / 3][i]) {
							if (!row[nr][j] && !col[nc][j] && !square[nr / 3][nc / 3][j]) {
								row[x][i] = col[y][i] = true;
								square[x / 3][y / 3][i] = true;
								row[nr][j] = col[nc][j] = true;
								square[nr / 3][nc / 3][j] = true;

								d[x][y] = i;
								d[nr][nc] = j;
								if (dfs(cnt + 1))
									return true;
								d[nr][nc] = 0;
								d[x][y] = 0;

								row[x][i] = col[y][i] = false;
								square[x / 3][y / 3][i] = false;
								row[nr][j] = col[nc][j] = false;
								square[nr / 3][nc / 3][j] = false;
							}
						}

						// j, i가 행과 열에 사용된적 없어야 하며 3x3 사각형에도 사용된적 없어야 한다.
						if (!row[x][j] && !col[y][j] && !square[x / 3][y / 3][j]) {
							if (!row[nr][i] && !col[nc][i] && !square[nr / 3][nc / 3][i]) {
								row[x][j] = col[y][j] = true;
								square[x / 3][y / 3][j] = true;
								row[nr][i] = col[nc][i] = true;
								square[nr / 3][nc / 3][i] = true;

								d[x][y] = j;
								d[nr][nc] = i;
								if (dfs(cnt + 1))
									return true;
								d[nr][nc] = 0;
								d[x][y] = 0;

								row[x][j] = col[y][j] = false;
								square[x / 3][y / 3][j] = false;
								row[nr][i] = col[nc][i] = false;
								square[nr / 3][nc / 3][i] = false;

							}
						}
						domino[i][j] = domino[j][i] = false;
					}
				}
			}
		} else {
			// 현재 지역에 숫자가 이미 있으면 넘어간다.
			if (dfs(cnt + 1))
				return true;
		}

		return false;
	}
}