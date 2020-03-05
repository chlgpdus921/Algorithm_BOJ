package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] d = new int[n + 1];

		d[1] = 0;

		if (n >= 2) {
			d[2] = 1;
		}

		for (int i = 3; i < n + 1; i++) {
			if( i% 2 ==0 && i %3 ==0) {
				d[i] = Math.min(Math.min(d[i / 2], d[i - 1]), d[i/3])+ 1;
			}
			else if (i % 2 == 0) {
				d[i] = Math.min(d[i / 2], d[i - 1]) + 1;
			} 
			else if (i % 3 == 0) {
				d[i] = Math.min(d[i / 3], d[i - 1]) + 1;
			} 
			else {
				d[i] = d[i - 1] + 1;
			}
			System.out.println(i +" "+ d[i]);
		}
		System.out.println(d[n]);
	}

}
