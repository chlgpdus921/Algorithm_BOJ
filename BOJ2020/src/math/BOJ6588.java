package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ6588.java
 * @author chlgpdus921
 * @date 2020. 3. 19.
 */
/*
 * 골드바흐의 추측 
 * 에라토스테네스의 체 응용
 */
public class BOJ6588 {
	static StringBuilder sb;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = 1000000;

		// 소수 분류
		boolean[] c = new boolean[1000001];
		c[1] = true;
		c[2] = false;
		for (int i = 2; i <= n; i++) {
			if (c[i] == false) {
			}
			for (int j = i + i; j <= n; j += i) {
				c[j] = true;
			}
		}

		int i = 0;
		while (n != 0) {
			n = Integer.valueOf(br.readLine());
			boolean check = false;

			for (i = 2; i <= n; i++) {
				if (c[i] == false && c[n - i] == false) {
					check = true;
					break;
				}
			}
			if (check)
				sb.append(n + " = " + i + " + " + (n - i) + "\n");
		}
		System.out.println(sb);
	}
}
