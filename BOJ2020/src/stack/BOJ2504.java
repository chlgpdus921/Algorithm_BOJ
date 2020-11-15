package stack;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ2504.java
 * @author chlgpdus921
 * @date 2020. 11. 9.
 */
/* 괄호의 값 */
public class BOJ2504 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine(); // ( ( ) [ [ ] ] ) ( [ ] )
		Stack<String> stack = new Stack<>();

		long result = 0;
		int temp = 1;
		boolean check = false;

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(') {
				temp *= 2;
				stack.push("(");
			} else if (s.charAt(i) == '[') {
				temp *= 3;
				stack.push("[");
			} else if (s.charAt(i) == ')' && (stack.empty() || !stack.peek().equals("("))) {
				check = true;
				break;
			} else if (s.charAt(i) == ']' && (stack.empty() || !stack.peek().equals("["))) {
				check = true;
				break;
			} else if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(')
					result += temp;
				stack.pop();
				temp /= 2;
			} else if (s.charAt(i) == ']') {
				if (s.charAt(i - 1) == '[')
					result += temp;
				stack.pop();
				temp /= 3;
			}
		}

		if (check || !stack.empty()) {
			System.out.println("0");
		} else
			System.out.println(result);
	}
}
