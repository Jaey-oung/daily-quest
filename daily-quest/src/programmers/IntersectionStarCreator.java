// https://school.programmers.co.kr/learn/courses/30/lessons/87377
package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionStarCreator {
	public static void main(String args[]) {
		int[][] line = { { 2, -1, 4 }, { -2, -1, 4 }, { 0, -1, 1 }, { 5, -8, -12 }, { 5, 8, 12 } };

		IntersectionStarCreatorSolution solver = new IntersectionStarCreatorSolution();
		String[] result = solver.solution(line);

		for (String s : result)
			System.out.println(s);
	}

}

class IntersectionStarCreatorSolution {
	private static class Point {
		private final long x, y;

		private Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	// 두 직선의 교점 찾기
	private Point intersection(long a, long b, long e, long c, long d, long f) {
		double x = (double) (b * f - e * d) / (a * d - b * c);
		double y = (double) (e * c - a * f) / (a * d - b * c);

		// 교점이 정수가 아니면 null 반환
		if (x % 1 != 0 || y % 1 != 0)
			return null;

		return new Point((long) x, (long) y);
	}

	// 교점 중에서 최댓값 구하기
	private Point getMaxPoint(List<Point> points) {
		long x = Long.MIN_VALUE;
		long y = Long.MIN_VALUE;

		for (Point p : points) {
			if (x < p.x)
				x = p.x;

			if (y < p.y)
				y = p.y;
		}
		return new Point(x, y);
	}

	// 교점 중에서 최솟값 구하기
	private Point getMinPoint(List<Point> points) {
		long x = Long.MAX_VALUE;
		long y = Long.MAX_VALUE;

		for (Point p : points) {
			if (x > p.x)
				x = p.x;

			if (y > p.y)
				y = p.y;
		}
		return new Point(x, y);
	}

	public String[] solution(int[][] line) {
		List<Point> points = new ArrayList<>();

		for (int i = 0; i < line.length; i++) {
			for (int j = i + 1; j < line.length; j++) {
				Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1],
						line[j][2]);

				// 교점이 정수가 아니면 교점 리스트에 추가
				if (intersection != null)
					points.add(intersection);

			}
		}

		Point maxPoint = getMaxPoint(points);
		Point minPoint = getMinPoint(points);

		// 틀을 위한 길이와 높이 구하기
		int width = (int) (maxPoint.x - minPoint.x + 1);
		int height = (int) (maxPoint.y - minPoint.y + 1);

		char[][] board = new char[height][width];

		// 틀을 점으로 채우기
		for (char[] row : board)
			Arrays.fill(row, '.');

		// 일반 좌표에서 2차원 배열 좌표로 옮기기
		for (Point p : points) {
			int x = (int) (p.x - minPoint.x);
			int y = (int) (maxPoint.y - p.y);

			board[y][x] = '*';
		}

		String[] result = new String[board.length];

		for (int i = 0; i < result.length; i++)
			result[i] = new String(board[i]);
		return result;
	}
}