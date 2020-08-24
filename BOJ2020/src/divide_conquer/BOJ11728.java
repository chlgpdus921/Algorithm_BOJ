package divide_conquer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 
 * @FileName BOJ11728.java
 * @author chlgpdus921
 * @date 2020. 8. 24.
 */
/* 배열 합치기 */
public class BOJ11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int[] a = new int[n + m];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.valueOf(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = n; i < n + m; i++) {
			a[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(a);

		for (int i = 0; i < a.length; i++) {
			sb.append(a[i] + " ");
		}
		System.out.println(sb);
	}
}
