package programmers;

public class ImmigrationChecker {
	public static void main(String[] args) {
		int n = 6;
		int[] times = { 7, 10 };

		ImmigrationCheckerSolution solver = new ImmigrationCheckerSolution();
		long result = solver.solution(n, times);

		System.out.println(result);
	}
}

class ImmigrationCheckerSolution {
	private boolean isValid(long t, int n, int[] times) {
		long c = 0;

		for (int time : times) {
			// 모든 심사대가 처리 가능한 사람 수 구하기
			c += t / time;
		}
		return c >= n;
	}

	public long solution(int n, int[] times) {
		// 최솟값 = 바로 심사 받을 경우
		long start = 0;
		// 최댓값 = 1,000,000,000 명 x 1,000,000,000 분
		long end = 1000000000000000000L;

		while (end > start) {
			long t = (start + end) / 2;

			if (isValid(t, n, times)) {
				end = t;
			} else {
				start = t + 1;
			}
		}
		return start;
	}
}