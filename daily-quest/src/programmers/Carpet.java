package programmers;

import java.util.Arrays;

public class Carpet {
	public static void main(String args[]) {
		int brown = 10;
		int yellow = 2;

		CarpetSolution solver = new CarpetSolution();
		int[] result = solver.solution(brown, yellow);

		System.out.println(Arrays.toString(result));
	}
}

class CarpetSolution {
	public int[] solution(int brown, int yellow) {
		// 격자가 만들어지려면 가로 세로 길이가 최소 3 이상
		for (int width = 3; width <= 5000; width++) {
			for (int height = 3; height <= width; height++) {
				// 테두리
				int boundary = (width + height - 2) * 2;
				// 중앙
				int center = width * height - boundary;

				if (brown == boundary && yellow == center) {
					return new int[] { width, height };
				}
			}
		}
		return null;
	}
}