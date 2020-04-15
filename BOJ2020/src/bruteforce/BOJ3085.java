package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ3085.java
 * @author chlgpdus921
 * @date 2020. 4. 15.
 */
/* 사탕 게임 */
public class BOJ3085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		String[][] candy = new String[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				candy[i][j] = s.charAt(j) + "";
			}
		}

		int max = 0;
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				if (b < n - 1) {
					swap(candy, a, b);
					int result = result(candy);
					if (result > max)
						max = result;
					swap(candy, a, b);
				}
				if (a < n - 1) {
					swap2(candy, a, b);
					int result = result(candy);
					if (result > max)
						max = result;
					swap2(candy, a, b);
				}
			}
		}
		System.out.println(max);
	}

	public static int result(String[][] candy) {
		int n = candy.length;
		int result = 1;
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if (candy[i][j].equals(candy[i][j + 1])) {
					cnt++;
				} else {
					cnt = 1;
				}
				if (cnt > result)
					result = cnt;
			}

			cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if (candy[j][i].equals(candy[j + 1][i])) {
					cnt++;
				} else {
					cnt = 1;
				}
				if (cnt > result)
					result = cnt;
			}

		}
		return result;
	}

	public static void swap(String[][] candy, int i, int j) {
		if (!(candy[i][j].equals(candy[i][j + 1]))) {
			String temp = candy[i][j];
			candy[i][j] = candy[i][j + 1];
			candy[i][j + 1] = temp;
		}
	}

	public static void swap2(String[][] candy, int i, int j) {
		if (!(candy[i][j].equals(candy[i + 1][j]))) {
			String temp = candy[i][j];
			candy[i][j] = candy[i + 1][j];
			candy[i + 1][j] = temp;
		}
	}
}
