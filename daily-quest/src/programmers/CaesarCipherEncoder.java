package programmers;

public class CaesarCipherEncoder {
	public static void main(String args[]) {
		String s = "AB";
		int n = 1;

		CaesarCipherEncoderSolution solver = new CaesarCipherEncoderSolution();
		String result = solver.solution(s, n);

		System.out.println(result);
	}
}

class CaesarCipherEncoderSolution {
	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			sb.append(push(c, n));
		}
		return sb.toString();
	}

	// 각 문자 c를 n만큼 밀기
	private char push(char c, int n) {
		// 문자가 알파벳이 아니면 그대로 반환
		if (!Character.isAlphabetic(c))
			return c;

		// c가 대문자인지 소문자인지 구별
		int base = Character.isUpperCase(c) ? 'A' : 'a';
		// 나머지만큼 더하고 A부터 Z까지의 개수로 나누기
		int position = (c - base + n) % ('Z' - 'A' + 1);

		return (char) (base + position);
	}
}