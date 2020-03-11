package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1912.java
 * @author chlgpdus921
 * @date 2020. 3. 10.
 */
/* 연속합 
 * 앞숫자와 비교하면서 연속된 숫자가 크면 더해나감
 * j-1번째가 연속합에 포함되는 경우 vs 새로운 연속합 시작하는 경우
 * */
public class BOJ1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] a = new int[n + 1];
		int[] d = new int[n];
		int i = 0;
		while (st.hasMoreElements()) {
			a[i] = Integer.valueOf(st.nextToken());
			i++;
		}
		d[0] = a[0];
		for (int j = 1; j < n; j++) {
			if(a[j]+d[j-1] >= a[j]) {
				d[j] = a[j]+d[j-1];
			}
			else {
				d[j] = a[j];
			}
		}
		Arrays.sort(d);
		System.out.println(d[n-1]);

	}
}
