package myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1285 {
	static String[][] d;
	static int n, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		d = new String[n][n];

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				d[i][j] = temp[j];
			}
		}
		greedy();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(d[i][j]);
			}
			System.out.println();
		}
		System.out.println(min);

	}

	public static void greedy() {
		int sum = 0;

		for (int i = 0; i < n; i++) {
			if (!countRow(i)) {
				for (int j = 0; j < n; j++) {
					d[i][j] = d[i][j].equals("H") ? "T" : "H";
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (!countCol(i)) {
				for (int j = 0; j < n; j++) {
					d[j][i] = d[j][i].equals("H") ? "T" : "H";
				}
			}
		}
		
	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (d[i][j].equals("T"))
					sum++;
			}
		}
		if(min > sum)
			min = sum;

	}

	public static boolean countRow(int index) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (d[index][i].equals("T"))
				sum++;
		}
		if (Math.abs(sum - n) > sum) // 1 2
			return true;
		return false;
	}

	public static boolean countCol(int index) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (d[i][index].equals("T"))
				sum++;
		}
		if (Math.abs(sum - n) > sum)
			return true;
		return false;
	}

}
