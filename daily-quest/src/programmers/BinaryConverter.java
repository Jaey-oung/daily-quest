package programmers;

import java.util.Arrays;

public class BinaryConverter {
	public static void main(String args[]) {
		String s = "110010101001";

		BinaryConverterSolution solver = new BinaryConverterSolution();
		int[] result = solver.solution(s);

		System.out.println(Arrays.toString(result));
	}
}

class BinaryConverterSolution {
	private int cntZero(String s) {
		int count = 0;

		// s에 포함된 0 개수 세기
		for (char ch : s.toCharArray()) {
			if (ch == '0')
				count++;
		}
		return count;
	}

	public int[] solution(String s) {
		int loop = 0;
		int removed = 0;

		// s가 1이 될 때까지 반복
		while (!s.equals("1")) {
			int zeroCnt = cntZero(s);
			loop += 1;
			removed += zeroCnt;

			int oneCnt = s.length() - zeroCnt;
			// 1의 개수를 2진법으로 변환
			s = Integer.toString(oneCnt, 2);
		}
		return new int[] { loop, removed };
	}
}