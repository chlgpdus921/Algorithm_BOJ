package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1080.java
 * @author chlgpdus921
 * @date 2020. 8. 16.
 */
/* 행렬 
 * B랑 다르다면 부분행렬 3*3이 되는지 확인하고 된다면 뒤집음
 * 그 후 최종적으로 같은지 확인했다*/
public class BOJ1080 {
	static int n, m;
	static boolean[][] A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		A = new boolean[n][m];
		B = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				A[i][j] = temp[j].equals("1") ? true : false;
			}
		}
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				B[i][j] = temp[j].equals("1") ? true : false;
			}
		}

		int[][] bitmask = { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
		int row = 0, col = 1;
		boolean result = true;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] != B[i][j]) {

					for (int[] bit : bitmask) {
						int nextX = i + bit[row];
						int nextY = j + bit[col];

						if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
							result = false;
							break;
						}
					}
					if (result) {
						for (int[] bit : bitmask) {
							int nextX = i + bit[row];
							int nextY = j + bit[col];

							A[nextX][nextY] = !A[nextX][nextY];
						}
					}
					cnt++;
				}
			}
			result = true;
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == B[i][j]) {
					sum++;
				}

			}
		}
		if (sum == n * m)
			System.out.println(cnt);
		else
			System.out.println("-1");
	}

}
