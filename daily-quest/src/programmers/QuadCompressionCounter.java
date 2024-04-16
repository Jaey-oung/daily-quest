package programmers;

import java.util.Arrays;

public class QuadCompressionCounter {
	public static void main(String args[]) {
		int[][] arr = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };

		QuadCompressionCounterSolution solver = new QuadCompressionCounterSolution();
		int[] result = solver.solution(arr);

		System.out.println(Arrays.toString(result));
	}
}

class QuadCompressionCounterSolution {
	private static class Count {
		private final int zero;
		private final int one;

		public Count(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}

		public Count add(Count other) {
			return new Count(zero + other.zero, one + other.one);
		}
	}

	private Count count(int offsetX, int offsetY, int size, int[][] arr) {
		int h = size / 2;

		// 작은 정사각형 4개의 결과 값 더하기
		for (int x = offsetX; x < offsetX + size; x++) {
			for (int y = offsetY; y < offsetY + size; y++) {
				if (arr[y][x] != arr[offsetY][offsetX]) {
					return count(offsetX, offsetY, h, arr).add(count(offsetX + h, offsetY, h, arr))
							.add(count(offsetX, offsetY + h, h, arr)).add(count(offsetX + h, offsetY + h, h, arr));
				}
			}
		}

		// 같은 원소를 가질 때
		if (arr[offsetY][offsetX] == 1) {
			return new Count(0, 1);
		}
		return new Count(1, 0);
	}

	public int[] solution(int[][] arr) {
		Count cnt = count(0, 0, arr.length, arr);

		return new int[] { cnt.zero, cnt.one };
	}
}