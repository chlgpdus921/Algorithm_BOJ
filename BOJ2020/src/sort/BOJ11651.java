package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ11651.java
 * @author chlgpdus921
 * @date 2020. 4. 8.
 */
/* 좌표 정렬하기2 */
class Point2 implements Comparable<Point2> {
	public int x, y;

	Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Point2 point) {
		if (this.y < point.y)
			return -1;
		else if (this.y == point.y) {
			if (this.x < point.x) {
				return -1;
			} else if (this.x == point.x)
				return 0;
			else
				return 1;
		} else
			return 1;
	}
}

public class BOJ11651 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.valueOf(br.readLine());
		Point2[] arr = new Point2[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			arr[i] = new Point2(x, y);

		}

		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			sb.append(arr[i].x + " " + arr[i].y + "\n");
		}
		System.out.println(sb);

	}
}