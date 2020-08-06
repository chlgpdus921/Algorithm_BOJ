package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ14442.java
 * @author chlgpdus921
 * @date 2020. 8. 4.
 */
/* 벽 부수고 이동하기 2 */
/* 벽을 몇개 부수고 왔는지 기록한다. - k보다 작은지 매번 체크 */
public class BOJ14442 {
	static int n, m, k;
	static int[][] d;
	static boolean[][][] check;
	static final int[][] Distance = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static final int ROW = 0, COL = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());

		d = new int[n][m];
		check = new boolean[n][m][k + 1];

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.valueOf(temp[j]);
			}
		}
		bfs();

	}

	public static void bfs() {
		Queue<Wall2> q = new LinkedList<>();
		q.add(new Wall2(0, 0, 0, 1));
		check[0][0][0] = true; // 부시지 않은 경우
		check[0][0][1] = true; // 부신 경우

		while (!q.isEmpty()) {
			Wall2 cur = q.poll();
			int x = cur.x;
			int y = cur.y;

			if (x == n - 1 && y == m - 1) {
				System.out.println(cur.cnt);
				return;
			}

			for (final int[] distance : Distance) {
				int nextX = x + distance[ROW];
				int nextY = y + distance[COL];
				int breakWall = cur.breakWall;
				int cnt = cur.cnt;

				if (nextX >= n || nextX < 0 || nextY >= m || nextY < 0)
					continue;

				if (d[nextX][nextY] == 1 && breakWall < k && !check[nextX][nextY][breakWall + 1]) {
					check[nextX][nextY][breakWall + 1] = true;
					q.add(new Wall2(nextX, nextY, breakWall + 1, cnt + 1));

				} else if (d[nextX][nextY] == 0 && !check[nextX][nextY][breakWall]) {
					check[nextX][nextY][breakWall] = true;
					q.add(new Wall2(nextX, nextY, breakWall, cnt + 1));
				}
			}

		}
		System.out.println(-1);
	}
}

class Wall2 {
	int x, y;
	int breakWall, cnt;

	Wall2(int x, int y, int breakWall, int cnt) {
		this.x = x;
		this.y = y;
		this.breakWall = breakWall;
		this.cnt = cnt;
	}
}