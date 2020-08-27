package bfs;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ16236.java
 * @author chlgpdus921
 * @date 2020. 8. 24.
 */
/* 아기 상어 */
public class BOJ16236 {
	static int[][] d;
	static final int[][] distance = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int row = 0, col = 1, n;
	static int[][] check;
	static int MAX = Integer.MAX_VALUE;
	static int shark_size = 2, min_distance = MAX;
	static Baby min = new Baby(MAX, MAX);
	static int result = 0, x, y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		StringTokenizer st;
		check = new int[n][n];
		d = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.valueOf(st.nextToken());

				if (d[i][j] == 9) {
					x = i;
					y = j;
					d[i][j] = 0;
				}
			}
		}
		int eating = 0;
		while (true) {

			reset();
			bfs(x, y);

			if (min.x != MAX && min.y != MAX) {
				result += check[min.x][min.y];

				eating++;
				if (eating == shark_size) {
					eating = 0;
					shark_size++;
				}
			
				d[min.x][min.y] = 0;
				
				x = min.x;
				y = min.y;

			} else
				break;

		}
		System.out.println(result);
	}

	public static void reset() {
		min_distance = MAX;
		min.x = MAX;
		min.y = MAX;
	
		for(int i = 0; i< n; i++) {
			for(int j = 0; j< n; j++) {
				check[i][j] = -1;
			}
		}
	}
	public static void bfs(int x, int y) {
		Queue<Baby> q = new LinkedList<Baby>();
		q.add(new Baby(x, y));
		check[x][y] = 0;

		while (!q.isEmpty()) {
			Baby b = q.poll();

			for (final int[] dis : distance) {
				int nx = b.x + dis[row];
				int ny = b.y + dis[col];

				if (nx >= n || ny >= n || nx < 0 || ny < 0)
					continue;

				if (check[nx][ny] != -1 || d[nx][ny] > shark_size)
					continue;

				check[nx][ny] = check[b.x][b.y] + 1;

				if (d[nx][ny] != 0 && d[nx][ny] < shark_size) {
					if (min_distance > check[nx][ny]) {
						min_distance = check[nx][ny];
						min.x = nx;
						min.y = ny;
					} else if (min_distance == check[nx][ny]) {
						if (min.x > nx) {
							min.x = nx;
							min.y = ny;
						} else if (min.x == nx) {
							if (min.y > ny) {
								min.y = ny;
							}
						}
					}
				}
				q.add(new Baby(nx, ny));
			}
		}
	}
}

class Baby {
	int x, y;

	Baby(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
