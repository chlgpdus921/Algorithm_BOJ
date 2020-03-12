package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @FileName BOJ1699.java
 * @author chlgpdus921
 * @date 2020. 3. 11.
 */
/* 제곱수의 합 
 * 마지막 항이 1인경우, 4인경우, 9인경우... 
 * Math.sqrt(n) >> q, mod값을 이용해 푸는 방법도 있다.
 * */
public class BOJ1699 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] d = new int[n + 1];

		Arrays.fill(d, 99999);
		d[0] = 0;
		for (int i = 1; i <= n; i++) {
			int k = 1;
			for (int j = 1; j <= i; j = k * k) {
				if (d[i] > d[i - j] + 1) {
					d[i] = d[i - j] + 1;
				}
				k++;
			}
		}
		System.out.println(d[n]);

	}
}
