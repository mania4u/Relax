/*
	编辑距离是指两个字符串之间通过字符改变，达到相同所需要的步数
	题目：Given two strings S and T, determine if they are both "one" edit distance apart
*/
	
public class Solution{
	public boolean isOneEditDistance(String s, String t){
		int m = s.length();
		int n = t.length();
		if(m > n) return isOneEditDistance(t, s);
		if(m == n){
			int count = 0;
			for(int i = 0; i < n; i++){
				if(s.charAt(i) != t.charAt(i)){
					count++;
				}
			}
			return count == 1;
		}else if(m == n - 1){
			int count = 0;
			int i = 0;
			while(i < m){
				if(s.charAt(i) != t.charAt(i)){
					return s.substring(i, m).equals(t.substring(i + 1, n));
				}
				i++;
			}
			return true;
		}
		return false;
	}
}