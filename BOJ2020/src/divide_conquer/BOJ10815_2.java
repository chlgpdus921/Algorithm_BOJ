package divide_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ10815.java
 * @author chlgpdus921
 * @date 2020. 8. 7.
 */
/* 숫자 카드 - 이분탐색법 */
public class BOJ10815_2 {
	static int[] check, data;

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

		int m = Integer.valueOf(br.readLine());
		st = new StringTokenizer(br.readLine());
		data = new int[m];
		for (int i = 0; i < m; i++) {
			data[i] = Integer.valueOf(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			if (twosearch(0, n - 1, data[i]))
				sb.append("1 ");
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
