public class Solution{
	public List<String> restoreIpAddresses(String s){
		List<String> ans = new ArrayList<String>();
		int len = s.length();
		for(int i = 1; i <= 3; i++){	// 第一段分割
			if(len - i > 9) continue;
			for(int j = i + 1; j <= i + 3; j++){	// 第二段分割
				if(len - j > 6) continue;
				for(int k = j + 1; k <= j + 3 && k < len; k++){		// 第三段分割
					int a, b, c, d;
					a = Integer.parseInt(s.substring(0, i));
					b = Integer.parseInt(s.substring(i, j));
					c = Integer.parseInt(s.substring(j, k));
					d = Integer.parseInt(s.substring(k));
					if(a > 255 || b > 255 || c > 255 || d > 255) continue;	
					// 因为每个1到3个的digit不能超过255，否则ip地址是无意义的
					String ip = a + "." + b + "." + c + "." + d;
					if(ip.length() < len + 3) continue;	
					// 使用string.substring的方法并不能过滤'00'以及'01'这类字符串，所以需要多加一个判断
					ans.add(ip);
				}
			}
		}
		return ans;
	}
}