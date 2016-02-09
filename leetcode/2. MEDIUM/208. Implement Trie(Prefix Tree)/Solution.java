// 参考资料：http://www.cnblogs.com/huangxincheng/archive/2012/11/25/2788268.html

public class Trie{
	private TrieNode root;
	public Trie(){
		root = new TrieNode();
	}

	public void insert(String word){
		if(word != null){
			TrieNode temp = root;
			for(int i = 0; i < word.length(); i++){
				char c = word.charAt(i);
				if(temp.next[c - 97] == null){
					temp.next[c - 97] = new TrieNode();
				}
				temp = temp.next[c - 97];
			}
			temp.endPoint = true;
		}
	}

	public boolean search(String word){
		if(word == null) return false;
		TrieNode temp = root;
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if(temp.next[c - 97] == null)
				return false;
			else temp = temp.next[c - 97];
		}
		if(temp.endPoint) return true;
		else return false;
	}

	public boolean startsWith(String prefix){
		if(prefix == null) return false;
		TrieNode temp = root;
		for(int i = 0; i < prefix.length(); i++){
			char c = prefix.charAt(i);
			if(temp.next[c - 97] == null) return false;
			else temp = temp.next[c - 97];
		}
		return true;
	}

	protected class TrieNode{
		public boolean endPoint;
		public TrieNode[] next;
		public TrieNode(){
			endPoint = false;
			next = new TrieNode[26];
		}
	}
}