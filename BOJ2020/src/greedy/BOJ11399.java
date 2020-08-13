package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ11399.java
 * @author chlgpdus921
 * @date 2020. 8. 7.
 */
/* ATM */
public class BOJ11399 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] data = new int[n];
		int[] d = new int[n+1];
		for (int i = 0; i < n; i++) {
			data[i] = Integer.valueOf(st.nextToken());
		}
		
		Arrays.sort(data);
		int sum = data[0];
		d[0] = data[0];
		for(int i = 1; i< n; i++) {
			d[i] = d[i-1] + data[i]; 
			sum += d[i];
		}
		System.out.println(sum);
		
	}

}
