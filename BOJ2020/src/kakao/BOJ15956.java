package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ15956.java
 * @author chlgpdus921
 * @date 2020. 4. 27.
 */
/* 카카오2018 예선 3번 숏코딩 */
public class BOJ15956 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), "&&");
		int num = st.countTokens();
		String[] s = new String[num];
		int i = 0;
		while (st.hasMoreElements()) {
			s[i] = st.nextToken();
			if (s[i].contains("==")) {
				st = new StringTokenizer(s[i], "==");
				String tmp = st.nextToken();
				String tmp2 = st.nextToken();
				Sentence sent = new Sentence(tmp, tmp2);
				
				if(! sent.check(tmp, tmp2, i)) {
					Sentence sent2 = new Sentence(tmp, tmp2);
				}
				
			}
			i++;
		}

		for (int j = 0; j < num; j++) {
			System.out.println(s[j]);
		}
	}

}

class Sentence {
	String tmp, tmp2;
	HashSet<String> hs = new HashSet<String>();

	Sentence(String tmp, String tmp2) {
		this.tmp = tmp;
		this.tmp2 = tmp2;
	}
	public boolean check(String tmp, String tmp2, int i) {
		if(hs.contains(tmp) || hs.contains(tmp2) || i ==0) {
			hs.add(tmp);
			hs.add(tmp2);
			return true;
		}
		return false;
	}
	
	public void print() {
		System.out.println(hs);
	}
	
	
}
