package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @FileName BOJ9096.java
 * @author chlgpdus921
 * @date 2020. 3. 7.
 */
/* 1,2,3 더하기 */
public class BOJ9095 {
	static int[] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.valueOf(br.readLine());
		d = new int[12];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		for (int i = 0; i < t; i++) {
			int n = Integer.valueOf(br.readLine());
			sb.append(calcu(n) + "\n");
		}
		System.out.println(sb);
	}

	public static int calcu(int n) {
		if (d[n] > 0)
			return d[n];
		for (int j = 3; j <= n; j++) {
			if (d[j] > 0)
				continue;
			else {
				d[j] = d[j - 3] + d[j - 2] + d[j - 1];
			}
		}
		return d[n];
	}
}
