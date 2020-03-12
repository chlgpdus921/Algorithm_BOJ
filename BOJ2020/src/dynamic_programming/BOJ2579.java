package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ2579.java
 * @author chlgpdus921
 * @date 2020. 3. 10.
 */
/* 계단오르기 
 * 1 1 0 0 1 1 > 3
 * 연속2칸 오르지 않도록 주의 
 * i번째일때, i번계단은 무조건 오른다는 가정
 * */
public class BOJ2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] a = new int[n + 1];
		int[] d = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.valueOf(br.readLine());
		}
		d[1] = a[1];
		if (n >= 2) {
			d[2] = d[1] + a[2];
		}
		for (int i = 3; i <= n; i++) {
			d[i] = Math.max(a[i] + d[i - 2], d[i - 3] + a[i - 1] + a[i]);
		}
		System.out.println(d[n]);
	}
}
