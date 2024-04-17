package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HanoiTowerSolver {
	public static void main(String args[]) {
		int n = 2;

		HanoiTowerSolverSolution solver = new HanoiTowerSolverSolution();
		int[][] result = solver.solution(n);

		for (int[] row : result)
			System.out.println(Arrays.toString(row));
	}
}

class HanoiTowerSolverSolution {
	private void hanoi(int n, int from, int to, List<int[]> process) {
		if (n == 1) {
			process.add(new int[] { from, to });
			return;
		}

		int empty = 6 - from - to;
		// 빈 기둥으로 이동
		hanoi(n - 1, from, empty, process);
		// from 기둥에서 to 기둥으로 이동
		hanoi(1, from, to, process);
		// empty 기둥에서 to 기둥으로 이동
		hanoi(n - 1, empty, to, process);
	}

	public int[][] solution(int n) {
		List<int[]> process = new ArrayList<>();
		hanoi(n, 1, 3, process);
		return process.toArray(new int[0][]);
	}
}