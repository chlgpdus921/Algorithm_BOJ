package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * @FileName BOJ2089.java
 * @author chlgpdus921
 * @date 2020. 3. 17.
 */
/* -2진수
 * -13 > 110111 */
public class BOJ2089 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		if (n == 0) {
			System.out.println(0);
		} else {
			while (n != 0) {
				if (n % 2 == 0) {
					sb.append(0);
					n = -(n / 2);
				} else {
					sb.append(1);
					if (n > 0) {
						n = -(n / 2);
					} else {
						n = (-n + 1) / 2;
					}
				}
			}
		}
		System.out.println(sb.reverse());
	}
}
