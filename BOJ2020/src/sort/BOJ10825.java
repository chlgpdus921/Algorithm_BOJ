package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ10825.java
 * @author chlgpdus921
 * @date 2020. 4. 8.
 */
/* 국영수 */
class Subject implements Comparable<Subject> {
	public String name;
	public int ko, en, math;

	Subject(String name, int ko, int en, int math) {
		this.name = name;
		this.ko = ko;
		this.en = en;
		this.math = math;
	}

	public int compareTo(Subject sub) {
		if (this.ko > sub.ko) {
			return -1;
		} 
		else if (this.ko == sub.ko) {
			if (this.en < sub.en) {
				return -1;
			} 
			else if (this.en == sub.en) {
				if (this.math > sub.math) {
					return -1;
				} 
				else if (this.math == sub.math) {
					return this.name.compareTo(sub.name);
				} 
				else
					return 1;
			} 
			else
				return 1;
		} 
		else
			return 1;

	}

}

public class BOJ10825 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.valueOf(br.readLine());
		Subject[] arr = new Subject[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int ko = Integer.valueOf(st.nextToken());
			int en = Integer.valueOf(st.nextToken());
			int math = Integer.valueOf(st.nextToken());

			arr[i] = new Subject(name, ko, en, math);

		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			sb.append(arr[i].name + "\n");
		}
		System.out.println(sb);

	}

}
