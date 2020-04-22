package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @FileName BOJ1748.java
 * @author chlgpdus921
 * @date 2020. 4. 23.
 */
/* 수 이어쓰기 1 */
public class BOJ1748 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int cnt = 0;

		String tmp = String.valueOf(n);
		int num = Integer.valueOf(tmp.length());
		//n이 4자리 수면 3자리수 까지의 총 길이 계산
		for (int j = num - 1; j >= 1; j--) {
			int k = (int) Math.pow(10, j);
			int k2 = (int) Math.pow(10, j - 1);
			int sum = Math.abs(k - k2) * j;
			cnt += sum;
		}
		//n자리 계산
		int k = (int) Math.pow(10, num - 1);
		int value = Math.abs(n - k) + 1;
		cnt = cnt + (value * num);
		System.out.println(cnt);

	}
}
