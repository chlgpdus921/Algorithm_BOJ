package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ2225.java
 * @author chlgpdus921
 * @date 2020. 3. 12.
 */
/* 합분해 
 * 가로 K, 세로 N
 * 1 2 3 4 5 
 * 1 3 6 10 15
 * 1 4 10 20 35
 * 1 5 15 35 70
 * d[i-1][1] ~ d[i-1][k]까지 더하는 방법
 * 일차원 배열로 푸는 방법 존재.   
 * */
public class BOJ2225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		long[][] d = new long[n + 1][k + 1];

		d[1][1] = 1;
		if (n == 1) {
			for (int j = 1; j <= k; j++) {
				d[1][j] = j;
			}
		}
		for (int i = 2; i <= n; i++) {
			d[i][1] = 1;
			for (int j = 2; j <= k; j++) {
				d[1][j] = j;
				d[i][j] = (d[i][j - 1] + d[i - 1][j]) % 1000000000;
			}
		}
		System.out.println(d[n][k]);

	}
}
