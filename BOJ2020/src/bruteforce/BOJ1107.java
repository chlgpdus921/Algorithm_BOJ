package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1107.java
 * @author chlgpdus921
 * @date 2020. 4. 18.
 */
/* 리모컨 */
public class BOJ1107 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		String n = br.readLine();
		int n_integer = Integer.valueOf(n);
		int m = Integer.valueOf(br.readLine());
		if (m != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreElements()) {
				int index = Integer.valueOf(st.nextToken());
				arr[index]++;
			}
		}
		boolean check = true;
		//100 채널과 차이 먼저 확인
		int dif = Math.abs(n_integer - 100);
		int dif2 = Integer.MAX_VALUE;
		for (int i = 0; i < 1000000; i++) {
			String temp = String.valueOf(i);
			for (int j = 0; j < 10; j++) {
				//i가 고장난 버튼을 포함했는지 확인
				CharSequence a = j + "";
				if (arr[j] > 0 && temp.contains(a)) {
					check = false;
					break;
				}
			}
			if (check) {
				//고장난 버튼을 포함하지 않았을 경우, 가고싶은 채널과의 차이 확인
				dif2 = Math.abs(n_integer - Integer.valueOf(temp)) + temp.length();
			}
			//최솟값 갱신
			if (dif > dif2)
				dif = dif2;
			check = true;
		}
		System.out.println(dif);
	}
}
