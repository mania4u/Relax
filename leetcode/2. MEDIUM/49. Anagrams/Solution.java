public class Solution{
	public List<String> anagrams(String[] strs){
		if(strs == null || strs.length == 0)
			return new LinkedList<String>();
		List<String> results = new LinkedList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();

		for(int i = 0; i < strs.length; i++){
			char[] array = strs[i].toCharArray();
			Arrays.sort(array);	// 精髓，这样就能无视顺序直接比对
			String s = new String(array);
			if(map.containsKey(s)){
				results.add(strs[i]);
				if(map.get(s) >= 0){
					results.add(strs[map.get(s)]);
					map.put(s, -1);
				}	
			// 上面这个循环是用来追回所有anagrams中第一个用来比对的字符串
			// 加上map.put(s, -1)，这样就不会重复添加这第一个字符串
			}else map.put(s, i);
		}
		return results;
	}
}