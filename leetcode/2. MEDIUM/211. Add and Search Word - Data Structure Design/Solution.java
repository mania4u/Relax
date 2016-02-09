public class WordDictionary{
	Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
	public void addWord(String word){
		int index = word.length();
		if(!map.containsKey(index)){
			List<String> list = new ArrayList<String>();
			list.add(word);
			map.put(index, list);
		}else
			map.get(index).add(word);
	}

	public boolean search(String word){
		int index = word.length();
		if(!map.containsKey(index)) return false;
		List<String> list = map.get(index);
		if(isWords(word))	
		// 若要搜的那个词在hash表保存的list内，直接用contains()查找
			return list.contains(word);
		for(String s : list){	// 逐位比较
			if(isSame(s, word))
				return true;
		}
		return false;
	}

	boolean isWords(String s){
		for(int i = 0; i < s.length(); i++){
			if(!Character.isLetter(s.charAt(i))) 
				return false;
		}
		return true;
	}

	boolean isSame(String s, String search){
		if(s.length() != search.length())
			return false;
		for(int i = 0; i < s.length(); i++){
			if(search.charAt(i) != '.' && search.charAt(i) != s.charAt(i))
				return false;
		}
		return true;
	}
}