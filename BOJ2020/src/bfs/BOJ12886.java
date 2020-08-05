package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 
 * @FileName BOJ12886.java
 * @author chlgpdus921
 * @date 2020. 8. 4.
 */
/* 돌 그룹 */
public class BOJ12886 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());
		int c = Integer.valueOf(st.nextToken());

		boolean check = false;
		Queue<Stone> q = new LinkedList<Stone>();
		q.add(new Stone(a, b, c));
		int cnt = 0;
		while (!q.isEmpty()) {
			Stone cur = q.poll();
			cnt++;
			int na = cur.a;
			int nb = cur.b;
			int nc = cur.c;
			if (cnt >= 10000)
				break;
			if (na == nb && nb == nc && nc == na) {
				check = true;
				break;
			}

			if (na < nb) {
				nb = nb - na;
				na += na;
				q.add(new Stone(na, nb, nc));
			}

			na = cur.a;
			nb = cur.b;
			nc = cur.c;
			if (na > nb) {
				na = na - nb;
				nb += nb;
				q.add(new Stone(na, nb, nc));
			}

			na = cur.a;
			nb = cur.b;
			nc = cur.c;
			if (nb < nc) {
				nc = nc - nb;
				nb += nb;
				q.add(new Stone(na, nb, nc));
			}
			na = cur.a;
			nb = cur.b;
			nc = cur.c;
			if (nb > nc) {
				nb = nb - nc;
				nc += nc;
				q.add(new Stone(na, nb, nc));
			}

			na = cur.a;
			nb = cur.b;
			nc = cur.c;
			if (na > nc) {
				na = na - nc;
				nc += nc;
				q.add(new Stone(na, nb, nc));
			}

			na = cur.a;
			nb = cur.b;
			nc = cur.c;
			if (na < nc) {
				nc = nc - na;
				na += na;
				q.add(new Stone(na, nb, nc));
			}

		}

		System.out.println(check ? "1" : "0");
	}
}

class Stone {
	int a, b, c;

	Stone(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
