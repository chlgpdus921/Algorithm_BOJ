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
	static long[] data;
	static String[] operator;
	static long MaxValue = Long.MIN_VALUE;
	static long MinValue = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.valueOf(br.readLine());

		data = new long[n];
		operator = new String[n - 1];

		String[] tempValue = { "+", "-", "*", "/" };

		st = new StringTokenizer(br.readLine(), " ");
		int j = 0;
		while (st.hasMoreElements()) {
			data[j] = Integer.valueOf(st.nextToken());
			j++;
		}

		st = new StringTokenizer(br.readLine(), " ");
		j = 0;
		int c = 0;
		while (st.hasMoreElements()) {
			int index = Integer.valueOf(st.nextToken());
			for (int i = 0; i < index; i++) {
				operator[c] = tempValue[j];
				c++;
			}
			j++;

		}

		for (int i = 0; i < n - 1; i++) {
			boolean[] check = new boolean[n - 1];
			check[i] = true;
			long newValue = cal(data[0], 1, i);
			dfs(check, 2, newValue);
		}
		System.out.println(MaxValue);
		System.out.println(MinValue);
	}

	public static void dfs(boolean[] check, int index, long beforesum) {

		if (index > n - 1) {
			if (beforesum > MaxValue)
				MaxValue = beforesum;
			if (MinValue > beforesum)
				MinValue = beforesum;

			return;
		}

		for (int i = 0; i < n - 1; i++) {
			if (check[i] == false) {
				check[i] = true;
				long newValue = cal(beforesum, index, i);
				dfs(check, index + 1, newValue);
				check[i] = false;
			}

		}
	}

	public static long cal(long beforesum, int index, int i) {
		if (operator[i].equals("+")) {
			beforesum = (beforesum + data[index]);
		} else if (operator[i].equals("-")) {
			beforesum = (beforesum - data[index]);
		} else if (operator[i].equals("*")) {
			beforesum = (beforesum * data[index]);
		} else if (operator[i].equals("/")) {
			beforesum = (beforesum / data[index]);
		}
		return beforesum;
	}
}
