package programmers;

import java.util.Arrays;

public class SteppingStone {
	public static void main(String[] args) {
		int distance = 25;
		int[] rocks = { 2, 14, 11, 21, 17 };
		int n = 2;

		SteppingStoneSolution solver = new SteppingStoneSolution();
		int result = solver.solution(distance, rocks, n);

		System.out.println(result);
	}
}

class SteppingStoneSolution {
	private boolean isValid(int d, int[] rocks, int n) {
		// 제거한 바위의 개수
		int removed = 0;
		// 마지막 바위의 위치
		int last = 0;

		for (int rock : rocks) {
			// 거리가 d보다 작으면 바위 하나 없애기
			if (rock - last < d) {
				removed++;
				continue;
			}

			last = rock;
		}
		return removed <= n;
	}

	public int solution(int distance, int[] rocks, int n) {
		rocks = Arrays.copyOf(rocks, rocks.length + 1);
		rocks[rocks.length - 1] = distance;
		Arrays.sort(rocks);

		int start = 1;
		int end = distance + 1;

		while (end - start > 1) {
			int d = (start + end) / 2;

			if (isValid(d, rocks, n)) {
				start = d;
			} else {
				end = d;
			}
		}

		return start;
	}
}