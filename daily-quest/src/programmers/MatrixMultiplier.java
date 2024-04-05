package programmers;

import java.util.Arrays;

public class MatrixMultiplier {
	public static void main(String args[]) {
		int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		int[][] arr2 = { { 3, 3 }, { 3, 3 } };

		MatrixMultiplierSolution solver = new MatrixMultiplierSolution();
		int[][] result = solver.solution(arr1, arr2);

		for (int[] row : result)
			System.out.println(Arrays.toString(row));
	}
}

class MatrixMultiplierSolution {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		// 행렬 곱셈 성립 조건 - 왼쪽 행렬의 열 개수와 오른쪽 행렬의 행 수가 같지 않으면 null 반환
		if (arr1[0].length != arr2.length)
			return null;

		// 결과 행렬은 왼쪽 행렬의 행 개수와 오른쪽 행렬의 열 개수를 갖음
		int[][] result = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = 0;

				for (int k = 0; k < arr1[i].length; k++) {
					result[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		return result;
	}
}