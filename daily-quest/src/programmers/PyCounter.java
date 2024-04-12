package programmers;

public class PyCounter {
	public static void main(String args[]) {
		String s = "pPoooyY";

		PyCounterSolution solver = new PyCounterSolution();
		boolean result = solver.solution(s);

		System.out.println(result);
	}
}

class PyCounterSolution {
	public boolean solution(String s) {
		// 문자열 전체를 소문자로 변환
		s = s.toLowerCase();

		// 원본 문자열과 p 제거한 문자열의 길이 차이는 p의 개수와 동일
		int pCnt = s.length() - s.replace("p", "").length();
		// 원본 문자열과 y 제거한 문자열의 길이 차이는 y의 개수와 동일
		int yCnt = s.length() - s.replace("y", "").length();

		return pCnt == yCnt;
	}
}