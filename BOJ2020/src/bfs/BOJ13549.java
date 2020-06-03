package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ13549.java
 * @author chlgpdus921
 * @date 2020. 5. 29.
 */
/* 숨바꼭질 3 */
public class BOJ13549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		boolean[] check = new boolean[1000001];
		int[] index = new int[1000001];
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(n);
		check[n] = true;
		index[n]++;
		int value = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			int[] tmp = { cur * 2, cur - 1, cur + 1 };

			for (int i = 0; i < 3; i++) {
				value = tmp[i];

				if (value >= 0 && value < 1000001 && check[value] == false) {
					if(i !=0) {
					index[value] = index[cur] + 1;
					}
					check[value] = true;
					queue.add(value);

				}
				if (value == k)
					break;
			}

			if (value == k)
				break;
		}

		System.out.println(index[k]);

}

}
	/*static StringBuilder sb;
	static int[] before;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();

		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());

		BFS(n, k);

		System.out.println(sb);
	}

	public static void BFS(int n, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] check = new boolean[100001];
		int[] index = new int[100001];
		before = new int[100001];
		q.add(n);
		check[n] = true;
	//	index[n]++;

		int next = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == k)
				break;

			int[] arr = { cur * 2, cur - 1, cur + 1 };
			int[] time = { 0, 1, 1 };
			for (int i = 0; i < 3; i++) {
				next = arr[i];
				if (next >= 0 && next < 100001 && !check[next]) {
					int temp = index[cur] + time[i];
					if(index[next] > temp) {
						index[next]  = temp;
					}
					q.add(next);
					before[next] = cur;
					check[next] = true;
				}
			}
		}
		System.out.println(index[k] );
	}

}*/