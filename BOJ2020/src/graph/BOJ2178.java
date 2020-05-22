package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ2178.java
 * @author chlgpdus921
 * @date 2020. 5. 21.
 */
/*
 * 미로 탐색 
 * DFS는 모든 경로를 다 찾아야해서 시간초과가 나지만, BFS는 깊이가 곧 최단거리이기 때문에, 모든 칸을 방문하기만 하면
 * 된다.
 */
public class BOJ2178 {
	static boolean[][] map;
	static int N, M;
	static final int[][] DIRECTIONS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static final int ROW = 0;
	static final int COL = 1;

	static int cnt = 1;

	static Queue<Pair> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		map = new boolean[N + 2][M + 2];
		boolean[][] check = new boolean[N + 2][M + 2];
		int[][] count = new int[N + 2][M + 2];

		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 1; j <= s.length; j++) {
				map[i][j] = s[j - 1].equals("1") ? true : false;
			}
		}

		queue = new LinkedList<Pair>();
		BFS(check, count);

		System.out.println(cnt);
	}

	public static void BFS(boolean[][] check, int[][] count) {
		check[1][1] = true;
		queue.add(new Pair(1, 1));
		count[1][1] = 1;

		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			int curX = p.x;
			int curY = p.y;

			for (final int[] direction : DIRECTIONS) {
				int newRow = curX + direction[ROW];
				int newCol = curY + direction[COL];

				if (map[newRow][newCol] == true && check[newRow][newCol] == false) {
					check[newRow][newCol] = true;
					count[newRow][newCol] = count[curX][curY] + 1;
					cnt = count[newRow][newCol];
					queue.add(new Pair(newRow, newCol));

				}
				if (newRow == N && newCol == M) {
					return;
				}
			}
		}

	}

}

class Pair {
	int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
