// https://school.programmers.co.kr/learn/courses/30/lessons/68645
package programmers;

import java.util.Arrays;

public class TriangleSnailGeneratorV2 {
	public static void main(String args[]) {
		int n = 4;

		TriangleSnailGeneratorSolution solver = new TriangleSnailGeneratorSolution();
		int[] result = solver.solution(n);

		System.out.println(Arrays.toString(result));
	}
}

class TriangleSnailGeneratorV2Solution {
	// x와 y의 변화량 - 순서대로 아래, 오른쪽, 왼쪽 위
	private static final int[] dx = { 0, 1, -1 };
	private static final int[] dy = { 1, 0, -1 };

	public int[] solution(int n) {
		int[][] triangle = new int[n][n];

		int x = 0;
		int y = 0;
		int value = 1;
		int d = 0;

		while (true) {
			triangle[y][x] = value++;

			int nx = x + dx[d];
			int ny = y + dy[d];

			// 범위를 벗어나거나 이동하지 못할 때
			if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
				d = (d + 1) % 3;
				nx = x + dx[d];
				ny = y + dy[d];

				// 범위를 벗어나거나 이동하지 못할 때
				if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0)
					break;
			}
			x = nx;
			y = ny;
		}

		int[] result = new int[value - 1];

		int index = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				result[index++] = triangle[i][j];
			}
		}
		return result;
	}
}