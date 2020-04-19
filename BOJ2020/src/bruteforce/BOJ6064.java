package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ6064.java
 * @author chlgpdus921
 * @date 2020. 4. 19.
 */
/* 카잉 달력 */
public class BOJ6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.valueOf(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.valueOf(st.nextToken());
			int n = Integer.valueOf(st.nextToken());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());

			int j = 0, result;
			while (true) {
				// x 값만 보고 년도 예측 후 n과 나눈 나머지를 구함으로써 y과 같은지 확인
				result = m * j + x;
				int value = result % n;

				// 동시에 가질 수 있는 최대값도 계산
				int maxValue = m * j + m;
				int tmp = maxValue % n;

				if (value == 0)
					value = n;
				if (tmp == 0)
					tmp = n;
				if (value == y) {
					// y와 같으면 정답 존재
					break;
				}
				if (tmp == n) {
					// 가질 수 있는 최댓값에 도달했으면 유효하지 않은 값
					result = -1;
					break;
				}
				j++;
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}
