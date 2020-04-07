package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * @FileName MergeSort.java
 * @author chlgpdus921
 * @date 2020. 4. 4.
 */
public class MergeSort {
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		result = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		int j = 0;
		while (st.hasMoreElements()) {
			arr[j] = Integer.valueOf(st.nextToken());
			j++;
		}
		mergeSort(arr, 0, n - 1);
		
		for (int i = 0; i < n; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}

	public static void mergeSort(int[] arr, int start, int end) {
		//분할하는 function. 
		// start< end 라는 뜻은 길이가 1보다 크다는 뜻
		// start == end일 때 길이가 1이다.
		if (start < end) {
			mergeSort(arr, start, (start + end) / 2);
			mergeSort(arr, (start + end) / 2 + 1, end);
			merge(arr, start, (start + end) / 2, end);
		}
	}

	public static void merge(int[] arr, int start, int middle, int end) {
		int ls = start;
		int rs = middle + 1;
		int j = start;
		
		//왼쪽 배열의 start가 middle일때까지
		//오른쪽 배열의 start(middle+1)이 배열의 끝일때까지 (end)
		while (ls <= middle && rs <= end) {
			//왼쪽 오른쪽을 비교하여 result에 순서대로 넣는다. 
			if (arr[ls] <= arr[rs]) {
				result[j++] = arr[ls++];
			} else {
				result[j++] = arr[rs++];
			}
		}
		//while문이 끝났다는 뜻은 두 배열중 하나의 포인터가 끝났다는 뜻
		//남아 있는 배열의 원소들을 result에 넣어준다. 
		if (ls <= middle) {
			for (int i = ls; i <= middle; i++) {
				result[j++] = arr[i];
			}
		}
		if (rs <= end) {
			for (int i = rs; i <= end; i++) {
				result[j++] = arr[i];
			}
		}
		//result값을 기존 배열에 복사
		for (int i = start; i < j; i++) {
			arr[i] = result[i];
		}
	}

}
