package programmers;

import java.util.Stack;

public class BracketRotator {
	public static void main(String[] args) {
		String s = "[](){}";
		
		BracketRotatorSolution solver = new BracketRotatorSolution();
		int result = solver.solution(s);
		
		System.out.println(result);
	}
}

class BracketRotatorSolution {
	private boolean isCorrect(char[] str, int offset) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            char c = str[(i + offset) % str.length];
            
            switch (c) {
            	// 여는 괄호일 경우
            	// 스택에 추가
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                
                // 닫는 괄호일 경우
                case ')', '}', ']' -> {
                	// 스택이 비어 있을 경우
                    if (stack.isEmpty())
                    	return false;
                    
                    // 짝이 맞지 않을 경우
                    if (stack.pop() != c)
                    	return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public int solution(String s) {
        char[] str = s.toCharArray();

        int count = 0;
        
        for (int offset = 0; offset < str.length; offset++) {
            if (isCorrect(str, offset)) {
                count++;
            }
        }
        return count;
    }
}