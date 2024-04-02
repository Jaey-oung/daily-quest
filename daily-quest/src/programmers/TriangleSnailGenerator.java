// https://school.programmers.co.kr/learn/courses/30/lessons/68645
package programmers;

import java.util.Arrays;

public class TriangleSnailGenerator {
	public static void main(String args[]) {
		int n = 4;

		TriangleSnailGeneratorSolution solver = new TriangleSnailGeneratorSolution();
		int[] result = solver.solution(n);

		System.out.println(Arrays.toString(result));
	}
}

class TriangleSnailGeneratorSolution {
	public int[] solution(int n) {
		int[][] triangle = new int[n][n];

		int x = 0;
		int y = 0;
		int value = 1;

		while (true) {
			// 아래로 이동
			while (true) {
				triangle[y][x] = value++;

				// 아래로 이동하지 못할 때
				if (y + 1 == n || triangle[y + 1][x] != 0)
					break;

				y += 1;
			}

			// 오른쪽으로 이동하지 못할 때
			if (x + 1 == n || triangle[y][x + 1] != 0)
				break;

			x += 1;

			// 오른쪽으로 이동
			while (true) {
				triangle[y][x] = value++;

				// 오른쪽으로 이동하지 못할 때
				if (x + 1 == n || triangle[y][x + 1] != 0)
					break;

				x += 1;
			}

			// 왼쪽 위로 이동하지 못할 때
			if (triangle[y - 1][x - 1] != 0)
				break;

			x -= 1;
			y -= 1;

			// 왼쪽 위로 이동
			while (true) {
				triangle[y][x] = value++;

				// 왼쪽 위로 이동하지 못할 때
				if (triangle[y - 1][x - 1] != 0)
					break;

				x -= 1;
				y -= 1;
			}

			// 아래로 이동하지 못할 때
			if (y + 1 == n || triangle[y + 1][x] != 0)
				break;

			y += 1;
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