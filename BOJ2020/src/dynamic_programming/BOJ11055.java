package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 
 * @FileName BOJ11055.java
 * @author chlgpdus921
 * @date 2020. 3. 10.
 */
/* 가장 큰 증가 부분 수열 
 * d[j] = a[j]가 포인트 !
 * 반례: 7 , 3 2 1 2 3 4 5
 * 첫값보다 작은 경우 배열이 계속 0으로 초기화되어있는 것이 문제였다. 
 */
public class BOJ11055 {
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

		for (int j = 1; j <= n; j++) {
			d[j] = a[j];
			for (int k = j - 1; k >= 1; k--) {
				if (a[j] > a[k]) {
					d[j] = Math.max(d[j], d[k] + a[j]);
				}
			}
		}
		Arrays.sort(d);
		System.out.println(d[n]);
	}
}
