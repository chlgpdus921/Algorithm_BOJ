package bruteforce_recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/**
 * 
 * @FileName BOJ2529.java
 * @author chlgpdus921
 * @date 2020. 6. 10.
 */
/* 부등호 */
public class BOJ2529 {
	static String[] str;
	static int n;
	static ArrayList<String> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		str = new String[n];
		int i = 0;
		while (st.hasMoreElements()) {
			str[i] = st.nextToken();
		
			i++;
		}
		boolean[] check = new boolean[10]; //0 1 2 3 4 5 6 7 8 9
		dfs(0, check, "");

		Collections.sort(result);

		System.out.println(result.get(result.size() - 1));
		System.out.println(result.get(0));

	}

	public static void dfs(int index, boolean[] check, String data) {
		if (index == n + 1) {
			if (inspectData(data))
				result.add(data);
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (check[i] == false) {
				check[i] = true;
				dfs(index + 1, check, data + "" + i);
				check[i] = false;
			}
		}
	}

	public static boolean inspectData(String data) {
		for (int i = 0; i < n; i++) { // 2 3  2
			if (str[i].equals("<")) {
				if (data.charAt(i) > data.charAt(i + 1))
					return false;
			} else if (str[i].equals(">")) {
				if (data.charAt(i) < data.charAt(i + 1))
					return false;
			}
		}

		return true;
	}

}