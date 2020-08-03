package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ9019.java
 * @author chlgpdus921
 * @date 2020. 8. 3.
 */
/* DSLR */
public class BOJ9019 {
	static int from, to;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.valueOf(st.nextToken());
			to = Integer.valueOf(st.nextToken());
			sb.append(bfs()).append("\n");
		}
		System.out.println(sb);

	}

	public static String bfs() {
		int[] check = new int[10000];
		Arrays.fill(check, -1);
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(from);
		check[from] = from;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == to) {
				break;
			}
			for (int i = 0; i < 4; i++) {
				int next = DSLR(cur, i);
				if (check[next] == -1) {
					check[next] = cur;
					q.add(next);
				}

			}
		}

		String temp = "";
		String[] index = { "D", "S", "L", "R" };
		int cur = to;
		while (cur != check[cur]) {
			int next = check[cur];
			for (int i = 0; i < 4; i++) {
				if (DSLR(next, i) == cur) {
					temp += index[i];
					break;
				}
			}
			cur = next;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(temp);
		sb.reverse();
		return sb.toString();
	}

	public static int DSLR(int n, int t) {
		if (t == 0)
			return (n << 1) % 10000;
		else if (t == 1)
			return (n == 0) ? 9999 : n - 1;
		else if (t == 2)
			return (n % 1000) * 10 + n / 1000;
		else
			return n / 10 + (n % 10) * 1000;
	}
}
