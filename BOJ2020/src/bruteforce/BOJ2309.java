package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @FileName BOJ2309.java
 * @author chlgpdus921
 * @date 2020. 4. 15.
 */
/* 일곱 난쟁이 */
public class BOJ2309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.valueOf(br.readLine());
			sum += arr[i];
		}
		
		sum = sum - 100;
		Arrays.sort(arr);
		boolean check = false;
		int k = 0, j = 0;
		for (k = 0; k < 9; k++) {
			for (j = k+1; j < 9; j++) {
				if (sum == arr[k] + arr[j]) {
					check = true;
					break;
				}

			}
			if(check)
				break;
		}
		
		for (int i = 0; i < 9; i++) {
			if (i == k || i == j)
				continue;
			sb.append(arr[i] + "\n");
		}

		System.out.println(sb);
	}
}
