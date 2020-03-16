package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ1212.java
 * @author chlgpdus921
 * @date 2020. 3. 13.
 */
/* 8진수 2진수 */
public class BOJ1212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String n = br.readLine();
	
		for (int i = n.length() - 1; i >= 0; i--) {
			int number = n.charAt(i) - 48;
			int cnt = 0;
			while (number != 0) {
				long temp = number % 2;
				sb.append(temp);
				number = number / 2;
				cnt++;
			}
			if (cnt != 3 && i != 0) {
				for (int k = cnt; k<3; k++) {
					sb.append(0);
				}
			}

		}
		String result = sb.reverse().toString();
		result = result.replaceAll("^0+", "");
		if(n.equals("0"))
			result = "0";
		System.out.println(result);
	}
}
