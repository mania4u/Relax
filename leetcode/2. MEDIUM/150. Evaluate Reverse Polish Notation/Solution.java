public class Solution{
	public static int evalRPN(String[] tokens){
		if(tokens == null || tokens.length == 0) return 0;
		int ans = 0;
		Stack<Integer> res = new Stack<Integer>();
		for(int i = 0; i < tokens.length; i++){
			ans = 0;
			if(tokens[i].equals("/") || tokens[i].equals("*")
			|| tokens[i].equals("-") || tokens[i].equals("+")){
				int b = res.pop();
				int a = res.pop();
				if(tokens[i].equals("/"))
					ans += a / b;
				else if(tokens[i].equals("*"))
					ans += a * b;
				else if(tokens[i].equals("-"))
					ans += a - b;
				else if(tokens[i].equals("+"))
					ans += a + b;
				res.push(ans);
			}else{
				res.push(Integer.parseInt(tokens[i]));
			}
		}
		return res.pop();
	}
}