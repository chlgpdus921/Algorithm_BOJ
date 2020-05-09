package bruteforce_permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ10973.java
 * @author chlgpdus921
 * @date 2020. 5. 2.
 */
/* 이전 순열 */
public class BOJ10973 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		int k = 0;
		while (st.hasMoreElements()) {
			arr[k] = Integer.valueOf(st.nextToken());
			k++;
		}
		boolean result = findNext(arr);
		if (result) {
			for (int i = 0; i < n; i++) {
				sb.append(arr[i] + " ");
			}
		} else
			sb.append("-1");

		System.out.println(sb);
	}

	// 예시: 1 3 4 2
	// 정답: 1 3 2 4
	public static boolean findNext(int[] arr) {
		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] <= arr[i]) { // 부등호 바꿔줌
			i--;
		} // 가장 긴 증가수열
		if (i <= 0)
			return false;
		int j = arr.length - 1;
		while (j > 0 && arr[j] >= arr[i - 1]) { // 부등호 바꿔줌
			j--;
		}
		swap(arr, j, i - 1);
		j = arr.length - 1;
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		return true;
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
