public class Solution{
	public boolean wordBreak(String s, Set<String> dict){
		if(s == null || s.length() == 0) return true;
		boolean[] breakable = new boolean[s.length() + 1];
		breakable[0] = true;
		for(int i = 1; i <= s.length(); i++){	、
		// 之所以从1是因为下面的substring()
			for(int j = 0; j < i; j++){
				if(breakable[j] && dict.contains(s.substring(j, i))){
				// 因为j<i，所以用小于i的breakable数组来进行DP操作
				// 如果说breakable[j]是true，那只需要把剩下来的那部分字符从dict内进行寻找和匹配
					breakable[i] = true;
					break;
				}
			}
		}
		return breakable[s.length()];
	}
}