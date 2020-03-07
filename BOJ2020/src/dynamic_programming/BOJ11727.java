package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @FileName BOJ11727.java
 * @author chlgpdus921
 * @date 2020. 3. 7.
 */
/* 2*n ≈∏¿œ∏µ 2 */
public class BOJ11727 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] d = new int[n + 1];
		d[0] = 1;
		d[1] = 1;

		for (int i = 2; i <= n; i++) {
			d[i] = (d[i - 1] + 2 * d[i - 2]) % 10007;
		}
		System.out.println(d[n]);
	}
}
