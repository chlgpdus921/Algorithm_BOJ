package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ11053.java
 * @author chlgpdus921
 * @date 2020. 3. 10.
 */
/* 가장 긴 증가하는 부분 수열 
 * 구한 d[1]~d[n] 중 최댓값 찾기 
 * O(N) *N = O(N제곱)
 * */
public class BOJ11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] a = new int[n + 1];
		int[] d = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int i = 1;
		while (st.hasMoreElements()) {
			a[i] = Integer.valueOf(st.nextToken());
			i++;
		}
		Arrays.fill(d, 1);
		for (int j = 2; j <= n; j++) {
			for (int k = j - 1; k >= 1; k--) {
				if (a[j] > a[k]) {
					d[j] = Math.max(d[j], d[k] + 1);
				}
			}
		}
		Arrays.sort(d);
		System.out.println(d[n]);
	}
}
