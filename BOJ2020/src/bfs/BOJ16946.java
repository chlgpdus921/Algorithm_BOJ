package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ16946.java
 * @author chlgpdus921
 * @date 2020. 8. 4.
 */
/* 벽 부수고 이동하기 4 */
public class BOJ16946 {
	static int n, m;
	static int[][] d, group;
	static int[] groupsize;
	static final int[][] Distance = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static final int ROW = 0, COL = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		d = new int[n][m];
		group = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				d[i][j] = Integer.valueOf(temp[j]);
			}
		}
		
		//그룹 번호 지정하기 
		int groupIndex = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (d[i][j] == 0 && group[i][j] == 0) {
					bfs(i, j, groupIndex);
					groupIndex++;

				}
			}
		}

		//그룹별 갯수 카운트
		groupsize = new int[groupIndex + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (group[i][j] != 0) {
					groupsize[group[i][j]]++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(count(i, j) + "");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static void bfs(int i, int j, int index) {
		Queue<Wall4> q = new LinkedList<>();
		q.add(new Wall4(i, j));
		group[i][j] = index;

		while (!q.isEmpty()) {
			Wall4 cur = q.poll();
			int x = cur.x;
			int y = cur.y;

			for (final int[] distance : Distance) {
				int nextX = x + distance[ROW];
				int nextY = y + distance[COL];

				if (nextX >= n || nextX < 0 || nextY >= m || nextY < 0)
					continue;

				if (d[nextX][nextY] == 0 && group[nextX][nextY] == 0) {
					group[nextX][nextY] = index;
					q.add(new Wall4(nextX, nextY));
				}
			}

		}
	}

	public static int count(int i, int j) {
		Set<Integer> set = new HashSet<Integer>();

		if (d[i][j] == 0)
			return 0;

		for (final int[] distance : Distance) {
			int nextX = i + distance[ROW];
			int nextY = j + distance[COL];

			if (nextX >= n || nextX < 0 || nextY >= m || nextY < 0)
				continue;

			if (group[nextX][nextY] != 0) {

				set.add(group[nextX][nextY]);
			}
		}
		int cnt = 1;
		for (int index : set) {
			cnt += groupsize[index];
		}

		return cnt % 10;
	}
}

class Wall4 {
	int x, y;

	Wall4(int x, int y) {
		this.x = x;
		this.y = y;
	}
}