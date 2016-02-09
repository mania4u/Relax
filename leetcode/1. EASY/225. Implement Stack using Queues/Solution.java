class MyStack{
	Queue<Integer> q = new LinkedList<Integer>();
	
	public void push(int x){
		q.add(x);
	}

	public void pop(){
		int size = q.size();
		for(int i = 1; i < size; i++){
			q.add(q.remove());
		}
		q.remove();
	}

	public int top(){
		int size = q.size();
		for(int i = 1; i < size; i++){
			q.add(q.remove());
		}
		int ret = q.remove();
		q.add(ret);
		return ret;
	}

	public boolean empty(){
		return q.isEmpty();
	}
}