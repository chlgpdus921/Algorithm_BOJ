package bruteforce_permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ10971.java
 * @author chlgpdus921
 * @date 2020. 5. 2.
 */
/* 외판원 순회2 */
public class BOJ10971 {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[][] weight = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int k = 0;
			while (st.hasMoreElements()) {
				weight[i][k] = Integer.valueOf(st.nextToken());
				k++;
			}
		}

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		Arrays.sort(arr);
		findNext(arr, weight);

		System.out.println(min);

	}

	public static void findNext(int[] arr, int[][] weight) {
		int sum = 0;
		for (int k = 0; k < arr.length - 1; k++) {
			int i = arr[k];
			int j = arr[k + 1];
			if (weight[i][j] != 0)
				sum += weight[i][j];
			else {
				sum = Integer.MAX_VALUE;
				break;
			}

			if (k == arr.length - 2) {
				if (weight[arr[k + 1]][arr[0]] != 0)
					sum += weight[arr[k + 1]][arr[0]];
				else {
					sum = Integer.MAX_VALUE;
					break;
				}
			}
		}
		if (min > sum)
			min = sum;

		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i <= 0)
			return;
		int j = arr.length - 1;
		while (j > 0 && arr[j] <= arr[i - 1]) {
			j--;
		}
		swap(arr, j, i - 1);
		j = arr.length - 1;
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		findNext(arr, weight);
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
