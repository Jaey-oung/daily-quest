package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ExpressionMaximizer {
	public static void main(String args[]) {
		String expression = "100-200*300-500+20";

		ExpressionMaximizerSolution solver = new ExpressionMaximizerSolution();
		long result = solver.solution(expression);

		System.out.println(result);
	}
}

class ExpressionMaximizerSolution {
	// 연산자 경우의 수
	private static final String[][] precedences = { "+-*".split(""), "+*-".split(""), "-+*".split(""), "-*+".split(""),
			"*+-".split(""), "*-+".split(""), };

	private long calculate(long left, long right, String op) {
		return switch (op) {
		case "+" -> left + right;
		case "-" -> left - right;
		case "*" -> left * right;
		default -> 0;
		};
	}

	private long calculate(List<String> tokens, String[] precedence) {
		for (String op : precedence) {
			for (int i = 0; i < tokens.size(); i++) {
				if (tokens.get(i).equals(op)) {
					long left = Long.parseLong(tokens.get(i - 1));
					long right = Long.parseLong(tokens.get(i + 1));
					long result = calculate(left, right, op);

					// 연산자와 양쪽의 숫자 삭제
					tokens.remove(i - 1);
					tokens.remove(i - 1);
					tokens.remove(i - 1);

					// 계산 결과 추가
					tokens.add(i - 1, String.valueOf(result));
					i -= 2;
				}
			}
		}
		return Long.parseLong(tokens.get(0));
	}

	public long solution(String expression) {
		// 연산자 기준으로 문자열 분리
		StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
		List<String> tokens = new ArrayList<>();

		// 토큰에 추가
		while (tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
		}

		long max = 0;

		for (String[] precedence : precedences) {
			long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));

			if (value > max) {
				max = value;
			}
		}
		return max;
	}
}