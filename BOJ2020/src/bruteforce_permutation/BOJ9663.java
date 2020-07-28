package bruteforce_permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @FileName BOJ9663.java
 * @author chlgpdus921
 * @date 2020. 7. 15.
 */
/* N-Queen */
public class BOJ9663 {
	static int n;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());

		for (int i = 0; i < n; i++) {
			boolean[] chess = new boolean[n];
			ArrayList<Integer> list = new ArrayList<Integer>();
			chess[i] = true;
			list.add(i);
			dfs(chess, i, 1, list);

		}
		System.out.println(cnt);

	}

	public static void dfs(boolean[] chess, int j, int index, ArrayList<Integer> list) {

		if (index == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (chess[i] == false && i != j - 1 && i != j + 1 && possible(list, i, index + 1)) {
				chess[i] = true;
				list.add(i);
				dfs(chess, i, index + 1, list);
				list.remove(list.size() - 1);
				chess[i] = false;
			}
		}
	}

	public static boolean possible(ArrayList<Integer> list, int cur, int index) {
		//대각선인지 확인하는 루트. 
		for (int i = 0; i < list.size() - 1; i++) {
			if (Math.abs(list.get(i) - cur) == Math.abs(i - index + 1))
				// 대각선인지 확인 (1 - 현재 구할 번호 ) == (현재 list의 순서 - 현재 깊이 +1)
				return false;
		}
		return true;

	}
}
