package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ11576.java
 * @author chlgpdus921
 * @date 2020. 3. 17.
 */
/* Base Conversion
 * A진법을 B진법으로 
 * */
public class BOJ11576 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(br.readLine());
		int[] data = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		int i = 0;
		while (st.hasMoreElements()) {
			data[i] = Integer.valueOf(st.nextToken());
			i++;
		}
		int sum = 0;
		for (int j = 0; j < data.length; j++) {
			sum += (int) (data[j] * Math.pow(a, i - 1));
			i--;
		}
		convert(sum, b);

	}

	public static void convert(int n, int b) {
		if (n == 0)
			return;
		convert(n / b, b);
		System.out.print(n % b + " ");
	}
}
