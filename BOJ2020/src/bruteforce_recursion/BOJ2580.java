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
	static final int ROW = 0, COL = 1;
	static final int[][] DISTANCE = { { 1, 0 }, { 2, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		d = new int[10][10];

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while (st.hasMoreElements()) {
				d[i][j] = Integer.valueOf(st.nextToken());
				
				j++;
			}
		}
		bruteforce();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(d[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void bruteforce() {

		for (int x = 1; x < 10; x++) {
			for (int y = 1; y < 10; y++) {

				int rowSum = 0;
				int colSum = 0;
				int squareSum = d[x][y];

				int total1 = 0, total2 = 0, total3 = 0;
				for (int i = 1; i < 10; i++) {
					rowSum += d[x][i];
					colSum += d[i][y];
					if (d[x][i] == 0)
						total1++;
					if (d[i][y] == 0)
						total2++;
				}
				if (x == 1 || x == 4 || x == 7) {
					if (y == 1 || y == 4 || y == 7) {

						for (final int[] distance : DISTANCE) {
							int newRow = x + distance[ROW];
							int newCol = y + distance[COL];
							if (d[newRow][newCol] == 0)
								total3++;
							squareSum += d[newRow][newCol];

						}
					}

				}

				int value1 = 45 - rowSum;
				int value2 = 45 - colSum;
				int value3 = 45 - squareSum;

				if (total1 == 1 && value1 > 0 && value1 < 10) {
					fillNum(x, value1);
				}
				if (total2 == 1 && value2 > 0 && value2 < 10) {
					fillNum2(y, value2);
				}
				if (total3 == 1 && value3 > 0 && value3 < 10) {
					fillNum3(x, y, value3);
				}
			}
		}

	}

	public static void fillNum(int x, int value) {
		for (int j = 1; j < 10; j++) {
			if (d[x][j] == 0)
				d[x][j] = value;
		}
	}

	public static void fillNum2(int x, int value) {
		for (int j = 1; j < 10; j++) {
			if (d[j][x] == 0)
				d[j][x] = value;
		}
	}

	public static void fillNum3(int x, int y, int value) {
		for (final int[] distance : DISTANCE) {
			int newRow = x + distance[ROW];
			int newCol = y + distance[COL];
			if (d[newRow][newCol] == 0) {
				d[newRow][newCol] = value;
			}

		}
	}

}
