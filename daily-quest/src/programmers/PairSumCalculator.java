package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairSumCalculator {
	public static void main(String args[]) {
		int[] numbers = { 2, 1, 3, 4, 1 };

		PairSumCalculatorSolution solver = new PairSumCalculatorSolution();
		int[] result = solver.solution(numbers);

		System.out.println(Arrays.toString(result));
	}
}

class PairSumCalculatorSolution {
	public int[] solution(int[] numbers) {
		// 중복 제거를 위해 Set 사용
		Set<Integer> result = new HashSet<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				result.add(numbers[i] + numbers[j]);
			}
		}
		// Integer -> int 로 변환 후 정렬해서 배열에 담기
		return result.stream().mapToInt(Integer::intValue).sorted().toArray();
	}
}