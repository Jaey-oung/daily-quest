package programmers;

import java.util.HashMap;
import java.util.Map;

public class AToBConverter {
	public static void main(String[] args) {
		String before = "olleh";
		String after = "hello";

		AToBConverterSolution solver = new AToBConverterSolution();
		int result = solver.solution(before, after);

		System.out.println(result);
	}
}

class AToBConverterSolution {
	private static Map<Character, Integer> toMap(String word) {
		Map<Character, Integer> map = new HashMap<>();

		for (char c : word.toCharArray()) {
			// 문자가 map에 포함되어 있지 않으면 추가
			map.putIfAbsent(c, 0);
			// 포함되어 있다면 개수 1 추가
			map.put(c, map.get(c) + 1);
		}
		return map;
	}

	public int solution(String before, String after) {
		return toMap(before).equals(toMap(after)) ? 1 : 0;
	}
}