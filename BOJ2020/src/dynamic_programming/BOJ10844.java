package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @FileName BOJ10844.java
 * @author chlgpdus921
 * @date 2020. 3. 9.
 */
/* 쉬운 계단 수 45656 인접한 모든 자리수 1차이 */
public class BOJ10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		long[][] d = new long[n + 1][11];
		Arrays.fill(d[1], 1);
		d[1][0] = 0;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					d[i][j] = d[i - 1][1] % 1000000000;
				} else if (j == 9) {
					d[i][j] = d[i - 1][8] % 1000000000;
				} else {
					d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % 1000000000;
				}

			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + d[n][i]) % 1000000000;
		}
		System.out.println(sum);

	}
}
