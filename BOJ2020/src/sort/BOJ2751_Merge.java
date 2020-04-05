package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ2751_Merge.java
 * @author chlgpdus921
 * @date 2020. 4. 4.
 */
public class BOJ2751_Merge {
	static int[] result;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		result = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		mergeSort(arr, 0, n - 1);

		for (int i = 0; i < n; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);

	}

	public static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			mergeSort(arr, start, (start + end) / 2);
			mergeSort(arr, (start + end) / 2 + 1, end);
			merge(arr, start, (start + end) / 2, end);
		}
	}

	public static void merge(int[] arr, int start, int middle, int end) {
		int ls = start;
		int rs = middle + 1;
		int j = start;
		while (ls <= middle && rs <= end) {
			if (arr[ls] <= arr[rs]) {
				result[j++] = arr[ls++];
			} else {
				result[j++] = arr[rs++];
			}
		}
		if (ls <= middle) {
			for (int i = ls; i <= middle; i++) {
				result[j++] = arr[i];
			}
		}
		if (rs <= end) {
			for (int i = rs; i <= end; i++) {
				result[j++] = arr[i];
			}
		}

		for (int i = start; i < j; i++) {
			arr[i] = result[i];
		}
	}
}
