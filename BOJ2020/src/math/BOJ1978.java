package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1978.java
 * @author chlgpdus921
 * @date 2020. 3. 18.
 */
/* 소수 찾기 */
public class BOJ1978 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int i = 0, sum = 0;
		int[] data = new int[n];
		while (st.hasMoreElements()) {
			data[i] = Integer.valueOf(st.nextToken());
			boolean anw = prime(data[i]);
			if (anw)
				sum++;
			i++;
		}
		System.out.println(sum);
	}

	public static boolean prime(int n) {
		if (n < 2)
			return false;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}
}
