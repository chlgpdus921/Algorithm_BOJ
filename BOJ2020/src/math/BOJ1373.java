package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1373.java
 * @author chlgpdus921
 * @date 2020. 3. 13.
 */
/* 2진수 8진수
 * 2진수를 세자리씩 끊어서 8진수로 변환 
 * */
public class BOJ1373 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String n = br.readLine();
		double sum = 0;
		int cnt = 0;

		for (int i = n.length() - 1; i >= 0; i--) {
			if (cnt == 3) {
				sb.append((int) sum);
				cnt = 0;
				sum = 0;
				
			}
			int tmp = n.charAt(i) - 48;
			sum = sum + (Math.pow(2, cnt) * tmp);
			cnt++;
		}
		sb.append((int)sum);
		System.out.println(sb.reverse());
	}
}
