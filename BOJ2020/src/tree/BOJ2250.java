package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ2250.java
 * @author chlgpdus921
 * @date 2020. 6. 8.
 */
/* BOJ2250 트리의 높이와 너비 */
public class BOJ2250 {
	static int cnt = 1;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st;
		Tree2[] tree = new Tree2[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		int[] findRoot = new int[n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int root = Integer.valueOf(st.nextToken());
			int left = Integer.valueOf(st.nextToken());
			int right = Integer.valueOf(st.nextToken());
			if (left != -1)
				findRoot[left] += 1;
			if (right != -1)
				findRoot[right] += 1;
			tree[root] = new Tree2(left, right);
		}
		int first = 0;
		for (int i = 1; i <= n; i++) {
			if (findRoot[i] == 0)
				first = i;
		}
		inorder(tree, first, 1);

		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		for (int i = 0; i < cnt; i++) {
			Collections.sort(list[i]);

			if (list[i].size() > 0) {
				int compare = list[i].get(list[i].size() - 1) - list[i].get(0);
				if (compare > max) {
					max = compare;
					maxIndex = i;
				}
			}
		}
		System.out.println(maxIndex + " " + (max + 1));
	}

	public static void inorder(Tree2[] tree, int i, int level) {
		if (i == -1)
			return;

		inorder(tree, tree[i].left, level + 1);
		list[level].add(cnt);
		cnt++;
		inorder(tree, tree[i].right, level + 1);

	}
}

 class Tree2 {
	int left, right;

	Tree2(int left, int right) {
		this.left = left;
		this.right = right;
	}

}
