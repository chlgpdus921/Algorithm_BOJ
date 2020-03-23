package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ2004.java
 * @author chlgpdus921
 * @date 2020. 3. 20.
 */
/*
 * 조합 0의 개수 
 * nCm 
 *    n! 
 * m!(n-m)!
 */
public class BOJ2004 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long n = Integer.valueOf(st.nextToken());
		long m = Integer.valueOf(st.nextToken());

		long cnt = 0, cnt2 = 0;
		for (long i = 2; i <= n; i *= 2) {
			cnt += n / i;
		}
		for (long i = 2; i <= m; i *= 2) {
			cnt -= m / i;
		}
		for (long i = 2; i <= (n - m); i *= 2) {
			cnt -= (n - m) / i;
		}

		for (long i = 5; i <= n; i *= 5) {
			cnt2 += n / i;
		}
		for (long i = 5; i <= m; i *= 5) {
			cnt2 -= m / i;
		}
		for (long i = 5; i <= (n - m); i *= 5) {
			cnt2 -= (n - m) / i;
		}
		long ans = Math.min(cnt, cnt2);
		System.out.println(ans);
	}

}
