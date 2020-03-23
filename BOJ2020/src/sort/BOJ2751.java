package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @FileName BOJ2751.java
 * @author chlgpdus921
 * @date 2020. 3. 20.
 */
/* 수 정렬하기 2 */
public class BOJ2751 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());
		int[] data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = Integer.valueOf(br.readLine());
		}
		Arrays.sort(data);
		for (int i = 0; i < n; i++) {
			sb.append(data[i] + "\n");
		}
		System.out.println(sb);
	}
}
