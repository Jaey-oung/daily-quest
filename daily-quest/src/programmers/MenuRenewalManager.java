package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MenuRenewalManager {
	public static void main(String args[]) {
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };

		MenuRenewalManagerSolution solver = new MenuRenewalManagerSolution();
		String[] result = solver.solution(orders, course);

		System.out.println(Arrays.toString(result));
	}
}

class MenuRenewalManagerSolution {
	private static class Course {
		public final String course;
		public final int occurrences;

		public Course(String course, int occurrences) {
			this.course = course;
			this.occurrences = occurrences;
		}
	}

	private void getCourses(char nextMenu, Set<String> selectedMenus, List<Set<String>> orderList, Map<Integer, List<Course>> courses) {
		// 주문한 메뉴의 횟수 구하기
		int occurrences = (int) orderList.stream()
										.filter(order -> order.containsAll(selectedMenus))
										.count();
		
		// 메뉴 주문 횟수가 2번 미만이면 코스에 포함되지 않음
		if (occurrences < 2)
			return;

		int size = selectedMenus.size();

		if (courses.containsKey(size)) {
			List<Course> courseList = courses.get(size);
			// 알파벳 순으로 정렬
			Course course = new Course(selectedMenus.stream().sorted().collect(Collectors.joining("")), occurrences);

			Course original = courseList.get(0);

			if (original.occurrences < occurrences) {
				courseList.clear();
				courseList.add(course);
			} else if (original.occurrences == occurrences) {
				courseList.add(course);
			}
		}
		
		// 코스 메뉴 개수가 10개 이상 될 수 없음
		if (size >= 10)
			return;

		for (char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
			String menu = String.valueOf(menuChar);
			selectedMenus.add(menu);
			getCourses((char) (menuChar + 1), selectedMenus, orderList, courses);
			selectedMenus.remove(menu);
		}
	}

	public String[] solution(String[] orders, int[] course) {
		List<Set<String>> orderList = Arrays.stream(orders)
										.map(String::chars)
										.map(charStream -> charStream.mapToObj(menu -> String.valueOf((char) menu))
										.collect(Collectors.toSet()))
										.collect(Collectors.toList());

		Map<Integer, List<Course>> courses = new HashMap<>();

		for (int length : course) {
			List<Course> list = new ArrayList<>();
			list.add(new Course("", 0));
			courses.put(length, list);
		}

		getCourses('A', new HashSet<>(), orderList, courses);

		return courses.values().stream()
				.filter(list -> list.get(0).occurrences > 0)
				.flatMap(List::stream)
				.map(c -> c.course)
				.sorted()
				.toArray(String[]::new);
	}
}