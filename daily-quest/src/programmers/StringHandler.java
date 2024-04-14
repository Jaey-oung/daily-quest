package programmers;

public class StringHandler {
	public static void main(String args[]) {
		String s = "1234";

		StringHandlerSolution solver = new StringHandlerSolution();
		boolean result = solver.solution(s);

		System.out.println(result);
	}
}

class StringHandlerSolution {
	public boolean solution(String s) {
		// 숫자로 이루어져 있고 길이가 4 또는 6인 문자열인지 확인
		return s.matches("[0-9]{4}|[0-9]{6}");
	}
}