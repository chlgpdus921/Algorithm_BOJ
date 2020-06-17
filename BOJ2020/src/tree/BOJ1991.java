package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName BOJ1991.java
 * @author chlgpdus921
 * @date 2020. 6. 8.
 */
/* BOJ1991 트리 순회 */
public class BOJ1991 {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st;
		sb = new StringBuilder();
		Tree[] tree = new Tree[26];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int root = st.nextToken().charAt(0) - 'A';
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			int leftValue = -1, rightValue = -1;
			if (left != '.') {
				leftValue = left - 'A';
			}
			if (right != '.') {
				rightValue = right - 'A';
			}
			tree[root] = new Tree(leftValue, rightValue);
		}

		preorder(tree, 0);
		sb.append("\n");
		inorder(tree, 0);
		sb.append("\n");
		postorder(tree, 0);

		System.out.println(sb);
	}

	public static void preorder(Tree[] tree, int i) {
		if (i == -1)
			return;

		sb.append((char) (i + 'A'));
		preorder(tree, tree[i].left);
		preorder(tree, tree[i].right);
	}

	public static void inorder(Tree[] tree, int i) {
		if (i == -1)
			return;
		inorder(tree, tree[i].left);
		sb.append((char) (i + 'A'));
		inorder(tree, tree[i].right);
	}

	public static void postorder(Tree[] tree, int i) {
		if (i == -1)
			return;
		postorder(tree, tree[i].left);
		postorder(tree, tree[i].right);
		sb.append((char) (i + 'A'));
	}
}

class Tree {
	int left, right;

	Tree(int left, int right) {
		this.left = left;
		this.right = right;
	}

}
