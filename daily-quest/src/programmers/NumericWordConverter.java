package programmers;

public class NumericWordConverter {
	public static void main(String args[]) {
		String s = "one4seveneight";

		NumericWordConverterSolution solver = new NumericWordConverterSolution();
		int result = solver.solution(s);

		System.out.println(result);
	}
}

class NumericWordConverterSolution {
	private static final String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine" };

	public int solution(String s) {
		for (int i = 0; i < numbers.length; i++)
			// 각 영단어와 맞는 인덱스 값으로 변환
			s = s.replace(numbers[i], Integer.toString(i));

		// 문자열을 정수로 변환
		return Integer.parseInt(s);
	}
}