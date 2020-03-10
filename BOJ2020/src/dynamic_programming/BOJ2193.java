package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @FileName BOJ2193.java
 * @author chlgpdus921
 * @date 2020. 3. 9.
 */
/* 이친수 d[i] = d[i-1] + d[i-2] 로도 해결 가능 */
public class BOJ2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		long[][] d = new long[n + 1][2];
		d[1][0] = 0;
		d[1][1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					// 끝자리가 0일 때
					d[i][j] = d[i - 1][0] + d[i - 1][1];
				} 
				else {
					// 끝자리가 1일때
					d[i][j] = d[i - 1][0];
				}
			}
		}
		System.out.println(d[n][0] + d[n][1]);

	}
}
