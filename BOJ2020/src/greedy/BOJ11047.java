package greedy;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ11047.java
 * @author chlgpdus921
 * @date 2020. 8. 3.
 */
/* 동전 0 */
public class BOJ11047 {
	static int n, k;
	static int[] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());

		d = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = Integer.valueOf(br.readLine());
		}

		System.out.println(greedy());

	}

	public static int greedy() {
		int ptr = n - 1;
		int cnt = 0;
		while (ptr >= 0 && d[ptr] > k) {
			ptr--;
		}
		while (k != 0) {
			int cur = d[ptr];
			int q = k / cur;
			int mod = k % cur;
			k = mod;
			cnt += q;
			while (ptr >= 0 && d[ptr] > k)
				ptr--;
		}
		return cnt;
	}
}
