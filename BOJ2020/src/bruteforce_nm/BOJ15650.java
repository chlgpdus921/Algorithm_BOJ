package bruteforce_nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ15650.java
 * @author chlgpdus921
 * @date 2020. 4. 24.
 */
/*
 * N과 M (2) 중복 없이 !!!
 */
public class BOJ15650 {
	static StringBuilder sb;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		int index;
		int[] result = new int[m + 1];

		for (int i = 1; i <= n; i++) {
			boolean[] check = new boolean[n + 1];
			check[i] = true;
			index = 1;// 현재 자리수 m중에 1번 째만 결정되었다.
			result[1] = i; // 배열 0번째에 i가 오게됨

			repeat(index + 1, check, result); // 현재자리수, 배열에넣었는지 여부, 배열
		}
		System.out.println(sb);

	}

	public static void repeat(int index, boolean[] check, int[] result) {
		if (index > m) {
			// index가 m자리수를 넘었으면 한 줄 프린트
			for (int p = 1; p < result.length; p++) {
				sb.append(result[p] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (check[i] == false) { 
				//이전 숫자보다 클 경우
				if (result[index - 1] > i)
					continue;
				result[index] = i; 
				check[i] = true;
				repeat(++index, check, result); 
				index--; 
				check[i] = false;
			}
		}
	}
}
