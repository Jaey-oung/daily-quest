package programmers;

import java.util.Arrays;

public class SchoolPathFinder {
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 2 } };

		SchoolPathFinderSolution solver = new SchoolPathFinderSolution();
		int result = solver.solution(m, n, puddles);

		System.out.println(result);
	}
}

class SchoolPathFinderSolution {
	private final int[][] mem = new int[101][101];

	// 현재 위치는 x, y
	// 목표 위치는 w, h
	private int count(int x, int y, int w, int h, boolean[][] isPuddle) {
		// 범위를 벗어날 경우
		if (x > w || y > h)
			return 0;

		// 물에 잡겼을 경우
		if (isPuddle[y][x])
			return 0;

		// 목적지에 도착한 경우
		if (x == w && y == h)
			return 1;

		if (mem[x][y] != -1)
			return mem[x][y];

		int total = count(x + 1, y, w, h, isPuddle) + count(x, y + 1, w, h, isPuddle);

		return mem[x][y] = total % 1000000007;
	}

	public int solution(int m, int n, int[][] puddles) {
		// 배열을 -1로 채우기
		for (int[] row : mem) {
			Arrays.fill(row, -1);
		}

		boolean[][] isPuddle = new boolean[n + 1][m + 1];

		// 물에 잠긴 지역은 true 로 표시
		for (int[] p : puddles) {
			isPuddle[p[1]][p[0]] = true;
		}

		return count(1, 1, m, n, isPuddle);
	}
}