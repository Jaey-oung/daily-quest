package programmers;

import java.util.Arrays;

public class TriangleMaxPathFinder {
	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };

		TriangleMaxPathFinderSolution solver = new TriangleMaxPathFinderSolution();
		int result = solver.solution(triangle);

		System.out.println(result);
	}
}

class TriangleMaxPathFinderSolution {
	private final int[][] mem = new int[501][501];

	private int max(int x, int y, int[][] triangle) {
		// 삼각형의 끝에 도달했을 경우
		if (y == triangle.length)
			return 0;

		// -1이 아니라면 계산된 값
		if (mem[x][y] != -1)
			return mem[x][y];

		return mem[x][y] = triangle[y][x] + Math.max(max(x, y + 1, triangle), max(x + 1, y + 1, triangle));
	}

	public int solution(int[][] triangle) {
		// 배열을 -1로 채우기
		for (int[] row : mem)
			Arrays.fill(row, -1);

		return max(0, 0, triangle);
	}
}