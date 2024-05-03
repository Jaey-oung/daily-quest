package programmers;

public class StringDescendingSorter {
	public static void main(String args[]) {
		String s = "Zbcdefg";

		StringDescendingSorterSolution solver = new StringDescendingSorterSolution();
		String result = solver.solution(s);

		System.out.println(result);
	}
}

class StringDescendingSorterSolution {
	public String solution(String s) {
		// 문자열을 IntStream으로 변환
		return s.chars()
				// IntStream에서 Stream<Integer> 으로 변환 후 내림차순 정렬
				.boxed().sorted((v1, v2) -> v2 - v1)
				// supplier - 새로운 StringBuilder 객체로 반환
				// accumulator - 문자 형식으로 Stream 원소 누적
				// combiner - 합치기
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}
}