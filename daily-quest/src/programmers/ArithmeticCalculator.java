package programmers;

import java.util.Arrays;

public class ArithmeticCalculator {
	public static void main(String[] args) {
		String[] arr = { "1", "-", "3", "+", "5", "-", "8" };

		ArithmeticCalculatorSolution solver = new ArithmeticCalculatorSolution();
		int result = solver.solution(arr);

		System.out.println(result);
	}
}

class ArithmeticCalculatorSolution {
	private final int[][] maxMem = new int[202][202];
	private final int[][] minMem = new int[202][202];

	private int max(int start, int end, String[] arr) {
		// 계산된 값 반환
		if (maxMem[start][end] != Integer.MIN_VALUE) {
			return maxMem[start][end];
		}

		// arr에 1개의 숫자만 포함되어 있다면 해당 숫자 봔환
		if (end - start == 1)
			return Integer.parseInt(arr[start]);

		int max = Integer.MIN_VALUE;

		for (int i = start + 1; i < end; i += 2) {
			int l = max(start, i, arr);
			int v;

			if (arr[i].equals("+")) { // 최댓값 + 최댓값
				int r = max(i + 1, end, arr);
				v = l + r;
			} else { // 최댓값 - 최솟값
				int r = min(i + 1, end, arr);
				v = l - r;
			}

			if (v > max)
				max = v;
		}
		return maxMem[start][end] = max;
	}

	private int min(int start, int end, String[] arr) {
		// 계산된 값 반환
		if (minMem[start][end] != Integer.MIN_VALUE) {
			return minMem[start][end];
		}

		// arr에 1개의 숫자만 포함되어 있다면 해당 숫자 봔환
		if (end - start == 1)
			return Integer.parseInt(arr[start]);

		int min = Integer.MAX_VALUE;

		for (int i = start + 1; i < end; i += 2) {
			int l = min(start, i, arr);
			int v;

			if (arr[i].equals("+")) { // 최솟값 + 최솟값
				int r = min(i + 1, end, arr);
				v = l + r;
			} else { // // 최솟값 - 최댓값
				int r = max(i + 1, end, arr);
				v = l - r;
			}

			if (v < min)
				min = v;
		}
		return minMem[start][end] = min;
	}

	public int solution(String[] arr) {
		// maxMem 와 minMem 을 가장 작은 값으로 채우기
		for (int[] row : maxMem) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}

		for (int[] row : minMem) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}

		return max(0, arr.length, arr);
	}
}