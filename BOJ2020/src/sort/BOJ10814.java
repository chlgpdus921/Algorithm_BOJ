package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 
 * @FileName BOJ10814.java
 * @author chlgpdus921
 * @date 2020. 4. 8.
 */
/* 나이순 정렬 */
class Person implements Comparable<Person> {
	public int age, index;
	public String name;

	Person(int age, String name, int index) {
		this.age = age;
		this.name = name;
		this.index = index;
	}

	public int compareTo(Person p) {
		if (this.age < p.age) {
			return -1;
		} else if (this.age == p.age) {
			if (this.index < p.index)
				return -1;
			else
				return 1;
		} else
			return 1;
	}
}

public class BOJ10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.valueOf(br.readLine());
		Person[] arr = new Person[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.valueOf(st.nextToken());
			String name = st.nextToken();

			arr[i] = new Person(age, name, i);

		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			sb.append(arr[i].age + " " + arr[i].name + "\n");
		}
		System.out.println(sb);

	}
}
