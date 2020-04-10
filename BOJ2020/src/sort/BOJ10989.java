package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ10989.java
 * @author chlgpdus921
 * @date 2020. 4. 8.
 */
/* 수 정렬하기 3 */
/* 입력되는 수의 범위가 지정되어 있으므로 이를 그냥 cnt 해준다. */
public class BOJ10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[10001];
		for (int i = 0; i < n; i++) {
			int num = Integer.valueOf(br.readLine());
			arr[num]++;

		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > 0) {
				int j = 1;
				while (j <= arr[i]) {
					sb.append(i + "\n");
					j++;
				}
			}
		}
		
		System.out.println(sb);
	}
}
