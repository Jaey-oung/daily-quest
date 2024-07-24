package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TruckOnTheBridge {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };

		TruckOnTheBridgeSolution solver = new TruckOnTheBridgeSolution();
		int result = solver.solution(bridge_length, weight, truck_weights);

		System.out.println(result);
	}
}

class TruckOnTheBridgeSolution {
	public int solution(int bridgeLength, int weight, int[] truckWeights) {
		int bridgeWeight = 0;
		Queue<Integer> bridge = new LinkedList<>();

		// 다리가 비어있는 것을 0으로 나타냄
		for (int i = 0; i < bridgeLength; i++) {
			bridge.add(0);
		}

		int time = 0;
		int truckIndex = 0;

		// 모든 트럭이 다리를 건널 때까지
		while (truckIndex < truckWeights.length) {
			bridgeWeight -= bridge.poll();

			int truckWeight = truckWeights[truckIndex];

			// 다리가 트럭의 무게를 견딜 경우
			if (bridgeWeight + truckWeight <= weight) {
				bridge.add(truckWeight);
				bridgeWeight += truckWeight;
				truckIndex++;
			} else {
				bridge.add(0);
			}

			time++;
		}

		// 남아 있는 트럭이 있는 경우
		while (bridgeWeight > 0) {
			bridgeWeight -= bridge.poll();
			time++;
		}

		return time;
	}
}