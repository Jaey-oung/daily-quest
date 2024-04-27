package programmers;

import java.util.Arrays;

public class KthNumberFinder {
	public static void main(String args[]) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		KthNumberFinderSolution solver = new KthNumberFinderSolution();
		int[] result = solver.solution(array, commands);

		System.out.println(Arrays.toString(result));
	}
}

class KthNumberFinderSolution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < answer.length; i++) {
			int[] command = commands[i];

			// 인덱스 값은 -1 해주기
			int start = command[0] - 1;
			int end = command[1];
			int k = command[2] - 1;

			// 복사
			int[] copy = Arrays.copyOfRange(array, start, end);
			// 정렬
			Arrays.sort(copy);

			answer[i] = copy[k];
		}
		return answer;
	}
}