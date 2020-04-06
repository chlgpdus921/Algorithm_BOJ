package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName InsertionSort.java
 * @author chlgpdus921
 * @date 2020. 4. 2.
 */
public class InsertionSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}

		for (int i = 1; i < n; i++) {
			// 현재 key 값과 key 위치 저장
			int key = arr[i];
			int keyIndex = i;
			for (int j = i - 1; j >= 0 && arr[j] > key; j--) {
				// 현재 key 값으로부터 왼쪽에 있는 모든 값들과 비교
				// 정렬이 안되어 있을 경우, arr[j]를 arr[j+1] (오른쪽)로 밀기
				arr[j + 1] = arr[j];
				keyIndex = j;

			}
			// 한 턴(pass)가 끝나면 최종 keyindex에 key값을 저장한다.
			arr[keyIndex] = key;

			sb.append("PASS " + i + " : ");
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
