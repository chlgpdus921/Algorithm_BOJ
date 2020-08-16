package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @FileName BOJ16954.java
 * @author chlgpdus921
 * @date 2020. 8. 7.
 */
/* 움직이는 미로 탈출 */
public class BOJ16954 {
	static String[][] map;
	static final int[][] distance = { { -1, 0 }, { 1, 0 }, { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, -1 }, { 1, 1 },
			{ -1, -1 }, { -1, 1 } };
	static final int row = 0, col = 1;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new String[9][9];
		for (int i = 0; i < 8; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				map[i][j] = s[j];

			}
		}
		bfs();
		System.out.println(result);

	}

	public static void bfs() {
		Queue<Maze> q = new LinkedList<>();
		boolean[][][] check = new boolean[9][8][8]; // 맨앞은 시간임
		q.add(new Maze(0, 7, 0));
		check[0][7][0] = true;

		while (!q.isEmpty()) {
			Maze m = q.poll();

			if (m.x == 0 && m.y == 7) {
				result = 1;
				break;
			}

			for (final int[] dis : distance) {
				int nextR = m.x + dis[row];
				int nextC = m.y + dis[col];
				int nextTime = Math.min(m.time + 1, 8);

				if (nextR >= 8 || nextR < 0 || nextC < 0 || nextC >= 8)
					continue;

				if (nextR - m.time >= 0 && map[nextR - m.time][nextC].equals("#"))
					continue;
				// 이동할 곳이 벽인지 확인

				if (nextR - m.time - 1 >= 0 && map[nextR - m.time - 1][nextC].equals("#"))
					continue;
				// 다음에 내려올 곳이 벽인지 확인

				if (!check[nextTime][nextR][nextC]) {
					check[nextTime][nextR][nextC] = true;
					q.add(new Maze(nextTime, nextR, nextC));
				}
			}

		}

	}
}

class Maze {
	int time, x, y;

	Maze(int time, int x, int y) {
		this.time = time;
		this.x = x;
		this.y = y;
	}
}
