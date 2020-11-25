package queue;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ1966.java
 * @author chlgpdus921
 * @date 2020. 11. 13.
 */
/* 프린터 큐 */
public class BOJ1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.valueOf(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int n = Integer.valueOf(st.nextToken());
			int m = Integer.valueOf(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			PriorityQueue<Info1966> q = new PriorityQueue<Info1966>(Collections.reverseOrder());
			Queue<Info1966> data = new LinkedList<Info1966>();

			for (int j = 0; j < n; j++) {
				int num = Integer.valueOf(st.nextToken());
				q.add(new Info1966(j, num));
				data.add(new Info1966(j, num));

			}

			int cnt = 1;
			while (!data.isEmpty()) {
				Info1966 cur = data.poll();
				Info1966 wanted = q.peek();

				if (wanted.priority == cur.priority) {
					q.poll();
					if (cur.index == m) {
						sb.append(cnt + "\n");
					}
					cnt++;

				} else {
					data.add(new Info1966(cur.index, cur.priority));
				}
			}
		}
		System.out.println(sb);
	}
}

class Info1966 {
	int index, priority;

	Info1966(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}

}
