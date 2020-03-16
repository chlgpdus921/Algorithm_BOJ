package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ11005.java
 * @author chlgpdus921
 * @date 2020. 3. 13.
 */
/*
 * 진법 변환2 n이 주어졌을때 b진법으로 출력
 */
public class BOJ11005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		long n = Long.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());

		while (n != 0) {
			long temp = n % b;
			if (temp > 9) {
				temp += 55;
				sb.append((char) temp);
			} else
				sb.append(temp);
			n = n / b;
			
		}
		System.out.println(sb.reverse());
	}
}
