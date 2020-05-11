package bruteforce_permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ6603.java
 * @author chlgpdus921
 * @date 2020. 5. 2.
 */
/* 로또 */
public class BOJ6603 {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.valueOf(st.nextToken());
			if (k == 0)
				break;
			int[] arr = new int[k + 1];
			int j = 1;
			while (st.hasMoreElements()) {
				arr[j] = Integer.valueOf(st.nextToken());
				j++;
			}

			int index;
			int[] result = new int[7];
			for (int i = 1; i <= k; i++) {
				if (arr[i - 1] != arr[i]) {
					boolean[] check = new boolean[k + 1];
					check[i] = true;

					index = 1;
					result[1] = arr[i];

					repeat(index + 1, check, result, arr);
					check[i] = false;

				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void repeat(int index, boolean[] check, int[] result, int[] arr) {
		if (index > 6) {
			for (int p = 1; p < result.length; p++) {
				sb.append(result[p] + " ");
			}
			sb.append("\n");
			return;
		}

		int beforeValue = -1;
		for (int i = 1; i < arr.length; i++) {
			if (result[index - 1] > arr[i])
				continue;
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
