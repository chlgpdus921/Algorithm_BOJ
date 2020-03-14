package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ10430.java
 * @author chlgpdus921
 * @date 2020. 3. 13.
 */
/* 나머지 */
public class BOJ10430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int a = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());
		int c = Integer.valueOf(st.nextToken());

		sb.append((a + b) % c + "\n");
		sb.append((a % c + b % c) % c + "\n");
		sb.append((a * b) % c + "\n");
		sb.append((a % c * b % c) % c + "\n");

		System.out.println(sb);

	}
}
