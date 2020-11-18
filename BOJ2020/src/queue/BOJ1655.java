package queue;

import java.util.*;
import java.io.*;

/**
 * 
 * @FileName BOJ1655.java
 * @author chlgpdus921
 * @date 2020. 11. 13.
 */
/* 가운데를 말해요 - 우선순위큐 */
public class BOJ1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());

		PriorityQueue<Integer> minheap = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
		PriorityQueue<Integer> maxheap = new PriorityQueue<>(); // 오름차순
		for (int i = 0; i < n; i++) {
			int num = Integer.valueOf(br.readLine());

			if (minheap.size() == maxheap.size()) {
				minheap.add(num);
			} else {
				maxheap.add(num);
			}

			if (!maxheap.isEmpty() && !minheap.isEmpty() && maxheap.peek() < minheap.peek()) {
				int temp = maxheap.poll();
				int temp2 = minheap.poll();
				maxheap.add(temp2);
				minheap.add(temp);
			}

			sb.append(minheap.peek() + "\n");
		}

		System.out.println(sb);
	}

}
