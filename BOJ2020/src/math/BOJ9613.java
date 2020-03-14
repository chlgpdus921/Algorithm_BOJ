package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ9613.java
 * @author chlgpdus921
 * @date 2020. 3. 13.
 */
/* GCD 합 */
public class BOJ9613 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.valueOf(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.valueOf(st.nextToken());
			int[] data = new int[n + 1];
			int j = 0;
			while (st.hasMoreElements()) {
				data[j] = Integer.valueOf(st.nextToken());
				j++;
			}

			long sum = 0;
			for (int k = 0; k < j; k++) {
				for (int p = k + 1; p < j; p++) {
					sum += gcd(data[k], data[p]);
				}
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
}
