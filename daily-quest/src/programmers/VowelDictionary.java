package programmers;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {
	public static void main(String args[]) {
		String word = "AAAAE";

		VowelDictionarySolution solver = new VowelDictionarySolution();
		int result = solver.solution(word);

		System.out.println(result);
	}
}

class VowelDictionarySolution {
	private static final char[] VOWELS = { 'A', 'E', 'I', 'O', 'U' };

	private void generate(String word, List<String> words) {
		words.add(word);

		// 길이가 5일 때 종료
		if (word.length() == 5)
			return;

		for (char c : VOWELS)
			generate(word + c, words);
	}

	public int solution(String word) {
		List<String> words = new ArrayList<>();

		generate("", words);
		// 단어 리스트에서 몇 번째에 위치하는지 찾기
		return words.indexOf(word);
	}
}