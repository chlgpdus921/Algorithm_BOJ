package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1934.java
 * @author chlgpdus921
 * @date 2020. 3. 13.
 */
/* 최소공배수 */
public class BOJ1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.valueOf(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int g = gcd(a, b);

			int lcm = ((a / g) * (b / g)) * g;
			sb.append(lcm + "\n");
		}
		System.out.println(sb);
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else {
			return gcd(b, a % b);
		}
	}
}
