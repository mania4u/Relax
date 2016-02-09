public class Solution{
	public static boolean isValid(String s){
		HashMap<Character, Character> map = new HashMap<Character, Character>();

		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<Character>();

		for(int i =0; i < s.length(); i++){		
			char curr = s.charAt(i);

			if(map.keySet().contains(curr)){	
			// if character is in the "KEY" set, push the character into the stack
				stack.push(curr);
			}else if(map.values().contains(curr)){	
			// check whether the character is in the "VALUES" set
				if(!stack.empty() && map.get(stack.peek()) == curr){	
				// 1. if the stack is not empty; 2. stack.peek() is the top one of the stack and use map.get() for checking whether the pair of key and value is correct
					stack.pop();
				}else{
					return false;
				}
			}
		}
		return stack.empty();
	}
}