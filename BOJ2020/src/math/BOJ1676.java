package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ1676.java
 * @author chlgpdus921
 * @date 2020. 3. 20.
 */
/*
 * 팩토리얼 0의 개수 
 * 5의 갯수만 찾으면 된다. (5,25,75...)
 */
public class BOJ1676 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.valueOf(br.readLine());
		long cnt = 0;

		for (int i = 5; i <= n; i *= 5) {
			cnt += n / i;
		}
		System.out.println(cnt);

	}
}
