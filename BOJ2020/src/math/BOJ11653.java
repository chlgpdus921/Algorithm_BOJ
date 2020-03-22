package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ11653.java
 * @author chlgpdus921
 * @date 2020. 3. 20.
 */
/* 소인수분해 */
public class BOJ11653 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());

		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				sb.append(i + "\n");
				n = n / i;
			}
		}
		if (n > 1) {
			sb.append(n + "\n");
		}
		System.out.println(sb);
	}
}
