package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ14500.java
 * @author chlgpdus921
 * @date 2020. 4. 18.
 */
/*
 * 테트로미노 모든 경우의 수 다 세야하는 bruteforce
 */
public class BOJ14500 {
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		int[][] block = new int[n][m];
		for (int i = 0; i < n; i++) {
			int j = 0;
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreElements()) {
				block[i][j] = Integer.valueOf(st.nextToken());
				j++;
			}
		}
		int value = func(block);
		System.out.println(value);
	}

	public static int func(int[][] block) {
		int max = Integer.MIN_VALUE;
		int tmp;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j + 3 < m) {
					// 가로막대
					tmp = block[i][j] + block[i][j + 1] + block[i][j + 2] + block[i][j + 3];
					if (tmp > max)
						max = tmp;
				}
				if (i + 3 < n) {
					// 세로막대
					tmp = block[i][j] + block[i + 1][j] + block[i + 2][j] + block[i + 3][j];
					if (tmp > max)
						max = tmp;
				}
				if (i + 1 < n && j + 1 < m) {
					// 정사각형
					tmp = block[i][j] + block[i][j + 1] + block[i + 1][j] + block[i + 1][j + 1];
					if (tmp > max)
						max = tmp;
				}
				if (i + 1 < n && j + 2 < m) {
					// 왼쪽 튀어나온 가로
					tmp = block[i][j + 1] + block[i][j + 2] + block[i + 1][j] + block[i + 1][j + 1];
					if (tmp > max)
						max = tmp;
				}
				if (i + 1 < n && j + 2 < m) {
					// 오른쪽 튀어나온 가로
					tmp = block[i][j] + block[i][j + 1] + block[i + 1][j + 1] + block[i + 1][j + 2];
					if (tmp > max)
						max = tmp;
				}
				if (i + 2 < n && j + 1 < m) {
					// 왼쪽 튀어나온 세로
					tmp = block[i][j] + block[i + 1][j] + block[i + 1][j + 1] + block[i + 2][j + 1];
					if (tmp > max)
						max = tmp;
				}
				if (i + 2 < n && j + 1 < m) {
					// 오른쪽 튀어나온 세로
					tmp = block[i + 1][j] + block[i + 2][j] + block[i + 1][j + 1] + block[i][j + 1];
					if (tmp > max)
						max = tmp;
				}
				if (i + 2 < n && j + 1 < m) {
					// 세로3개에서 꼭대기 위
					tmp = block[i][j] + block[i + 1][j] + block[i + 2][j] + block[i][j + 1];
					if (tmp > max)
						max = tmp;
				}
				if (i + 2 < n && j + 1 < m) {
					// 세로3개에서 꼭대기 중간
					tmp = block[i][j] + block[i + 1][j] + block[i + 2][j] + block[i + 1][j + 1];
					if (tmp > max)
						max = tmp;
				}
				if (i + 2 < n && j + 1 < m) {
					// 세로3개에서 꼭대기 아래
					tmp = block[i][j] + block[i + 1][j] + block[i + 2][j] + block[i + 2][j + 1];
					if (tmp > max)
						max = tmp;
				}
				if (i + 2 < n && j + 1 < m) {
					// 세로3개에서 왼쪽 꼭대기 위
					tmp = block[i][j] + block[i][j + 1] + block[i + 1][j + 1] + block[i + 2][j + 1];
					if (tmp > max)
						max = tmp;
				}
				if (i + 2 < n && j + 1 < m) {
					// 세로3개에서 왼쪽 꼭대기 중간
					tmp = block[i + 1][j] + block[i][j + 1] + block[i + 1][j + 1] + block[i + 2][j + 1];
					if (tmp > max)
						max = tmp;
				}
				if (i + 2 < n && j + 1 < m) {
					// 세로3개에서 왼쪽 꼭대기 아래
					tmp = block[i + 2][j] + block[i][j + 1] + block[i + 1][j + 1] + block[i + 2][j + 1];
					if (tmp > max)
						max = tmp;
				}
				if (i + 1 < n && j + 2 < m) {
					// 가로 3개
					tmp = block[i][j] + block[i + 1][j] + block[i + 1][j + 1] + block[i + 1][j + 2];
					if (tmp > max)
						max = tmp;
				}
				if (i + 1 < n && j + 2 < m) {
					// 가로 3개
					tmp = block[i][j + 1] + block[i + 1][j] + block[i + 1][j + 1] + block[i + 1][j + 2];
					if (tmp > max)
						max = tmp;
				}
				if (i + 1 < n && j + 2 < m) {
					// 가로 3개
					tmp = block[i][j + 2] + block[i + 1][j] + block[i + 1][j + 1] + block[i + 1][j + 2];
					if (tmp > max)
						max = tmp;
				}
				if (i + 1 < n && j + 2 < m) {
					// 가로 3개
					tmp = block[i + 1][j] + block[i][j] + block[i][j + 1] + block[i][j + 2];
					if (tmp > max)
						max = tmp;
				}
				if (i + 1 < n && j + 2 < m) {
					// 가로 3개
					tmp = block[i + 1][j + 1] + block[i][j] + block[i][j + 1] + block[i][j + 2];
					if (tmp > max)
						max = tmp;
				}
				if (i + 1 < n && j + 2 < m) {
					// 가로 3개
					tmp = block[i + 1][j + 2] + block[i][j] + block[i][j + 1] + block[i][j + 2];
					if (tmp > max)
						max = tmp;
				}
			}
		}
		return max;
	}
}
