package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FeatureDeploymentCalculator {
	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		FeatureDeploymentCalculatorSolution solver = new FeatureDeploymentCalculatorSolution();
		int[] result = solver.solution(progresses, speeds);

		System.out.println(Arrays.toString(result));
	}
}

class FeatureDeploymentCalculatorSolution {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> queue = new LinkedList<>();

		// 인덱스 저장
		for (int i = 0; i < progresses.length; i++) {
			queue.add(i);
		}

		List<Integer> result = new ArrayList<>();

		int days = 0;
		int count = 0;

		while (!queue.isEmpty()) {
			int index = queue.poll();
			// 기능 구현 완료되는 일수
			int expiration = (int) Math.ceil((double) (100 - progresses[index]) / speeds[index]);

			// 현재 작업이 이전 작업과 같이 종료되는지 확인
			if (expiration > days) {
				if (days != 0) {
					result.add(count);
					count = 0;
				}
				days = expiration;
			}
			count++;
		}
		result.add(count);

		// 배열로 변환하여 반환
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}