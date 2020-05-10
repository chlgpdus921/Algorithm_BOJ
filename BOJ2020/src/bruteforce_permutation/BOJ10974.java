package bruteforce_permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ10974.java
 * @author chlgpdus921
 * @date 2020. 5. 2.
 */
/* 모든 순열 */
public class BOJ10974 {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
			sb.append(arr[i] + " ");
		}
		sb.append("\n");
		findNext(arr);
		System.out.println(sb);

	}
	public static void findNext(int[] arr) {
		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		} 
		if (i <= 0)
			return;
		int j = arr.length - 1;
		while (j > 0 && arr[j] <= arr[i - 1]) {
			j--;
		} // 3보다 큰거 찾기 그거랑 swap
		swap(arr, j, i - 1);
		j = arr.length - 1;
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		
		for (int k = 0; k < arr.length; k++) {
			sb.append(arr[k] + " ");
		}
		sb.append("\n");
		findNext(arr);
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
