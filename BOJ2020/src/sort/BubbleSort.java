package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BubbleSort.java
 * @author chlgpdus921
 * @date 2020. 4. 2.
 */
public class BubbleSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			sb.append("PASS " + (i + 1) + " : ");
			for (int k = 0; k < n; k++) {
				sb.append(arr[k] + " ");
			}
			sb.append("\n");
		}
		for (int i = 0; i < n; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}
}
