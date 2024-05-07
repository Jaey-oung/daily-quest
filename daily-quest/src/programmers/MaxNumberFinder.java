package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxNumberFinder {
	public static void main(String args[]) {
		int[] numbers = { 6, 10, 2 };

		MaxNumberFinderSolution solver = new MaxNumberFinderSolution();
		String result = solver.solution(numbers);

		System.out.println(result);
	}
}

class MaxNumberFinderSolution {
	public String solution(int[] numbers) {
		// 각 숫자를 문자열로 변환
		return Arrays.stream(numbers).mapToObj(String::valueOf).sorted((s1, s2) -> {
			int original = Integer.parseInt(s1 + s2);
			int reversed = Integer.parseInt(s2 + s1);
			return reversed - original;
		})
		// 하나의 문자열로 이어붙이기
		.collect(Collectors.joining(""))
		// 문자열 시작 부분에 0이 반복되면 하나로 대체
		.replaceAll("^0+", "0");
	}
}