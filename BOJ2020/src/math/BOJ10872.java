package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ10872.java
 * @author chlgpdus921
 * @date 2020. 3. 20.
 */
/* 팩토리얼 */
public class BOJ10872 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		System.out.println(result);
	}

}
