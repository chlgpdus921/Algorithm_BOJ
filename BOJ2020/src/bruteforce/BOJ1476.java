package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * @FileName BOJ1476.java
 * @author chlgpdus921
 * @date 2020. 4. 17.
 */
/* 날짜 계산 */
public class BOJ1476 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int e = Integer.valueOf(st.nextToken());
		int s = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int es = 0, ss = 0, ms = 0;
		int cnt = 0;
		for (int i = 1; i <= 7980; i++) {
			cnt++;
			if (++es > 15)
				es = 1;
			if (++ss > 28)
				ss = 1;
			if (++ms > 19)
				ms = 1;
			if (e == es && s == ss && m == ms) {
				break;
			}
		}
		System.out.println(cnt);
	}
}
