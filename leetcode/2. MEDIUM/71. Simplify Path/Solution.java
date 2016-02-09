public class Solution{
	public String simplifyPath(String path){
		Deque<String> stack = new LinkedList<>();
		Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
		for(String dir : path.split("/")){
			if(dir.equals("..") && !stack.isEmpty()) stack.pop();	// 去除重复的"/"
			else if(!skip.contains(dir)) stack.push(dir);	// 去除重复的"..", ".", ""
		}
		String res = "";
		for(String dir : stack) res = "/" + dir + res;
		return res.isEmpty() ? "/" : res;	
	}
}