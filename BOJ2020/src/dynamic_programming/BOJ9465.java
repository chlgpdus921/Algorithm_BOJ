package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ9465.java
 * @author chlgpdus921
 * @date 2020. 3. 9.
 */
/* 스티커 
 * 경우의 수 3개
 * 스티커 안붙히기, 1번에 붙히기, 2번에 붙히기*/
public class BOJ9465 {
	static int[][] sticker;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.valueOf(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.valueOf(br.readLine());
			int[][] d = new int[n + 1][3];
			sticker = new int[2][n + 1];
			
			//배열 입력 받기 
			for (int k = 0; k < 2; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int j = 0;
				while (st.hasMoreElements()) {
					sticker[k][j] = Integer.valueOf(st.nextToken());
					j++;
				}
			}
			d[1][0] = 0;
			d[1][1] = sticker[0][0];
			d[1][2] = sticker[1][0];
			for(int j = 2; j<=n; j++) {
				d[j][0] = Math.max(d[j-1][1], d[j-1][2]);
				d[j][1] = Math.max(d[j-1][0], d[j-1][2]) + sticker[0][j-1];
				d[j][2] = Math.max(d[j-1][0], d[j-1][1]) + sticker[1][j-1];
			
			}
			sb.append(Math.max(d[n][1], d[n][2]) +"\n");
		}
		System.out.println(sb);
	}
}
