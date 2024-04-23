package programmers;

import java.util.HashSet;
import java.util.Set;

public class PrimeFinder {
	public static void main(String args[]) {
		String numbers = "17";

		PrimeFinderSolution solver = new PrimeFinderSolution();
		int result = solver.solution(numbers);

		System.out.println(result);
	}
}

class PrimeFinderSolution {
	private boolean isPrime(int n) {
		// 1보다 작으면 거짓
		if (n <= 1)
			return false;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	private void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
		// acc가 소수면 primes에 추가
		if (isPrime(acc))
			primes.add(acc);

		for (int i = 0; i < numbers.length; i++) {
			if (isUsed[i])
				continue;

			int nextAcc = acc * 10 + numbers[i];

			// 사용 전
			isUsed[i] = true;
			getPrimes(nextAcc, numbers, isUsed, primes);
			// 사용 후
			isUsed[i] = false;
		}
	}

	public int solution(String nums) {
		Set<Integer> primes = new HashSet<>();
		// 각 문자를 숫자로 변환 후 배열에 포함
		int[] numbers = nums.chars().map(c -> c - '0').toArray();

		getPrimes(0, numbers, new boolean[numbers.length], primes);
		return primes.size();
	}
}