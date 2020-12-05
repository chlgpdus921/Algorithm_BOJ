package simulation;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ14647.java
 * @author chlgpdus921
 * @date 2020. 12. 4.
 */
/* 준오는 조류혐오야!! */
public class BOJ14647 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());

		int[][] arr = new int[n][m];
		int max = Integer.MIN_VALUE;
		int cnt = 0;
		int Total = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				String s = st.nextToken();
				arr[i][j] = Integer.valueOf(s);

				for (int k = 0; k < s.length(); k++) {
					if (s.charAt(k) == '9') {
						cnt++;
						Total++;
					}
				}
			}
			if (cnt > max) {
				max = cnt;
			}
			cnt = 0;
		}

		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				String s = String.valueOf(arr[i][j]);
				for (int k = 0; k < s.length(); k++) {
					if (s.charAt(k) == '9') {
						cnt++;
					}
				}
			}
			if (cnt > max)
				max = cnt;
			cnt = 0;
		}
		System.out.println(Total - max);
	}

}
