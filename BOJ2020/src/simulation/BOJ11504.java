package simulation;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ11504.java
 * @author chlgpdus921
 * @date 2020. 11. 19.
 */
/* 돌려 돌려 돌림판! */
public class BOJ11504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.valueOf(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.valueOf(st.nextToken());
			int m = Integer.valueOf(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

			String tmp1 = "", tmp2 = "";
			for (int j = 0; j < m; j++) {
				tmp1 += st.nextToken();
				tmp2 += st2.nextToken();
			}

			int x = Integer.valueOf(tmp1);
			int y = Integer.valueOf(tmp2);

			st = new StringTokenizer(br.readLine(), " ");
			String s = "";
			while (st.hasMoreElements()) {
				s += st.nextToken();
			}

			s += s.substring(0, m - 1);

			int sum = 0;
			for (int q = 0; q < s.length() - m + 1; q++) {
				String cur = s.substring(q, q + m);
				
				int num = Integer.valueOf(cur);
				if (num >= x && num <= y)
					sum++;
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}

}
