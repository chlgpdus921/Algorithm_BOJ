package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ13023.java
 * @author chlgpdus921
 * @date 2020. 5. 17.
 */
/* ABCDE */
public class BOJ13023 {
	static int n, m;
	static boolean check = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		// int[][] mat = new int[n][n]; // 인접 행렬 //한번 만들어봄
		boolean[] visitCheck = new boolean[n];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(n); //인접리스트

		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			// mat[a][b] = 1; // from to 구현
			// mat[b][a] = 1;
			list.get(a).add(b);
			list.get(b).add(a);

		}

		/*
		 * for (int i = 0; i < n; i++) { //System.out.println(list.get(i)); }
		 */
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			visitCheck[i] = true;

			for (int j = 0; j < list.get(i).size(); j++) {
				int value = list.get(i).get(j);
				visitCheck[value] = true;
				bfs(list, visitCheck, value, cnt, i);
				visitCheck[value] = false;

				if (check) {
					break;
				}

			}
			if (check) {
				break;
			}
			visitCheck[i] = false;
		}

		if (check)
			System.out.println(1);
		else
			System.out.println(0);
	}

	public static void bfs(ArrayList<ArrayList<Integer>> list, boolean[] visitCheck, int value, int cnt, int index) {
		if (cnt == 4) {
			check = true;
			return;
		}

		for (int j = 0; j < list.get(value).size(); j++) {
			int cur = list.get(value).get(j);

			if (!visitCheck[cur]) {
				visitCheck[cur] = true;
				bfs(list, visitCheck, cur, cnt + 1, index);
				visitCheck[cur] = false;
			}
		}
	}
}
