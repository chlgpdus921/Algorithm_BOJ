package bruteforce_nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ15663.java
 * @author chlgpdus921
 * @date 2020. 4. 27.
 */
/*
 * N과 M (9) 
 * beforeValue 생성
 */
public class BOJ15663 {
	static StringBuilder sb;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		int[] arr = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		int j = 1;
		while (st.hasMoreElements()) {
			arr[j] = Integer.valueOf(st.nextToken());
			j++;
		}

		Arrays.sort(arr);

		int index;
		int[] result = new int[m + 1];
		for (int i = 1; i <= n; i++) {
			if (arr[i - 1] != arr[i]) {

				boolean[] check = new boolean[n + 1];
				check[i] = true;

				index = 1;
				result[1] = arr[i];

				repeat(index + 1, check, result, arr);
				check[i] = false;

			}
		}
		System.out.println(sb);

	}

	public static void repeat(int index, boolean[] check, int[] result, int[] arr) {
		if (index > m) {
			for (int p = 1; p < result.length; p++) {
				sb.append(result[p] + " ");
			}
			sb.append("\n");
			return;
		}

		int beforeValue = -1; // 이전꺼 기억하는 변수
		for (int i = 1; i <= n; i++) {
			if (check[i] == false && (i == 1 || beforeValue != arr[i])) {
				check[i] = true;
				beforeValue = arr[i];
				result[index] = arr[i];
				repeat(index + 1, check, result, arr);
				check[i] = false;
			}
		}
	}
}
