/*
	思路是，用哈希表存储记录过的值，计算两个出现过重复字母之间的长度
	具体实现，假如出现了一个字符“a”，判断上一次“a”的的位置，并更新“a”的最新位置
	i-y+1即是每次计算的长度，并与之前记录下的max进行比较，这样便能得到最大长度
*/
public class Solution{
	public int lengthOfLongestSubstring(String s){
		if(s.length() == 0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for(int i = 0, j = 0; i < s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
}