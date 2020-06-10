package bruteforce_bitmask;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ11723.java
 * @author chlgpdus921
 * @date 2020. 6. 10.
 */
/*
 * 집합 비트마스크 : 연산자 우선순위 주의
 * 비트마스크인데 비트로 풀지 않았다.ㅎ 
 */
public class BOJ11723 {
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		list = new ArrayList<Integer>();
		int n = Integer.valueOf(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();

			if (command.equals("add")) {
				int num = Integer.valueOf(st.nextToken());
				add(num);
			} else if (command.equals("remove")) {
				int num = Integer.valueOf(st.nextToken());
				remove(num);
			} else if (command.equals("check")) {
				int num = Integer.valueOf(st.nextToken());
				sb.append(check(num)).append("\n");
			} else if (command.equals("toggle")) {
				int num = Integer.valueOf(st.nextToken());
				toggle(num);
			} else if (command.equals("all")) {
				all();
			} else if (command.equals("empty")) {
				empty();
			}
		}
		System.out.println(sb);
	}

	public static void add(int num) {
		list.add(num);
	}

	public static void remove(int num) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(num)) {
				list.remove(i);
				return;
			}
		}
	}

	public static int check(int num) {
		if (list.contains(num))
			return 1;
		return 0;
	}

	public static void toggle(int num) {
		if (check(num) == 1)
			remove(num);
		else {
			add(num);
		}
	}

	public static void all() {
		list = new ArrayList<Integer>();
		for (int i = 1; i <= 20; i++) {
			list.add(i);
		}
	}

	public static void empty() {
		list = new ArrayList<Integer>();
	}

}
