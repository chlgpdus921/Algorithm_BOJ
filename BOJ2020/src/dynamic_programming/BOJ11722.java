package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ11722.java
 * @author chlgpdus921
 * @date 2020. 3. 10.
 */
/* 가장 긴 감소하는 부분 수열 */
public class BOJ11722 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] a = new int[n + 1];
		int[] d = new int[n + 1];
		
		int i = 1;
		while(st.hasMoreElements()) {
			a[i] = Integer.valueOf(st.nextToken());
			i++;
		}

		for (int j = 1; j <= n; j++) {
			d[j] = 1;
			for (int k = j - 1; k >= 1; k--) {
				if (a[j] < a[k]) {
					d[j] = Math.max(d[j], d[k] + 1);
				}
			}
		}
		Arrays.sort(d);
		System.out.println(d[n]);
	}
}
