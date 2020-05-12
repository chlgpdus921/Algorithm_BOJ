package bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ14501.java
 * @author chlgpdus921
 * @date 2020. 5. 3.
 */
/* 퇴사 */
public class BOJ14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] t = new int[n + 1];
		int[] p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.valueOf(st.nextToken());
			p[i] = Integer.valueOf(st.nextToken());
		}

		int[] d = new int[n + 1];
		for (int i = n; i > 0; i--) {
			if (i + t[i] - 1 > n) {
				if (i + 1 <= n) // 최댓값0아닌 아닌 갱신
					d[i] = d[i + 1];
				continue;
			} // n+1 이상일 경우
			d[i] = p[i];
			int next = i + t[i]; // 3
			if (next > n) {
				if (i + 1 <= n)
					d[i] = Math.max(d[i], d[i + 1]);
				continue;
			}
			d[i] = d[i] + d[next];
			d[i] = Math.max(d[i], d[i + 1]);
		}
		Arrays.sort(d);
		System.out.println(d[n]);
	}
}
