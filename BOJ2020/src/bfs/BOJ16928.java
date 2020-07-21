package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ16928.java
 * @author chlgpdus921
 * @date 2020. 7. 15.
 */
/* 뱀과 사다리 게임 */
public class BOJ16928 {
	static int[] cnt = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int[] d = new int[101];

		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			d[x] = y;

		}
		bfs(d);
		System.out.println(cnt[100]);
	}

	public static void bfs(int[] d) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] check = new boolean[101];

		queue.add(1);
		check[1] = true;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 1; i <= 6; i++) {
				int newValue = cur + i;

				if (newValue > 100)
					newValue = cur;

				if (d[newValue] != 0)
					newValue = d[newValue];

				if (check[newValue] == false) {
					check[newValue] = true;

					cnt[newValue] = cnt[cur] + 1;
					queue.add(newValue);
				}
				if (newValue == 100)
					break;

			}

		}
	}

}
