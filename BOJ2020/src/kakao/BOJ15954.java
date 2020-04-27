package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ15954.java
 * @author chlgpdus921
 * @date 2020. 4. 27.
 */
/*
 * 카카오2018 예선 2번 인형들
 */
public class BOJ15954 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.valueOf(st.nextToken());
		int kk = Integer.valueOf(st.nextToken());
		int[] arr = new int[n];
		double result = Double.MAX_VALUE;
		st = new StringTokenizer(br.readLine(), " ");
		int i = 0;
		while (st.hasMoreElements()) {
			arr[i] = Integer.valueOf(st.nextToken());
			i++;
		}

		for (i = 0; i < arr.length; i++) {
			for (int k = kk; k <= arr.length; k++) {
				if (arr.length - i >= k) { //남은 길이가 k이상인지 확인
					// k가 3이면 012 0123 01234 123 1234 로 나아감
					double sum = 0;
					int j = i;
					int cnt = 0;
					while (cnt < k) {
						if (j < arr.length) {
							sum += arr[j];
						}
						j++;
						cnt++;
					}
					// mean
					double m = sum / k;
					j = i;
					sum = 0;
					cnt = 0;
					// 똑같이 앞처럼 이동해서 varience랑 표편구함
					while (cnt < k) {
						if (j < arr.length) {
							double dif = Math.abs(arr[j] - m);
							if (dif != 0)
								sum += Math.pow(dif, 2);
						}
						j++;
						cnt++;
					}
					double varience = sum / k;
					double tmp = Math.sqrt(varience);
					// 최솟값 갱신
					if (result > tmp)
						result = tmp;
				}
			}
		}
		System.out.println(String.format("%.11f", result));
	}
}
