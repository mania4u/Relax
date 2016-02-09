/*
	minStack用于存储每次push的最小值，stack在存储所有的值
	minStack因为条件的限制，push的值应该是一个比一个小，递减的关系，所以getMin里直接minStack.peek()便能直接得到最小值
	pop()，stack正常pop(),minStack则是每个最小值有变化进行pop()
*/

class MinStack{
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public void push(int x){
		if(minStack.isEmpty() || x<=minStack.peek())	
			minStack.push(x);
		stack.push(x);
	}

	public void pop(){
		if(stack.peek().equals(minStack.peek()))
			minStack.pop();
		stack.pop();
	}

	public int top(){
		return stack.peek();
	}

	public int getMin(){
		return minStack.peek();
	}
}