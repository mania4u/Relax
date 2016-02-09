public class Solution{
    public String countAndSay(int n) {
		if (n <= 0) {		// index
			return null;
		}
		String s = "1";		// initiation of the string
		int num = 1;		// used to express how many character 
		for (int j = 0; j < n - 1; j++) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
				// scan the string and num++ when the former and the latter characters are the same
					num++;
				} else {
					sb.append(num + "" + s.charAt(i));	// output the pair: num + character
					num = 1;
				}
			}
			s = sb.toString();	// change StringBuilder to String
		}
		return s;
	}
}
