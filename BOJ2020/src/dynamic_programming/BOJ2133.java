package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ2133.java
 * @author chlgpdus921
 * @date 2020. 3. 11.
 */
/*
 * 타일채우기 
 * d[2]일 때 3가지 모양
 * d[4]일 때 3*3 + 새로운모양2개추가 
 * d[6]일 때 d[4]*3 + d[2]*2 + 새로운모양2개추가 
 * 반복됨
 */
public class BOJ2133 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());

		int[] d = new int[n + 1];
		d[0] = 1;

		for (int i = 2; i <= n; i = i + 2) {
			d[i] = 3 * d[i - 2];
			for (int j = i - 4; j >= 0; j = j - 2) {
				d[i] += 2 * d[j];
			}
		}
		System.out.println(d[n]);

	}
}
