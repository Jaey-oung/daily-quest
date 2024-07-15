package programmers;

import java.util.Arrays;
import java.util.Stack;

public class StockPriceDurationChecker {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		
		StockPriceDurationCheckerSolution solver = new StockPriceDurationCheckerSolution();
		int[] result = solver.solution(prices);
		
		System.out.println(Arrays.toString(result));
	}
}

class StockPriceDurationCheckerSolution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
        	// 스택이 비어있지 않고
        	// 스택의 마지막 인덱스에 위치한 가격이 현재 가격보다 높을 경우
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);
        }
        
        // 스택에 남아 있는 인덱스 처리
        while (!stack.isEmpty()) {
            int index = stack.pop();
            
            answer[index] = prices.length - index - 1;
        }
        return answer;
    }
}