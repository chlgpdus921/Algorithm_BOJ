package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1929.java
 * @author chlgpdus921
 * @date 2020. 3. 18.
 */
/*
 * 소수구하기 
 * 에라토스테네스의 체
 *  O(N loglogN)
 */
public class BOJ1929 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int m = Integer.valueOf(st.nextToken());
		int n = Integer.valueOf(st.nextToken());

		int[] p = new int[n + 1];// 소수 저장
		int pn = 0; // 소수의 갯수
		boolean[] c = new boolean[n + 1]; // 지워졌으면 true
	
		c[1] = true;
		c[2] = false;
		for (int i = 2; i <= n; i++) {
			if (c[i] == false) {
				p[pn++] = i;
			}
			for (int j = i + i; j <= n; j += i) {
				c[j] = true;
			}
		}
		
		for (int i = m; i <= n; i++) {
			if (c[i] == false) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}
}
