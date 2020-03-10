package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ2156.java
 * @author chlgpdus921
 * @date 2020. 3. 9.
 */
/* 포두주 시식  
 * 3가지 경우의 수 
 * 선택, 앞선택x 현위치선택, 앞선택o 현위치선택
 * */
public class BOJ2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] grape = new int[n + 1];
		int[][] d = new int[n + 1][3];

		for (int i = 1; i <= n; i++) {
			grape[i] = Integer.valueOf(br.readLine());
		}
		
		d[1][0] = 0;
		d[1][1] = grape[1];
		d[1][2] = grape[1];
		
		for (int i = 2; i <= n; i++) {
			d[i][0] = Math.max(Math.max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
			d[i][1] = d[i - 1][0] + grape[i];
			d[i][2] = d[i - 1][1] + grape[i];
		}
		System.out.println(Math.max(Math.max(d[n][0], d[n][1]), d[n][2]));
	}
}
