public class Solution{
	public int compareVersion(String version1, String version2){
		String[] a = version1.split("\\.");
		String[] b = version2.split("\\.");
		int length = Math.max(a.length, b.length);
		for(int i = 0; i < length; i++){
			int a1 = i < a.length ? Integer.parseInt(a[i]):0;
			int b1 = i < b.length ? Integer.parseInt(b[i]):0;
			if(a1 > b1){
				return 1;
			}else if(a1 < b1){
				return -1;
			}
		}
		return 0;
	}
}