package bruteforce_permutation;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ14888.java
 * @author chlgpdus921
 * @date 2020. 6. 14.
 */
/* 연산자 끼워넣기 */
public class BOJ14888 {
	static int n;
	static int[] data, opeator;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.valueOf(br.readLine());

		data = new int[n];
		opeator = new int[4];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while (st.hasMoreElements()) {

			}

		}

	}

	public static void dfs(boolean[] check, int index) {
		if (index > n) {
			return;
		}

		for (int i = 0; i < n - 1; i++) {
			//+ - * / 

		}
	}
}
