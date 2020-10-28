package stack;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ1662.java
 * @author chlgpdus921
 * @date 2020. 10. 27.
 */
/* 압축 */
public class BOJ1662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		Stack<String> data = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ')') {
				data.add(s.charAt(i) + "");
			} 
			else {
				int k = 1, q = 0;

				while (true) {
					String tmp = data.pop();

					if (tmp.equals("(")) {
						k = Integer.valueOf(data.pop()); // ( 일 때는 그 이전 숫자가 k이므로 pop
						break;
					} else if (Integer.valueOf(tmp) < 0) {
						q += (-Integer.valueOf(tmp));
						// 2(2) = 2 라고 계산했을 경우 다시 stack에 넣어줘야하는데, 이때 2라는 숫자가 아닌 길이임을 알려주기 위해 -2표시
					} else {
						q++;
					}
				}

				int cal = k * q;
				if (cal != 0)
					data.add(String.valueOf(-cal));
			}
		}

		int size = data.size();
		int result = 0;
		for (int i = 0; i < size; i++) {
			int num = Integer.valueOf(data.pop());
			if (num < 0) {
				result += (-num);
			} else
				result++;

		}
		System.out.println(result);
	}
}
