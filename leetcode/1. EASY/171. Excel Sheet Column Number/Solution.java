public class Solution{
	public int titleToNumber(String s){
		int colNumber = 0;
		for(int i = 0; i < s.length(); i++){
			colNumber = colNumber * 26 + ((int)s.charAt(i) - 64);		
			// 大写"A"的ASCII码为65
		}
		return colNumber;
	}
}