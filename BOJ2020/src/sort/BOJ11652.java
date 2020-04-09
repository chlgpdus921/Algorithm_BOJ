package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @FileName BOJ11652.java
 * @author chlgpdus921
 * @date 2020. 4. 8.
 */
/* 카드 */
public class BOJ11652 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		long[] arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Long.valueOf(br.readLine());
		}
		Arrays.sort(arr);

		int cnt = 1, before_cnt = 0;
		long index = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] != arr[i - 1]) {
				if (cnt > before_cnt) {
					before_cnt = cnt;
					index = arr[i - 1];
				}
				cnt = 1;
			} else
				cnt++;

		}
		if (cnt > before_cnt)
			System.out.println(arr[n - 1]);
		else
			System.out.println(index);

	}
}
