public class Solution{
	public boolean isIsomorphic(String s, String t){
		Map<Character, Character> corr = new HashMap<Character, Character>();
		for(int i = 0; i < s.length(); i++){
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			if(corr.containsKey(sc)){
				if(corr.get(sc) != tc){	// 比对映射值
					return false;
				}
			}else{
				if(corr.containsValue(tc)){
				// 会出现aa和ab这样的错，因为ismorphic对应的字幕不能相同
					return false;
				}else{
					corr.put(sc, tc);
				}
			}
		}
		return true;
 	}
}