package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 
 * @FileName BOJ11054.java
 * @author chlgpdus921
 * @date 2020. 3. 10.
 */
/* 가장 긴 바이토닉 부분 수열 
 * 문제: 1 5 2 1 4 3 4 5 2 1
 * 답 : 1 2 3 4 5 2 1 > 7 
 */
public class BOJ11054 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] a = new int[n + 1];
		int[][] d = new int[n + 1][2];
		int i = 1;
		while (st.hasMoreElements()) {
			a[i] = Integer.valueOf(st.nextToken());
			i++;
		}
	
		//정방향  오른쪽으로 증가하는 부분 수열
		for (int j = 1; j <= n; j++) {
			d[j][0] = 1;
			for (int k = j - 1; k > 0; k--) {
				if (a[j] > a[k]) {
					d[j][0] = Math.max(d[j][0], d[k][0] + 1);
				}
			}
		}
		
		//역방향부터 , 감소하는 부분 수열
		int[] sum = new int[n+1];
		for (int j = n; j > 0; j--) {
			d[j][1] = 1;
			for (int k = j+1; k <= n; k++) {
				if (a[j] > a[k]) {
					d[j][1] = Math.max(d[j][1], d[k][1] + 1);
				}
			}
			sum[j] = d[j][0] + d[j][1];
		}
		Arrays.sort(sum);
		System.out.println(sum[n]-1);

	}
}
