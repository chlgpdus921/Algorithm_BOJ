package bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1759.java
 * @author chlgpdus921
 * @date 2020. 5. 3.
 */
/* 암호만들기 
 * N과 M코드에 자음 모음 세는거 추가
 * */
public class BOJ1759 {
	static StringBuilder sb;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		String[] arr = new String[m + 1];
		arr[0] = "0";

		st = new StringTokenizer(br.readLine(), " ");

		int j = 1;
		while (st.hasMoreElements()) {
			arr[j] = st.nextToken();
			j++;
		}

		Arrays.sort(arr);

		int index;
		String[] result = new String[n + 1];
		for (int i = 1; i <= m; i++) {
			boolean[] check = new boolean[m + 1];
			check[i] = true;

			index = 1;
			result[1] = arr[i];

			repeat(index + 1, check, result, arr);
			check[i] = false;

		}
		System.out.println(sb);

	}

	public static void repeat(int index, boolean[] check, String[] result, String[] arr) {
		if (index > n) {
			String[] v = { "a", "e", "i", "o", "u" };
			int vowel = 0; // 0개찾기
			int consonant = 0; // 1개나 0개 찾기
			for (int p = 1; p < result.length; p++) {

				if (result[p].equals(v[0]) || result[p].equals(v[1]) || result[p].equals(v[2]) || result[p].equals(v[3])
						|| result[p].equals(v[4])) {
					vowel++;
				} else {
					consonant++;
				}
			}

			if (vowel == 0 || consonant <= 1)
				return;
			for (int p = 1; p < result.length; p++) {
				sb.append(result[p]);
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= m; i++) {
			if (result[index - 1].compareTo(arr[i]) > 0)
				continue;
			if (check[i] == false) {
				check[i] = true;
				result[index] = arr[i];
				repeat(index + 1, check, result, arr);
				check[i] = false;
			}
		}
	}
}
