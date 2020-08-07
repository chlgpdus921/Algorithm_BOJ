package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ16933.java
 * @author chlgpdus921
 * @date 2020. 8. 4.
 */
/* 벽 부수고 이동하기 3 */
/* 밤 ,  낮 state 한개 추가했다. */
public class BOJ16933 {
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
		// 1 = 낮, 0 = 밤
		Queue<Wall3> q = new LinkedList<>();
		q.add(new Wall3(0, 0, 0, 1, 1));
		check[0][0][0] = true;
		check[0][0][1] = true;

		while (!q.isEmpty()) {
			Wall3 cur = q.poll();
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
				int state = cur.state;

				if (nextX >= n || nextX < 0 || nextY >= m || nextY < 0)
					continue;

				// 0인 경우
				if (d[nextX][nextY] == 0 && !check[nextX][nextY][breakWall]) {
					check[nextX][nextY][breakWall] = true;
					q.add(new Wall3(nextX, nextY, breakWall, cnt + 1, ((state + 1) % 2)));
				} else if (d[nextX][nextY] == 1 && breakWall < k) { // 벽인 경우
					
					if (state == 1) { // 낮인 경우
						if (!check[nextX][nextY][breakWall + 1]) {
							check[nextX][nextY][breakWall + 1] = true;
							q.add(new Wall3(nextX, nextY, breakWall + 1, cnt + 1, ((state + 1) % 2)));
						}
					} else {
						// 밤인 경우 제자리 
						q.add(new Wall3(x, y, breakWall, cnt + 1, ((state + 1) % 2)));
					}
				}
			}

		}
		System.out.println(-1);
	}
}

class Wall3 {
	int x, y;
	int breakWall, cnt;
	int state;

	Wall3(int x, int y, int breakWall, int cnt, int state) {
		this.x = x;
		this.y = y;
		this.breakWall = breakWall;
		this.cnt = cnt;
		this.state = state;
	}
}