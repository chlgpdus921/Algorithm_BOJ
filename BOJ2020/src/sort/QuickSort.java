package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ2751.java
 * @author chlgpdus921
 * @date 2020. 4. 2.
 */
/* 수 정렬하기 2 */
public class QuickSort {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int j = 0;
		while (st.hasMoreElements()) {
			arr[j] = Integer.valueOf(st.nextToken());
			j++;
		}
		quickSort(arr, 0, n - 1);

		for (int i = 0; i < n; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);

	}

	public static void quickSort(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		int l = left;
		int r = right;
		System.out.println("pivot : " + pivot);
		while (l <= r) {
			while (arr[l] < pivot)
				l++;

			while (arr[r] > pivot)
				r--;

			if (l <= r) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				l++;
				r--;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("나온 값" + l + "  " + r);
		if (left < l - 1)
			quickSort(arr, left, l - 1);

		if (l < right)
			quickSort(arr, l, right);
	}
}
