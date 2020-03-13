package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ2011_2.java
 * @author chlgpdus921
 * @date 2020. 3. 13.
 */
/* 암호코드 2번째 방법
 * 출처:백준 */
public class BOJ2011_2 {
	public static int mod = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = s.length();
		s = " " + s;
		int[] d = new int[n + 1];
		d[0] = 1;
		for (int i = 1; i <= n; i++) {
			int x = s.charAt(i) - '0';
			if (1 <= x && x <= 9) {
				d[i] += d[i - 1];
				d[i] %= mod;
			}
			if (i == 1) {
				continue;
			}
			if (s.charAt(i - 1) == '0') {
				continue;
			}
			x = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
			if (10 <= x && x <= 26) {
				d[i] += d[i - 2];
				d[i] %= mod;
			}
		}
		System.out.println(d[n]);
	}
}
