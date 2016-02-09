/*
	喜闻乐见的DFS
*/
public class Solution{
	List<List<String>> result = new ArrayList<List<String>>();
	public List<List<String>> partition(String s){
		helper(s, new ArrayList<String>());
		return result;
	}

	public void helper(String s, List<String> cur){
		if(s.length() == 0){
			result.add(cur); 
			return;
		}
		for(int i = 1; i <= s.length(); i++){
			String sub = s.substring(0, i);
			if(isPal(sub)){
				List<String> newList = new ArrayList<String>(cur);
				newList.add(sub);	// 添加是回文的左半部分被分割子字符串
				helper(s.substring(i, s.length()), newList);	
				// DFS，递归切割点右半部分的子字符串
				// 继承同一点切割先前的保存好的回文元素
			}
			else continue;	// 不是回文则无视
		}
	}

	public boolean isPal(String str){
		int l = 0;
		int r = str.length() - 1;
		while(l <= r){
			if(str.charAt(l) != str.charAt(r)) return false;
			l++; 
			r--;
		}
		return true;
	}
}