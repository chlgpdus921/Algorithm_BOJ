package bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ14889.java
 * @author chlgpdus921
 * @date 2020. 5. 26.
 */
/*
 * 스타트와 링크 
 * 백트래킹 의미없는 경우를 제외하고,브루트포스를 진행하는 것.
 * 함수의 호출을 진행하는 중에 정답을 못구할 것 같다하면 중단
 */
public class BOJ14889 {
	static int[][] s;
	static boolean[] check;
	static int n;
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());

		s = new int[n + 1][n + 1];
		check = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			int j = 1;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreElements()) {
				s[i][j] = Integer.valueOf(st.nextToken());
				j++;
			}
		}

		DFS(0, 1);

		System.out.println(MIN);
	}

	public static void DFS(int cnt, int index) {
		if (cnt == n / 2) {

			int sumF = 0, sumS = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					if (check[i] && check[j])
						sumF += s[i][j];
					else if (!check[i] && !check[j])
						sumS += s[i][j];
				}

			}
			int result = Math.abs(sumF - sumS);
			if (MIN > result)
				MIN = result;
			return;
		}

		for (int i = index; i <= n; i++) {
			if (!check[i]) {
				check[i] = true;
				DFS(cnt + 1, i + 1);
				check[i] = false;
			}

		}
	}

}
