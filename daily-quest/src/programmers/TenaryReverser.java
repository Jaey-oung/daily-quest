package programmers;

public class TenaryReverser {
	public static void main(String args[]) {
		int n = 45;

		TenaryReverserSolution solver = new TenaryReverserSolution();
		int result = solver.solution(n);

		System.out.println(result);
	}
}

class TenaryReverserSolution {
	public int solution(int n) {
		// 3진법으로 변환
		String str = Integer.toString(n, 3);
		// 뒤집기
		String reversed = new StringBuilder(str).reverse().toString();
		// 10진법으로 변환
		return Integer.parseInt(reversed, 3);
	}
}