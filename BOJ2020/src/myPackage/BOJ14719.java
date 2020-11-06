package myPackage;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ14719.java
 * @author chlgpdus921
 * @date 2020. 10. 31.
 */
/* 빗물 */
public class BOJ14719 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int h = Integer.valueOf(st.nextToken());
		int w = Integer.valueOf(st.nextToken());
		boolean[][] block = new boolean[h][w];

		st = new StringTokenizer(br.readLine(), " ");
		int i = 0;
		while (st.hasMoreElements()) {
			int k = Integer.valueOf(st.nextToken());
			for (int j = h - k; j < h; j++) {
				block[j][i] = true; // 배열에 블럭 저장
			}
			i++;
		}

		int cnt = 0;
		for (int a = h - 1; a >= 0; a--) {// 맨 밑줄 부터 확인
			boolean start = false;
			for (int b = 0; b < w; b++) { // 가로 줄 체크
				boolean finish = false;

				if (block[a][b]) // start에 블럭이 있으면 true
					start = true;

				if (start && !block[a][b]) {// start에 블럭이 쌓여있고 빗물이 고이는지 확인하려면
					for (int c = b + 1; c < w; c++) {
						if (block[a][c]) { // 현위치의 뒷칸에 block 있는지 체크
							finish = true;
							break;
						}
					}

					if (finish) { // 있다면 cnt + 1
						block[a][b] = true;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
