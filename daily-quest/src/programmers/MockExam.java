package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MockExam {
	public static void main(String args[]) {
		int[] answers = { 1, 2, 3, 4, 5 };

		MockExamSolution solver = new MockExamSolution();
		int[] result = solver.solution(answers);

		System.out.println(Arrays.toString(result));
	}
}

class MockExamSolution {
	// 수포자들이 각각 문제를 찍는 방식
	private static final int[][] RULES = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 },
			{ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }, };

	// 각 수포자가 선택한 번호
	private int getPicked(int person, int problem) {
		int[] rule = RULES[person];
		int index = problem % rule.length;

		return rule[index];
	}

	public int[] solution(int[] answers) {
		int[] corrects = new int[3];
		int max = 0;

		for (int problem = 0; problem < answers.length; problem++) {
			int answer = answers[problem];

			for (int person = 0; person < 3; person++) {
				int picked = getPicked(person, problem);
				// 정답일 경우
				if (answer == picked) {
					if (++corrects[person] > max) {
						max = corrects[person];
					}
				}
			}
		}

		final int maxCorrects = max;
		return IntStream.range(0, 3).filter(i -> corrects[i] == maxCorrects).map(i -> i + 1).toArray();
	}
}