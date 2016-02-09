public class Solution{
	public static String reverseWords(String s){
		if(s == null || s.length() == 0) return s;
		String[] res = s.split(" ");	// 将String分割成String数组
		if(res == null || res.length == 0) return "";

		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < res.length; i++){
			if(!res[i].isEmpty())
				list.add(res[i]);
		}
		Collections.reverse(list);	// 逆序输出

		String ans = new String();
		// 以下是为了添加空格
		for(int i = 0; i < list.size() - 1; i++){
			ans += list.get(i) + " ";
		}
		ans += list.get(list.size() - 1);
		return ans;
	}
}