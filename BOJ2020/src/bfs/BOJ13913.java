package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ13913.java
 * @author chlgpdus921
 * @date 2020. 5. 29.
 */
/* 숨바꼭질4 
 * input : 5 17
 * 최단 거리 : 4
 * 경로 : 5 10 9 18 17
 * */
public class BOJ13913 {
	static StringBuilder sb;
	static int[] before;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();

		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());

		BFS(n, k);
		moveData(n, k);
		System.out.println(sb);
	}

	public static void BFS(int n, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] check = new boolean[100001];
		int[] index = new int[100001];
		before = new int[100001];
		q.add(n);
		check[n] = true;
		index[n]++;

		int next = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == k)
				break;

			int[] arr = { cur - 1, cur + 1, cur * 2 };

			for (int i = 0; i < 3; i++) {
				next = arr[i];
				if (next >= 0 && next < 100001 && !check[next]) {
					index[next] = index[cur] + 1;
					q.add(next);
					before[next] = cur;
					check[next] = true;
				}
			}
		}

		System.out.println(index[k] - 1);
	}

	public static void moveData(int n, int k) {
		if (n != k) {
			moveData(n, before[k]);
		}
		sb.append(k + " ");
	}
	
	
	/*
	 * 시간 초과 뜬거 
	 * public static void moveData(int n, int k) { int index = before[k];
	 * 
	 * sb.append(k + " "); while (index != n) { sb.insert(0, index + " "); index =
	 * before[index]; } sb.insert(0, n + " ");
	 * 
	 * }
	 */

}
