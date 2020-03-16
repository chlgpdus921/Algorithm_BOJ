package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ2745.java
 * @author chlgpdus921
 * @date 2020. 3. 13.
 */
/*
 * 진법 변환 
 * B진법 수 N이 주어졌을 때 10진법으로 바꿔 출력
 * 앞에서 부터 곱하는게 더 편하다. 
 */
public class BOJ2745 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String n = st.nextToken();
		int b = Integer.valueOf(st.nextToken());
		
		double sum = 0;
		int cnt = 0;
		for (int i = n.length()-1; i>=0; i--) {
			long tmp = n.charAt(i);
			if (tmp >= 'A')
				tmp -= 55;
			else 
				tmp -=48;
			sum = sum + (Math.pow(b, cnt) * tmp);
			cnt++;
		}
		
		System.out.println((long) sum);
	}
}
