package bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @FileName BOJ9095.java
 * @author chlgpdus921
 * @date 2020. 5. 3.
 */
/* 1,2,3 더하기 */
public class BOJ9095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.valueOf(br.readLine());
		int[] d = new int[11];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;

		for (int i = 0; i < t; i++) {
			int n = Integer.valueOf(br.readLine());
			sb.append(go(d, n) + "\n");
		}
		
		System.out.println(sb);
	}
	public static int go(int[] d, int i) {
		if(d[i] > 0)
			return d[i];
		
		return go(d, i-1) + go(d, i-2) + go(d, i-3);	
	}
}
