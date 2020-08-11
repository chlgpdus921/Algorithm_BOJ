package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ2206.java
 * @author chlgpdus921
 * @date 2020. 8. 4.
 */
/* 벽 부수고 이동하기 */
/*
 * 벽인 경우 : 1. 이전에 부신 적 없다. 2. 방문한 적 없어야함 
 * 벽이 아닌 경우 : 방문한 적 없으면 방문
 */
public class BOJ2206 {
	static int n, m;
	static int[][] d;
	static boolean[][][] check;
	static final int[][] Distance = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static final int ROW = 0, COL = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		d = new int[n][m];
		check = new boolean[n][m][2];

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.valueOf(temp[j]);
			}
		}
		bfs();

	}

	public static void bfs() {
		Queue<Wall1> q = new LinkedList<>();
		q.add(new Wall1(0, 0, 0, 1));
		check[0][0][0] = true; // 부시지 않은 경우
		check[0][0][1] = true; // 부신 경우

		while (!q.isEmpty()) {
			Wall1 cur = q.poll();
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
				
				if(d[nextX][nextY] == 1 && !check[nextX][nextY][1]) {
					check[nextX][nextY][1] = true;
					q.add(new Wall1(nextX, nextY, 1, cnt + 1));
				}	
				else if (d[nextX][nextY] == 0 && !check[nextX][nextY][breakWall]) {
					check[nextX][nextY][breakWall] = true;
					q.add(new Wall1(nextX, nextY, breakWall, cnt + 1));
				}
			}

		}
		System.out.println(-1);
	}
}

class Wall1 {
	int x, y;
	int breakWall, cnt;

	Wall1(int x, int y, int breakWall, int cnt) {
		this.x = x;
		this.y = y;
		this.breakWall = breakWall;
		this.cnt = cnt;
	}
}