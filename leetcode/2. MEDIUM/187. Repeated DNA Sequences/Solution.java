/*
	用hashmap记录字母的值，用两个hashset保存记录下的hash值
	hash值是唯一的
*/

public class Solution{
	public List<String> findRepeatedDnaSequences(String s){
		List<String> res = new ArrayList<String>();
		if(s == null || s.length() < 11) return res;

		// 因为就A,C,G,T，所以为每个字母预设一个值
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> unique = new HashSet<Integer>();
		int hash = 0;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(i < 9){		// 前9次，向左平移并加上hashmap保存的字母的值
				hash = (hash << 2) + map.get(c);
			}else{
				hash = (hash << 2) + map.get(c);
				hash &= (1 << 20) - 1;	
				// 平移20位是因为字母保存的值是两位，一共要选取10个字符，所以是20位
				if(set.contains(hash) && !unique.contains(hash)){
				// set用来记录先前每次循环保存好的20位的唯一hash值
				// unique是用来防重复
					res.add(s.substring(i - 9, i + 1));
					unique.add(hash);
				}else{
					set.add(hash);
				}
			}
		}
		return res;
	}
}