package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @FileName BOJ1377.java
 * @author chlgpdus921
 * @date 2020. 4. 8.
 */
/* 버블 소트 
/* 몇단계에서  정렬이 완료되는지 찾기 
 */
class Original implements Comparable<Original> {
	public int index, value;

	Original(int index, int value) {
		this.index = index;
		this.value = value;
	}

	public int compareTo(Original o) {
		if (this.value < o.value)
			return -1;
		else if (this.value == o.value) {
			return 0;
		} else
			return 1;
	}

}

public class BOJ1377 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());

		Original[] arr = new Original[n];
		for (int i = 0; i < n; i++) {
			int num = Integer.valueOf(br.readLine());
			arr[i] = new Original(i, num);
		}
		Arrays.sort(arr);
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i].index - i > max)
				max = arr[i].index - i;
		}
		System.out.println(max + 1);

	}

}
