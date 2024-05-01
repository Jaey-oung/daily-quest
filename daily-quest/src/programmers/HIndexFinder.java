package programmers;

import java.util.Arrays;

public class HIndexFinder {
	public static void main(String args[]) {
		int[] citations = { 3, 0, 6, 1, 5 };

		HIndexFinderSolution solver = new HIndexFinderSolution();
		int result = solver.solution(citations);

		System.out.println(result);
	}
}

class HIndexFinderSolution {
	private boolean isValid(int[] citations, int h) {
		int index = citations.length - h;

		// 특정 인덱스의 값이 h보다 크거나 같으면 유효함
		return citations[index] >= h;
	}

	public int solution(int[] citations) {
		// 정렬
		Arrays.sort(citations);

		for (int h = citations.length; h >= 1; h--) {
			if (isValid(citations, h))
				return h;
		}
		return 0;
	}
}