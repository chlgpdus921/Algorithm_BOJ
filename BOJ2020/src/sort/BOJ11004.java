package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ11004.java
 * @author chlgpdus921
 * @date 2020. 4. 8.
 */
/* K번째 수 
 * Quick Sort 응용 */
public class BOJ11004 {
	static int k;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		int i = 0;
		while (st.hasMoreElements()) {
			arr[i] = Integer.valueOf(st.nextToken());
			i++;
		}
		quickSort(arr, 0, n - 1);
	
		System.out.println(arr[k - 1]);
	}

	public static int partition(int[] arr, int left, int right) {
		int middle = (left + right) / 2;
		swap(arr, left, middle);
		
		int pivot = arr[left];
		int l = left;
		int r = right;

		while (l < r) {
			while (arr[r] > pivot)
				r--;
			while (arr[l] <= pivot && l < r)
				l++;

		
			swap(arr, l, r);
		}
		arr[left] = arr[l];
		arr[l] = pivot;
		return l;
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int p = partition(arr, left, right);

		if (k == p + 1)
			return;
		else if (k > p + 1)
			quickSort(arr, p + 1, right);
		else
			quickSort(arr, left, p - 1);

	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
