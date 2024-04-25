package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InvalidUserDetector {
	public static void main(String args[]) {
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "abc1**" };

		InvalidUserDetectorSolution solver = new InvalidUserDetectorSolution();
		int result = solver.solution(user_id, banned_id);

		System.out.println(result);
	}
}

class InvalidUserDetectorSolution {
	private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
		if (index == bans.length) {
			banSet.add(new HashSet<>(banned));
			return;
		}

		for (String id : bans[index]) {
			if (banned.contains(id))
				continue;

			// 벤 추가
			banned.add(id);
			count(index + 1, banned, bans, banSet);
			// 벤 삭제
			banned.remove(id);
		}
	}

	public int solution(String[] user_id, String[] banned_id) {
		String[][] bans = Arrays.stream(banned_id)
				// 정규 표현식에서 .은 임의의 한 문자
				.map(banned -> banned.replace('*', '.'))
				.map(banned -> Arrays.stream(user_id).filter(id -> id.matches(banned)).toArray(String[]::new))
				.toArray(String[][]::new);

		Set<Set<String>> banSet = new HashSet<>();
		count(0, new HashSet<>(), bans, banSet);

		return banSet.size();
	}
}