package bruteforce_permutation;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ1339.java
 * @author chlgpdus921
 * @date 2020. 6. 14.
 */
/* 단어 수학 */
public class BOJ1339 {
	static HashMap<String, Integer> hs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());

		hs = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			String[] data = s.split("");
			store(data);
		}

		int num = 9, sum = 0;
		Iterator it = sortByValue().iterator();
		while (it.hasNext()) {
			String temp = (String) it.next();
			sum += (hs.get(temp) * num);
			num--;
		}
		System.out.println(sum);
	}

	public static void store(String[] data) {
		int size = data.length - 1;
		for (int i = 0; i < data.length; i++) {
			int value = (int) Math.pow(10, size);

			if (hs.containsKey(data[i])) {
				int cur = hs.get(data[i]);
				hs.replace(data[i], cur + value);
			} else {
				hs.put(data[i], value);
			}
			size--;
		}
	}

	public static ArrayList<String> sortByValue() {
		ArrayList<String> list = new ArrayList<>(hs.keySet());

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return hs.get(o2).compareTo(hs.get(o1));
			}
		});

		return list;
	}
}