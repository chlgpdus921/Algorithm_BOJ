package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
/**
 * 
 * @FileName BOJ2667.java
 * @author chlgpdus921
 * @date 2020. 5. 19.
 */
/* 단지번호붙이기 */
public class BOJ2667 {
	static int[][] v, color;
	static ArrayList<Integer> list;
	static HashSet<Integer> hs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.valueOf(br.readLine());

		v = new int[N][N];
		color = new int[N][N];
		list = new ArrayList<Integer>();
		hs = new HashSet<Integer>();

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			int j = 0;
			while (j < s.length) {
				v[i][j] = Integer.valueOf(s[j]);
				j++;
			}
		}

		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dfs(i, j, cnt);
				cnt++;
			}
		}

		sb.append(hs.size()).append("\n");
		if (hs.size() != 0) {
			Collections.sort(list);

			int sum = 1;
			ArrayList<Integer> finalResult = new ArrayList<Integer>();
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).equals(list.get(i - 1))) {
					sum++;
				} else {
					finalResult.add(sum);
					sum = 1;
				}
			}

			finalResult.add(sum);
			Collections.sort(finalResult);

			for (int i = 0; i < finalResult.size(); i++) {
				sb.append(finalResult.get(i)).append("\n");
			}
		}
		System.out.println(sb);
	}

	public static void dfs(int i, int j, int cnt) {
		int size = v.length;

		if (v[i][j] == 1 && color[i][j] == 0) {
			color[i][j] = cnt;

			hs.add(color[i][j]);
			list.add(color[i][j]);

			if (i + 1 < size)
				dfs(i + 1, j, cnt);
			if (i - 1 >= 0)
				dfs(i - 1, j, cnt);
			if (j + 1 < size)
				dfs(i, j + 1, cnt);
			if (j - 1 >= 0)
				dfs(i, j - 1, cnt);
		}

	}
}
