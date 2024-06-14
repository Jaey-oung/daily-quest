package programmers;

import java.util.HashMap;
import java.util.Map;

public class IncompleteRunnerFinder {
	public static void main(String[] args) {
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };

		IncompleteRunnerFinderSolution solver = new IncompleteRunnerFinderSolution();
		String result = solver.solution(participant, completion);

		System.out.println(result);
	}
}

class IncompleteRunnerFinderSolution {
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> count = new HashMap<>();

		for (String name : participant) {
			// 처음 나온 name 을 count 에 추가
			count.putIfAbsent(name, 0);
			// 등장 횟수 1 증가
			count.put(name, count.get(name) + 1);
		}

		// completion 에 있는 이름에 대한 값 1 낮추기
		for (String name : completion) {
			// // 등장 횟수 1 감소
			int n = count.get(name) - 1;
			count.put(name, n);

			// 등장 횟수가 0이면 count 에서 제거
			if (n == 0)
				count.remove(name);
		}
		return count.keySet().iterator().next();
	}
}