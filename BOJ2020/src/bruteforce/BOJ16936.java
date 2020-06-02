package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 
 * @FileName BOJ16936.java
 * @author chlgpdus921
 * @date 2020. 5. 29.
 */
/* 나3곱2 */
public class BOJ16936 {
	static Long[] arr;
	static String data;
	static int n;
	static ArrayList<Long>[] list;
	static Long[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		arr = new Long[n];
		list = new ArrayList[n];

		for (int p = 0; p < n; p++) {
			list[p] = new ArrayList<>();
		}

		data = " ";
		int i = 0;
		while (st.hasMoreElements()) {
			arr[i] = Long.valueOf(st.nextToken());
			data = data + arr[i] + " ";
			list[i].add(arr[i]);
			i++;
		}

		for (int k = 0; k < n; k++) {
			boolean[] check = new boolean[n];
			result = new Long[n];
			int result2 = bfs(k, check);

			if (result2 == n) {
				for (int a = 0; a < n; a++) {
					sb.append(result[a] + " ");
				}
				break;
			}
		}

		System.out.println(sb);
	}

	public static int bfs(int index, boolean[] check) {
		int cnt = 0, tempSum = 0;
		Queue<Info> queue = new LinkedList<Info>();
		queue.add(new Info(index, arr[index]));

		while (!queue.isEmpty()) {
			Info cur = queue.poll();

			int curIndex = cur.index;

			Long value1 = arr[curIndex] * 2;
			Long value2 = null;

			if (arr[curIndex] % 3 == 0) {
				value2 = arr[curIndex] / 3;
			}
			if (check[curIndex] == false) {
				if (data.contains(" " + value1 + " ") && !check[search(value1)]) {
					queue.add(new Info(search(value1), value1));
				}
				if (data.contains(" " + value2 + " ") && !check[search(value2)]) {
					queue.add(new Info(search(value2), value2));
				}
				check[curIndex] = true;
				result[cnt] = cur.data;
				cnt++;
			}
			tempSum++;
			if (tempSum != cnt || tempSum > n)
				return 0;
		}
		return cnt;
	}

	public static int search(Long var) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].get(0).equals(var)) {
				return i;
			}
		}
		return 0;
	}
}

class Info {
	int index;
	Long data;

	Info(int index, Long data) {
		this.index = index;
		this.data = data;
	}
}