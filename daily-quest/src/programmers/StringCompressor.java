package programmers;

import java.util.ArrayList;
import java.util.List;

public class StringCompressor {
	public static void main(String args[]) {
		String s = "aabbaccc";

		StringCompressorSolution solver = new StringCompressorSolution();
		int result = solver.solution(s);

		System.out.println(result);
	}
}

class StringCompressorSolution {
	private List<String> split(String s, int length) {
		List<String> tokens = new ArrayList<>();

		for (int start = 0; start < s.length(); start += length) {
			int end = start + length;

			// 마지막 인덱스는 문자열의 길이보다 작거나 같아야 함
			if (end > s.length())
				end = s.length();

			tokens.add(s.substring(start, end));
		}
		return tokens;
	}

	private int compress(String s, int length) {
		StringBuilder sb = new StringBuilder();

		String last = "";
		int count = 0;

		for (String token : split(s, length)) {
			if (token.equals(last)) {
				count++;
			} else {
				if (count > 1)
					sb.append(count);
				sb.append(last);
				last = token;
				count = 1;
			}
		}

		// 마지막 토큰도 추가
		if (count > 1)
			sb.append(count);
		sb.append(last);

		return sb.length();
	}

	public int solution(String s) {
		int min = Integer.MAX_VALUE;

		for (int length = 1; length <= s.length(); length++) {
			int compressed = compress(s, length);

			if (compressed < min)
				min = compressed;
		}
		return min;
	}
}