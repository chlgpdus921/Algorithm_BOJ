package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName BOJ2011.java
 * @author chlgpdus921
 * @date 2020. 3. 13.
 */
/*
 * 암호코드 
 * 25114 정답:6 1010 정답:1, 1054:1, 1203:1, 050:0, 112200:0
 */
public class BOJ2011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int nLen = n.length();
		long[] d = new long[nLen + 1];

		d[0] = 1;
		// 첫번째 문자가 0인지 확인.
		if (n.substring(0, 1).equals("0")) {
			d[1] = 0;
		} else {
			d[1] = 1;
		}

		for (int i = 2; i <= nLen; i++) {
			String tmp = n.substring(i - 2, i);// 1203입력이라면 "12"
			Long temNum = Long.valueOf(tmp);// 문자를 숫자로 변환 12
			String word = n.substring(i - 1, i);// 2이라는 한 단어
			if (word.equals("0")) {
				if (temNum > 26) {
					d[i - 1]--;
					d[i] = d[i - 1] % 1000000;
				} else {
					// 20은 26보다 크지않으므로 여기들어옴
					// 12,0은 불가하므로 1,20으로 되어야함. d[i-2]와 더한다.
					d[i] = d[i - 2] % 1000000;
				}
			} else if (temNum > 26 || Long.toString(temNum).length() == 1) {
				d[i] = d[i - 1] % 1000000;
			} else {
				d[i] = (d[i - 1] + d[i - 2]) % 1000000;
			}
			if (tmp.equals("00")) {
				// 연속해서 00이 있을경우 해석불가능한 경우.
				d[nLen] = 0;
				break;
			}
		}

		if (d[nLen] < 0)
			d[nLen] = 0;
		System.out.println(d[nLen]);

	}
}
