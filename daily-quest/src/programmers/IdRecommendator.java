package programmers;

public class IdRecommendator {
	public static void main(String args[]) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";

		IdRecommendatorSolution solver = new IdRecommendatorSolution();
		String result = solver.solution(new_id);
		System.out.println(result);
	}
}

class IdRecommendatorSolution {
	public String solution(String newId) {
		// 모든 대문자를 소문자로 변환
		newId = newId.toLowerCase();

		// 알파벳 소문자, 숫자, -, _, . 만 사용 가능
		newId = newId.replaceAll("[^a-z0-9\\-_.]", "");

		// .이 연속된 부분은 하나의 .으로 변환
		newId = newId.replaceAll("\\.+", ".");

		// .이 처음이나 끝에 있다면 삭제
		newId = newId.replaceAll("^\\.+|\\.+$", "");

		// 빈 문자열이라면 a 대입
		if (newId.isEmpty())
			newId = "a";

		// 길이가 16자 이상이라면 15개의 문자만 유지
		if (newId.length() >= 16) {
			newId = newId.substring(0, 15);
			// 제거 후 .이 마지막에 위치한다면 .삭제
			newId = newId.replaceAll("\\.+$", "");
		}

		// 길이가 2자 이하면 길이가 3이 될 때까지 마지막 문자를 반복
		while (newId.length() <= 2) {
			newId += newId.charAt(newId.length() - 1);
		}

		return newId;
	}
}