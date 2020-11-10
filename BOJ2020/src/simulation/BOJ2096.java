package simulation;

import java.io.*;
import java.util.*;
/**
 * 
 * @FileName BOJ2096.java
 * @author chlgpdus921
 * @date 2020. 11. 8.
 */
/* 내려가기 */
public class BOJ2096 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());

		int minf = 0, minm = 0, minl = 0;
		int maxf = 0, maxm = 0, maxl = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int first = Integer.valueOf(st.nextToken());
			int middle = Integer.valueOf(st.nextToken());
			int last = Integer.valueOf(st.nextToken());

			if (i == 0) {
				minf = first;
				minm = middle;
				minl = last;

				maxf = first;
				maxm = middle;
				maxl = last;

			} else {
				int c1 = Math.min(minf + first, minm + first);
				int c2 = Math.min(minf + middle, Math.min(minm + middle, minl + middle));
				int c3 = Math.min(minm + last, minl + last);

				minf = c1;
				minm = c2;
				minl = c3;

				int d1 = Math.max(maxf + first, maxm + first);
				int d2 = Math.max(maxf + middle, Math.max(maxm + middle, maxl + middle));
				int d3 = Math.max(maxm + last, maxl + last);

				maxf = d1;
				maxm = d2;
				maxl = d3;
			}
		}
		
		int MIN = Math.min(minf, Math.min(minm, minl));
		int MAX = Math.max(maxf, Math.max(maxm, maxl));

		System.out.println(MAX + " " + MIN);
	}

}