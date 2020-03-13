package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ9461.java
 * @author chlgpdus921
 * @date 2020. 3. 12.
 */
/* 파도반 수열
 * 1 1 1 2 2 3 4 5 7 9 
 * d[i] = d[i-1]+d[i-5] 로 풀 수도 있다.
 */
public class BOJ9461 {
	static long[] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.valueOf(br.readLine());
		d = new long[101];
		d[1] = 1;
		d[2] = 1;
		for (int i = 0; i < t; i++) {
			int n = Integer.valueOf(br.readLine());
			sb.append(getSequence(n) + "\n");
		}
		System.out.println(sb);
	}

	public static long getSequence(int n) {
		if (d[n] > 0)
			return d[n];

		for (int i = 3; i <= n; i++) {
			if (d[i] > 0)
				continue;
			else
				d[i] = d[i - 2] + d[i - 3];
		}
		return d[n];
	}
}
