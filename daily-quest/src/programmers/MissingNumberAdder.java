package programmers;

import java.util.HashSet;
import java.util.Set;

public class MissingNumberAdder {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 6, 7, 8, 0 };

		MissingNumberAdderSolution solver = new MissingNumberAdderSolution();
		int result = solver.solution(numbers);

		System.out.println(result);
	}
}

class MissingNumberAdderSolution {
	public int solution(int[] numbers) {
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;

		// numbers의 모든 원소를 set에 저장
		for (int num : numbers)
			set.add(num);

		for (int i = 0; i <= 9; i++) {
			// set에 포함된 숫자는 건너뛰기
			if (set.contains(i))
				continue;

			sum += i;
		}
		return sum;
	}
}