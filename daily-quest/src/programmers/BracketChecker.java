package programmers;

import java.util.Stack;

public class BracketChecker {
	public static void main(String[] args) {
		String s = "()()";

		BracketCheckerSolution solver = new BracketCheckerSolution();
		boolean result = solver.solution(s);

		System.out.println(result);
	}
}

class BracketCheckerSolution {
	public boolean solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			switch (c) {
				// 스택에 추가
				case '(' -> stack.push(c);
				case ')' -> {
					// 짝이 맞지 않으면 false 반환
					if (stack.empty())
						return false;
					// 스택에서 제거
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}
}