package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ7576.java
 * @author chlgpdus921
 * @date 2020. 5. 21.
 */
/* 토마토 */
public class BOJ7576 {
	static int[][] map, count;
	static final int[][] DISTANCE = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Pair2> queue;
	static final int ROW = 0, COL = 1;
	static boolean[][] check;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		map = new int[N + 2][M + 2];
		count = new int[N + 2][M + 2];
		queue = new LinkedList<Pair2>();
		check = new boolean[N + 2][M + 2];
		int zeroCnt = 0, oneCnt = 0;

		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], -1);
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = 1;

			while (st.hasMoreElements()) {
				map[i][j] = Integer.valueOf(st.nextToken());
				if (map[i][j] == -1)
					count[i][j] = -1;

				if (map[i][j] == 1) {
					oneCnt++;
					// 입력 받을 때, queue에 바로 저장
					queue.add(new Pair2(i, j));
				}
				j++;
			}
		}

		BFS();
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (count[i][j] == 0) {
					zeroCnt++;
				}
				if (count[i][j] > max) {
					max = count[i][j];
				}
			}

		}

		if (zeroCnt != oneCnt)
			System.out.println("-1");
		else
			System.out.println(max);

	}

	public static void BFS() {

		while (!queue.isEmpty()) {
			Pair2 p = queue.poll();
			int curX = p.x;
			int curY = p.y;

			for (final int[] distance : DISTANCE) {
				int newRow = curX + distance[ROW];
				int newCol = curY + distance[COL];

				if (map[newRow][newCol] == 0 && check[newRow][newCol] == false) {
					int tmp = count[curX][curY] + 1;
					check[newRow][newCol] = true;
					if (count[newRow][newCol] > tmp || count[newRow][newCol] == 0)
						count[newRow][newCol] = tmp;

					queue.add(new Pair2(newRow, newCol));

				}

				else if (map[newRow][newCol] == -1) {
					count[newRow][newCol] = -1;
				}
			}

		}
	}

}

class Pair2 {
	int x, y;

	Pair2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}