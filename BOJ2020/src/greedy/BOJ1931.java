package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1931.java
 * @author chlgpdus921
 * @date 2020. 8. 3.
 */
/* 회의실배정 */
public class BOJ1931 {
	static int n;
	static ArrayList<Meeting> me;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.valueOf(br.readLine());
		me = new ArrayList<Meeting>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.valueOf(st.nextToken());
			int finish = Integer.valueOf(st.nextToken());
			me.add(new Meeting(start, finish));
		}
		Collections.sort(me);
		// System.out.println()
		System.out.println(greedy());
	}

	public static int greedy() {
		int cnt = 1, cur = 0;
		int MAX = Integer.MIN_VALUE;

		cnt = 1;
		cur = me.get(0).finish;
		int j = 1;

		while (j < n) {
			if (me.get(j).start >= cur) {
				cur = me.get(j).finish;
				cnt++;
			}
			j++;
		}
		if (cnt > MAX)
			MAX = cnt;

		return MAX;
	}

}

class Meeting implements Comparable<Meeting> {
	int start, finish;

	Meeting(int start, int finish) {
		this.start = start;
		this.finish = finish;
	}

	@Override
	public int compareTo(Meeting m) {
		if (this.finish < m.finish) {
			return -1;
		} else if (this.finish == m.finish) {
			if (this.start < m.start)
				return -1;
			else
				return 1;
		}
		return 1;
	}
}
