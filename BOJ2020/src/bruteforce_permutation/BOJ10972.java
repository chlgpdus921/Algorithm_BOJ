package bruteforce_permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ10972.java
 * @author chlgpdus921
 * @date 2020. 5. 2.
 */
/* 다음 순열 */
public class BOJ10972 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		int k = 0;
		while (st.hasMoreElements()) {
			arr[k] = Integer.valueOf(st.nextToken());
			k++;
		}
		boolean result = findNext(arr);
		if (result) {
			for (int i = 0; i < n; i++) {
				sb.append(arr[i] + " ");
			}
		} else
			sb.append("-1");

		System.out.println(sb);
	}

	// 예시: 1 3 4 2
	// 정답: 1 4 2 3

	// i를 맨뒤숫자(2)부터 시작하여 i-1 보다 작은거 확인 . 최종 i-1: 3(index2)
	// j를 맨뒤숫자(2)부터 시작하여 i-1(4)보다 작은지 확인 최종j는 4(index2)
	public static boolean findNext(int[] arr) {
		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		} // 가장 긴 감소수열 찾기 //i = 4
		if (i <= 0)
			return false;
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
		return true;
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
