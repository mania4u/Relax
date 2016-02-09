// 这种解法的好处是尽量减少了无意义了的扫描，而且思路清晰简单

public class Solution{
	public int countPrimes(int n){
		int res = 0;
		boolean[] a = new boolean[n];
		for(int i = 2; i * i < n; i++){	
		// 不必全部都scan，scan到最大能平方的数即可
			if(!a[i]){
				for(int j = i; i * j < n; j++){
				// 在n范围内，给定i，然后j递增，并赋值true给相对应的array
					a[i * j] = true;
				}
			}
		}
		for(int i = 2; i < n; i++){		// 利用布尔数组统计质数的数量
			if(a[i] == false) ++res;
		}
		return res;
	}
}