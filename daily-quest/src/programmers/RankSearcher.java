package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class RankSearcher {
	public static void main(String args[]) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };

		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		RankSearcherSolution solver = new RankSearcherSolution();
		int[] result = solver.solution(info, query);

		System.out.println(Arrays.toString(result));
	}
}

class RankSearcherSolution {
	private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
		// 조건이 완성되었을 때
		if (index == tokens.length - 1) {
			action.accept(prefix);
			return;
		}

		// -가 들어가지 않을 때
		forEachKey(index + 1, prefix + tokens[index], tokens, action);
		// -가 들어갈 때
		forEachKey(index + 1, prefix + "-", tokens, action);
	}

	private Map<String, List<Integer>> buildScoresMap(String[] info) {
		Map<String, List<Integer>> scoresMap = new HashMap<>();

		for (String s : info) {
			// 빈칸을 기준으로 잡아서 토큰으로 나누기
			String[] tokens = s.split(" ");
			// 마지막 토큰이 점수
			int score = Integer.parseInt(tokens[tokens.length - 1]);

			forEachKey(0, "", tokens, key -> {
				// 조건이 없으면 해당 조건에 대한 키 추가
				scoresMap.putIfAbsent(key, new ArrayList<>());
				scoresMap.get(key).add(score);
			});
		}

		// scoresMap의 값 정렬하기
		for (List<Integer> list : scoresMap.values()) {
			Collections.sort(list);
		}

		return scoresMap;
	}

	private int binarySearch(int score, List<Integer> scores) {
		int start = 0;
		int end = scores.size() - 1;

		while (end > start) {
			int mid = (start + end) / 2;

			if (scores.get(mid) >= score) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		// score가 scores에 있는 모든 점수보다 클 때 scores의 길이 반환
		if (scores.get(start) < score) {
			return scores.size();
		}

		return start;
	}

	private int count(String query, Map<String, List<Integer>> scoresMap) {
		// And를 기준으로 잡아서 토큰으로 나누기
		String[] tokens = query.split(" (and )?");
		// 점수 제외하고 문자열으로 변환
		String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

		// 조건이 존재하지 않으면 0 봔환
		if (!scoresMap.containsKey(key))
			return 0;

		List<Integer> scores = scoresMap.get(key);

		int score = Integer.parseInt(tokens[tokens.length - 1]);

		return scores.size() - binarySearch(score, scoresMap.get(key));
	}

	public int[] solution(String[] info, String[] query) {
		Map<String, List<Integer>> scoresMap = buildScoresMap(info);

		int[] answer = new int[query.length];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = count(query[i], scoresMap);
		}

		return answer;
	}
}