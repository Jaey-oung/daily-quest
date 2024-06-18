package programmers;

import java.util.Arrays;

public class FibonacciCalculator {
	public static void main(String[] args) {
		int n = 3;

		FibonacciCalculatorSolution solver = new FibonacciCalculatorSolution();
		int result = solver.solution(n);

		System.out.println(result);
	}
}

class FibonacciCalculatorSolution {
	private final int[] mem = new int[100001];

	private int fibo(int n) {
		// -1이 아니라면 계산된 값
		if (mem[n] != -1)
			return mem[n];

		// 피보나치 수열 첫 두 항은 0과 1
		if (n == 0 || n == 1)
			return n;

		return mem[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
	}

	public int solution(int n) {
		// 배열을 -1로 채우기
		Arrays.fill(mem, -1);

		for (int i = 0; i <= n; i++) {
			fibo(n);
		}
		return fibo(n);
	}
}