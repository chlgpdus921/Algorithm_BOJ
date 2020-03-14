package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ2609.java
 * @author chlgpdus921
 * @date 2020. 3. 13.
 */
/* 최대공약수와 최소공배수 
 * 최대공약수(GCD)는 유클리드 호제법으로 풀 수 있다.
 * 최소공배수(LCM)는 GL= A*B*/
public class BOJ2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int a = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());
		int g = gcd(a, b);
		int lcm = ((a / g) * (b / g)) * g;
		sb.append(g + "\n");
		sb.append(lcm + "\n");
		System.out.println(sb);
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else {
			return gcd(b, a % b);
		}
	}
}
