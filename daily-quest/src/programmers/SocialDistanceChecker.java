package programmers;

import java.util.Arrays;

public class SocialDistanceChecker {
	public static void main(String args[]) {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };

		SocialDistanceCheckerSolution solver = new SocialDistanceCheckerSolution();
		int[] result = solver.solution(places);

		System.out.println(Arrays.toString(result));
	}
}

class SocialDistanceCheckerSolution {
	// x와 y의 변화량 - 순서대로 위, 왼쪽, 오른쪽, 아래
	private static final int dx[] = { 0, -1, 1, 0 };
	private static final int dy[] = { -1, 0, 0, 1 };

	private boolean isDistanced(char[][] room) {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				// 사람이 없으면 스킵
				if (room[i][j] != 'P')
					continue;

				if (!isDistanced(room, j, i))
					return false;
			}
		}
		return true;
	}

	private boolean isDistanced(char[][] room, int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			// 범위를 벗어나지 않는지 확인
			if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
				continue;

			switch (room[ny][nx]) {
			case 'P':
				return false;

			// 비어 있는 공간이면 그 주변에 사람이 존재하는지 확인
			case 'O':
				if (isNextToPerson(room, nx, ny, 3 - d))
					return false;
				break;
			}
		}
		return true;
	}

	private boolean isNextToPerson(char[][] room, int x, int y, int exclude) {
		for (int d = 0; d < 4; d++) {
			// 시작 방향은 제외
			if (d == exclude)
				continue;

			int nx = x + dx[d];
			int ny = y + dy[d];

			// 범위를 벗어나지 않는지 확인
			if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
				continue;

			if (room[ny][nx] == 'P')
				return true;
		}
		return false;
	}

	public int[] solution(String[][] places) {
		int[] result = new int[places.length];

		for (int i = 0; i < result.length; i++) {
			String[] place = places[i];
			char[][] room = new char[place.length][];

			for (int j = 0; j < room.length; j++) {
				room[j] = place[j].toCharArray();
			}

			result[i] = isDistanced(room) ? 1 : 0;
		}
		return result;
	}
}