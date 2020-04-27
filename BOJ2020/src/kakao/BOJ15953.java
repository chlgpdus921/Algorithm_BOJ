package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ15953.java
 * @author chlgpdus921
 * @date 2020. 4. 27.
 */
/* 
 * 카카오2018 예선
 * 1번 상금 헌터 
 */
public class BOJ15953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.valueOf(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			sb.append(solution2017(a) + solution2018(b) + "\n");
		}
		System.out.println(sb);
	}

	public static int solution2017(int i) {
		int rank = 0;

		if (i == 1)
			rank = 500;
		else if (i >= 2 && i <= 3)
			rank = 300;
		else if (i >= 4 && i <= 6)
			rank = 200;
		else if (i >= 7 && i <= 10)
			rank = 50;
		else if (i >= 11 && i <= 15)
			rank = 30;
		else if (i >= 16 && i <= 21)
			rank = 10;

		return rank * 10000;
	}

	public static int solution2018(int i) {
		int rank = 0;

		if (i == 1)
			rank = 512;
		else if (i >= 2 && i <= 3)
			rank = 256;
		else if (i >= 4 && i <= 7)
			rank = 128;
		else if (i >= 8 && i <= 15)
			rank = 64;
		else if (i >= 16 && i <= 31)
			rank = 32;

		return rank * 10000;
	}
}
