// 每次操作number都清零

public class Solution{
	public int calculate(String s){
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		int number = 0;
		int sign = 1;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				number = 10 * number + (int)(c - '0');
				// 用来计算多位数
			}else if(c == '+'){
				result += sign * number;
				number = 0;
				sign = 1;
			}else if(c == '-'){
				result += sign * number;
				number = 0;
				sign = -1;
			}else if(c == '('){
				stack.push(result);
				stack.push(sign);
				sign = 1;
				result = 0;
			}else if(c == ')'){
				result += sign * number;
				number = 0;
				result *= stack.pop();	// 括号前的符号
				result += stack.pop();	// 加的是括号前的那个值
			}	
		}
		if(number != 0) result += sign * number;	// 这是单独就输入一个数字的情况
		return result;
	}
}