package divide_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
/**
 * 
 * @FileName BOJ10815.java
 * @author chlgpdus921
 * @date 2020. 8. 7.
 */
/* 숫자 카드 - hashset 사용*/
public class BOJ10815 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			hs.add(Integer.valueOf(st.nextToken()));
		}

		int m = Integer.valueOf(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] data = new int[m];
		for (int i = 0; i < m; i++) {
			data[i] = Integer.valueOf(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			if (hs.contains(data[i]))
				sb.append("1 ");
			else {
				sb.append("0 ");
			}
		}

		System.out.println(sb);
	}
}
