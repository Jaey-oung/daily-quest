package programmers;

public class StrangeStringConverter {
	public static void main(String args[]) {
		String s = "try hello world";

		StrangeStringConverterSolution solver = new StrangeStringConverterSolution();
		String result = solver.solution(s);

		System.out.println(result);
	}
}

class StrangeStringConverterSolution {
	public String solution(String s) {
		StringBuilder builder = new StringBuilder();
		// 각 단어의 첫 문자는 대문자로
		boolean toUpper = true;

		for (char c : s.toCharArray()) {
			// 문자가 알파벳이 아니면 그대로 추가
			if (!Character.isAlphabetic(c)) {
				builder.append(c);
				// 다음 문자는 대문자
				toUpper = true;
			} else {
				builder.append(toUpper ? Character.toUpperCase(c) : Character.toLowerCase(c));
				// 다음 문자는 반전
				toUpper = !toUpper;
			}
		}
		return builder.toString();
	}
}