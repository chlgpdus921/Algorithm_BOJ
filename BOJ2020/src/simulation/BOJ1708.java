package simulation;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ1708.java
 * @author chlgpdus921
 * @date 2020. 11. 23.
 */
/* 볼록 껍질 */
public class BOJ1708 {
	static Point1708 first = new Point1708(Integer.MAX_VALUE, Integer.MAX_VALUE);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());

		StringTokenizer st;
		ArrayList<Point1708> point = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			point.add(new Point1708(x, y));
		}

		Stack<Point1708> cvh = convexHull(point);
		System.out.println(cvh.size());
	}

	private static Stack<Point1708> convexHull(ArrayList<Point1708> point) {
		// y좌표가 가장 작은 점을 기준점으로 잡는다.
		for (int i = 0; i < point.size(); i++) {
			if (point.get(i).y < first.y) {
				first = point.get(i);
			}
			// y좌표가 동일한 경우 x좌표를 비교한다. 
			else if (point.get(i).y == first.y) {
				if (point.get(i).x < first.x) {
					first = point.get(i);
				}
			}
		}

		// 기준점과 나머지점들이 ccw로 반시계방향(좌회전)이 되도록 정랼한다.
		// 만약 세개의 점이 일직선상에 있으면 거리가 증가하도록 정렬
		point.sort(new Comparator<Point1708>() {
			@Override
			public int compare(Point1708 second, Point1708 third) {
				int result = ccw(first, second, third);
				if (result > 0)
					return -1;
				else if (result < 0)
					return 1;
				else { // result == 0으로 세 점이 일직선상에 있는 경우
					if (dist(first, second) > dist(first, third))
						return 1;
				}
				return -1;
			}
		});

		// Graham Scan 알고리즘
		Stack<Point1708> stack = new Stack<>();
		stack.add(first);
		for (int i = 1; i < point.size(); i++) {
			while (stack.size() > 1
					&& ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), point.get(i)) <= 0) {
				stack.pop();
			}
			stack.add(point.get(i));
		}

		return stack;
	}

	private static int ccw(Point1708 a, Point1708 b, Point1708 c) {
		long result = (a.x * b.y + b.x * c.y + c.x * a.y) - (b.x * a.y + c.x * b.y + a.x * c.y);
		if (result > 0)
			return 1;
		if (result < 0)
			return -1;
		return 0;
	}

	private static long dist(Point1708 a, Point1708 b) {
		return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
	}
}

class Point1708 {
	long x, y;

	public Point1708(long x, long y) {
		this.x = x;
		this.y = y;
	}
}
