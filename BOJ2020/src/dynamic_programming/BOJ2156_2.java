package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ2156_2.java
 * @author chlgpdus921
 * @date 2020. 3. 9.
 */
/* 포도주 시식 
 * 일차원 배열로 접근
 * 선택, 앞선택x 현위치선택, 앞선택o 현위치선택
 * 2차원배열과 시간은 같게 나왔다.
 * */
public class BOJ2156_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] grape = new int[n + 1];
		int[] d = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			grape[i] = Integer.valueOf(br.readLine());
		}
		d[0] = 0;
		d[1] = grape[1];
		if(n>=2) {
			d[2] = d[1] + grape[2];
		}
		for (int i = 3; i <= n; i++) {
			d[i] = Math.max(Math.max(d[i - 1], d[i - 2] + grape[i]), d[i - 3] + grape[i - 1] + grape[i]);
		}
		System.out.println(d[n]);
	}
}
