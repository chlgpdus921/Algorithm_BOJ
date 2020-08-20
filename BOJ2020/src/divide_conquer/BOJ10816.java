package divide_conquer;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ10816.java
 * @author chlgpdus921
 * @date 2020. 8. 16.
 */
/* 숫자 카드 2 */
public class BOJ10816 {
	static int[] check, data;
	static HashMap<Integer, Integer> hs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		check = new int[n];
		for (int i = 0; i < n; i++) {
			check[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(check);

		hs = new HashMap<Integer, Integer>();
		int cur = check[0];
		hs.put(cur, 1);
		for (int i = 1; i < n; i++) {
			if (check[i] == cur) {
				hs.replace(cur, hs.get(cur) + 1);
			} else {
				cur = check[i];
				hs.put(cur, 1);
			}
		}
		int m = Integer.valueOf(br.readLine());
		st = new StringTokenizer(br.readLine());
		data = new int[m];
		for (int i = 0; i < m; i++) {
			data[i] = Integer.valueOf(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			if (twosearch(0, n - 1, data[i]))
				sb.append(hs.get(data[i]) + " ");
			else
				sb.append("0 ");
		}

		System.out.println(sb);
	}

	public static boolean twosearch(int left, int right, int searchNum) {
		int mid = (left + right) / 2;
		boolean result;

		if (left > right)
			return false;
		else {
			if (check[mid] > searchNum) {
				result = twosearch(left, mid - 1, searchNum);
			} else if (check[mid] < searchNum) {
				result = twosearch(mid + 1, right, searchNum);
			} else {
				return true;

			}

		}
		return result;
	}
}