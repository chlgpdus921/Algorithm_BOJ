package bruteforce_permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ10819.java
 * @author chlgpdus921
 * @date 2020. 5. 2.
 */
/* 차이를 최대로 */
public class BOJ10819 {
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		int k = 0;
		while (st.hasMoreElements()) {
			arr[k] = Integer.valueOf(st.nextToken());
			k++;
		}
		Arrays.sort(arr);
		findNext(arr);
		System.out.println(max);

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
		int sum = 0;
		for (int k = 0; k < arr.length - 1; k++) {
			sum += Math.abs(arr[k] - arr[k + 1]);
		}
		if (sum > max)
			max = sum;
		findNext(arr);
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
