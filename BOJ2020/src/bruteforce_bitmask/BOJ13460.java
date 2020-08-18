package bruteforce_bitmask;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ13460.java
 * @author chlgpdus921
 * @date 2020. 8. 4.
 */
/* 구슬 탈출 2 */
public class BOJ13460 {
	public static final int RED = 0, BLUE = 1;
	public static int n, m;
	public static String[][] d;
	public static boolean[][][][] visited;
	public static int[] dirX = new int[] { 0, 0, 1, -1 }; 
	public static int[] dirY = new int[] { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		d = new String[n][m];
		visited = new boolean[10][10][10][10];

		Marble node = new Marble();
		node.cnt = 0;

		//입력 받으면서 R, L 위치 저장
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			String[] temp = s.split("");
			for (int j = 0; j < m; j++) {
				d[i][j] = temp[j];
				if (d[i][j].equals("R")) {
					node.rRow = i;
					node.rCol = j;
				} else if (d[i][j].equals("B")) {
					node.bRow = i;
					node.bCol = j;
				}
			}
		}
		bfs(node);
	}

	public static void bfs(Marble ball) {
		Queue<Marble> q = new LinkedList<Marble>();
		q.add(ball);

		while (!q.isEmpty()) {
			Marble node = q.poll();
			visited[node.rRow][node.rCol][node.bRow][node.bCol] = true;

			if (node.cnt >= 10) {
				System.out.println(-1);
				return;
			}

			for (int dir = 0; dir < 4; dir++) {
				// 파란색 구슬 굴리기
				int bnRow = node.bRow;
				int bnCol = node.bCol;
				while (! d[bnRow + dirX[dir]][bnCol + dirY[dir]].equals("#")) {
					bnRow += dirX[dir];
					bnCol += dirY[dir];
					if (d[bnRow][bnCol].equals("O")) {
						break;
					}
				}

				// 빨간색 구슬 굴리기
				int rnRow = node.rRow;
				int rnCol = node.rCol;
				while (!d[rnRow + dirX[dir]][rnCol + dirY[dir]].equals("#")) {
					rnRow += dirX[dir];
					rnCol += dirY[dir];
					if (d[rnRow][rnCol].equals("O")) {
						break;
					}
				}

				// 파란색 구슬이 'O'에 빠졌다면 종료.
				if (d[bnRow][bnCol].equals("O"))
					continue;

				// 빨간색 구슬만 'O'에 빠졌다면, 정답을 출력한다.
				if (d[rnRow][rnCol].equals("O")) {
					System.out.println(node.cnt + 1);
					return;
				}

				// 두 구슬의 위치가 같다면, 위치를 조정한다.
				if (rnRow == bnRow && rnCol == bnCol) {
					switch (dir) {

					case 0: // 동
						if (node.rCol > node.bCol)
							bnCol -= 1;
						else
							rnCol -= 1;
						break;
					case 1: // 서
						if (node.rCol > node.bCol)
							rnCol += 1;
						else
							bnCol += 1;
						break;
					case 2: // 남
						if (node.rRow > node.bRow)
							bnRow -= 1;
						else
							rnRow -= 1;
						break;
					case 3: // 북
						if (node.rRow > node.bRow)
							rnRow += 1;
						else
							bnRow += 1;
						break;
					}
				}
				// 두 구슬을 굴린 후의 각각의 위치가 처음 탐색하는 것이라면 큐에 넣는다.
				if (!visited[rnRow][rnCol][bnRow][bnCol]) {
					q.add(new Marble(rnRow, rnCol, bnRow, bnCol, node.cnt + 1));
				}
			}
		}
		System.out.println(-1);

	}
}

class Marble {
	int rRow, rCol, bRow, bCol;
	int cnt;

	Marble(int rRow, int rCol, int bRow, int bCol, int cnt) {
		this.rRow = rRow;
		this.rCol = rCol;
		this.bRow = bRow;
		this.bCol = bCol;
		this.cnt = cnt;
	}

	Marble() {
	}

}