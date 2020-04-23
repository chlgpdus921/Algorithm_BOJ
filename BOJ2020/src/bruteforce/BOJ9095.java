package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ9095.java
 * @author chlgpdus921
 * @date 2020. 4. 23.
 */
/* 1,2,3 더하기 */
public class BOJ9095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.valueOf(br.readLine());
		int[] d = new int[11];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		for (int j = 3; j <= 10; j++) {
			d[j] = d[j - 1] + d[j - 2] + d[j - 3];
		}
		for (int i = 0; i < t; i++) {
			int n = Integer.valueOf(br.readLine());
			sb.append(d[n] + "\n");
		}
		System.out.println(sb);
	}
}
