package programmers;

import java.util.Arrays;

public class StringCustomSorter {
	public static void main(String args[]) {
		String[] strings = { "sun", "bed", "car" };
		int n = 1;

		StringCustomSorterSolution solver = new StringCustomSorterSolution();
		String[] result = solver.solution(strings, n);

		System.out.println(Arrays.toString(result));
	}
}

class StringCustomSorterSolution {
	public String[] solution(String[] strings, int n) {
		Arrays.sort(strings, (s1, s2) -> {
			// 첫 문자가 다르면 두 문자 비교
			if (s1.charAt(n) != s2.charAt(n)) {
				return s1.charAt(n) - s2.charAt(n);
			}
			// 전체 문자열 비교
			return s1.compareTo(s2);
		});
		return strings;
	}
}