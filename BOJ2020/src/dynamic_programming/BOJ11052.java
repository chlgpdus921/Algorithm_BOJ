package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @FileName BOJ11052.java
 * @author chlgpdus921
 * @date 2020. 3. 7.
 */
/* 카드 구매하기 */
public class BOJ11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] p = new int[n + 1];
		int[] d = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int i = 1;
		while (st.hasMoreElements()) {
			p[i] = Integer.valueOf(st.nextToken());
			i++;
		}
		d[0] = 0;

		for (i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				d[i] = Math.max(d[i], d[i - j] + p[j]);
			}
		}
		System.out.println(d[n]);

	}
}
