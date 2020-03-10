package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @FileName BOJ11057.java
 * @author chlgpdus921
 * @date 2020. 3. 9.
 */
/* 오르막 수 */
public class BOJ11057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		long[][] d = new long[n+1][11];
		
		Arrays.fill(d[1], 1);
		for(int i = 2; i<=n; i++) {
			for(int j = 0; j< 10; j++) {
				for(int k = 0; k<=j; k++) {
					d[i][j] = (d[i][j] +d[i-1][k]) % 10007;	
				}
			}
		}
		long sum = 0; 
		for(int i = 0; i<10; i++) {
			sum = (sum + d[n][i]) % 10007;
		}
		System.out.println(sum);
	}
}
