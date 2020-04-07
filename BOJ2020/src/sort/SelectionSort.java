package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName SelectionSort.java
 * @author chlgpdus921
 * @date 2020. 3. 31.
 */
/* n을 입력받고 n만큼 정렬하라 */
public class SelectionSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}

		int min = arr[0];
		for (int i = 0; i < n; i++) {
			int index = i;
			for (int j = i; j < n - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					min = arr[j + 1];
					index = j + 1;
				}
			}
			sb.append("SWAP " + arr[i] + "  <-->  " + arr[index] + "\n");
			int temp = arr[i];
			arr[i] = min;
			arr[index] = temp;
		}

		for (int i = 0; i < n; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}

}
