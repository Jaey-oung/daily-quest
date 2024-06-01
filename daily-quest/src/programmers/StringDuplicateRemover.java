package programmers;

import java.util.HashSet;
import java.util.Set;

public class StringDuplicateRemover {
	public static void main(String[] args) {
		String my_string = "people";

		StringDuplicateRemoverSolution solver = new StringDuplicateRemoverSolution();
		String result = solver.solution(my_string);

		System.out.println(result);
	}
}

class StringDuplicateRemoverSolution {
	public String solution(String my_string) {
		Set<Character> charSet = new HashSet<>();
		StringBuilder builder = new StringBuilder();

		for (char c : my_string.toCharArray()) {
			// c가 사용되지 않았을 때만 charSet과 builder에 추가
			if (charSet.contains(c))
				continue;

			charSet.add(c);
			builder.append(c);
		}
		return builder.toString();
	}
}