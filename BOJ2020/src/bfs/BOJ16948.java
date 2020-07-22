package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ16948.java
 * @author chlgpdus921
 * @date 2020. 7. 15.
 */
/* 데스 나이트 */
public class BOJ16948 {
	static final int[][] ROW = { { -2, -1 }, { -2, 1 }, { 0, -2 }, { 0, 2 }, { 2, -1 }, { 2, 1 } };
	static int[][] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int r1 = Integer.valueOf(st.nextToken());
		int c1 = Integer.valueOf(st.nextToken());
		int r2 = Integer.valueOf(st.nextToken());
		int c2 = Integer.valueOf(st.nextToken());

		cnt = new int[n + 1][n + 1];
		bfs(n, r1, c1, r2, c2);
		System.out.println(cnt[r2][c2] == 0 ? -1 : cnt[r2][c2]);
	}

	public static void bfs(int n, int r1, int c1, int r2, int c2) {
		Queue<Desnite> queue = new LinkedList<Desnite>();
		queue.add(new Desnite(r1, c1));
		boolean[][] check = new boolean[n + 1][n + 1];

		while (!queue.isEmpty()) {
			Desnite cur = queue.poll();

			for (int i = 0; i < ROW.length; i++) {
				int nextX = cur.x + ROW[i][0];
				int nextY = cur.y + ROW[i][1];

				if (nextX >= 0 && nextX <= n && nextY >= 0 && nextY <= n && check[nextX][nextY] == false) {
					check[nextX][nextY] = true;
					cnt[nextX][nextY] = cnt[cur.x][cur.y] + 1;
					queue.add(new Desnite(nextX, nextY));
				}
			}
		}
	}

}

class Desnite {
	int x, y;

	Desnite(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
