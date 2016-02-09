public class Solution{
	public int ladderLength(String start, String end, Set<String> dict){
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		set1.add(start);
		set2.add(end);
		return helper(dict, set1, set2, 1);
	}

	public int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level){
		if(set1.isEmpty()) return 0;
		if(set1.size() > set2.size()) return helper(dict, set2, set1, level);
		// 因为根据下面递归helper(dict, set2, set, level+1)，set是所有符合标准的替换集合
		// 所以很有可能有很多种组合，这样会造成for(String str : set1)的这个循环
		// 由n^2上升成n^3，所以加一个这个设置能速度
		for(String word : set1){	// 去除dict中和start一样的word
			dict.remove(word);
		}
		for(String word : set2){	// 去除dict中和end一样的word
			dict.remove(word);
		}
		Set<String> set = new HashSet<String>();
		for(String str : set1){
			for(int i = 0; i < str.length(); i++){	// 扫描start的每个字母
				char[] chars = str.toCharArray();
				for(char ch = 'a'; ch <= 'z'; ch++){
					chars[i] = ch;		// 逐个更换每一位的字母
					String word = new String(chars);	// 将数组重新组合一个string 
					if(set2.contains(word)){	// 并使用hash进行判断
						return level + 1;
					}
					if(dict.contains(word)){	// 如果说更换的值存在于dict中，则添加到新的set用来递归
						set.add(word);
					}
				}
			}
		}
		return helper(dict, set2, set, level + 1);	// 注意这边start是set2，end是set
	}
}