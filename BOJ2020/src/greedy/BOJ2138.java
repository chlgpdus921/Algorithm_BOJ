package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @FileName BOJ2138.java
 * @author chlgpdus921
 * @date 2020. 8. 24.
 */
/* 전구와 스위치 */
public class BOJ2138 {
	static int sum = Integer.MAX_VALUE;
	static String[] light, light2, result;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());

		light = br.readLine().split("");
		result = br.readLine().split("");

		light2 = Arrays.copyOf(light, n);

		find(1, 0); //첫번째 전구 누르지 않았을 때

		light = light2;
		push(0);
		find(1, 1); //첫번째 전구 누르고 시작
		System.out.println(sum == Integer.MAX_VALUE ? "-1" : sum);
	}

	public static void find(int i, int s) {

		if (i == n - 1) { //마지막 index일때
			if (compare()) { //우선 찾으려는 문자열인지 확인
				sum = Math.min(sum, s);
				return;
			} else {//아닐 경우 스위치누름
				push(i);
				if (compare()) { //다시 같은지 확인
					sum = Math.min(sum, s + 1);
					return;
				} else {
					return;
				}
			}

		}

		if (light[i - 1].equals(result[i - 1])) { //동일하면 다음꺼에서 찾아줌
			find(i + 1, s);
		}
		push(i); //눌러보고 
		if (light[i - 1].equals(result[i - 1])) {
			find(i + 1, s + 1); //동일하다면 다음꺼에서 찾아줌
		}
		push(i); //다시 제자리
	}

	public static boolean compare() {
		int cnt = 0;
		for (int j = 0; j < n; j++) {
			if (light[j].equals(result[j]))
				cnt++;
		}
		if (cnt == n)
			return true;
		return false;
	}

	public static void push(int i) {
		if (i > 0) {
			light[i - 1] = light[i - 1].equals("1") ? "0" : "1";
		}
		if (i < n - 1) {
			light[i + 1] = light[i + 1].equals("1") ? "0" : "1";
		}
		light[i] = light[i].equals("1") ? "0" : "1";
	}

}
