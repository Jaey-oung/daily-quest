package programmers;

import java.util.Arrays;

public class IntegerArrayConverter {
	public static void main(String args[]) {
		long n = 12345;

		IntegerArrayConverterSolution solver = new IntegerArrayConverterSolution();
		int[] result = solver.solution(n);

		System.out.println(Arrays.toString(result));
	}
}

class IntegerArrayConverterSolution {
	public int[] solution(long n) {
		// Long을 String으로 변환
		String str = Long.toString(n);
		// 뒤집기
		String reversed = new StringBuilder(str).reverse().toString();
		// String을 char 배열로 변환
		char[] chArr = reversed.toCharArray();

		int[] result = new int[chArr.length];

		// char 배열의 요소들에서 '0'을 빼서 숫자로 변환
		for (int i = 0; i < result.length; i++) {
			result[i] = chArr[i] - '0';
		}
		return result;
	}
}
