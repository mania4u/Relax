/*
	如果数组为空，毫无疑问，只有一种BST，即空树，
    Count[0] =1
    如果数组仅有一个元素{1}，只有一种BST，单个节点
    Count[1] = 1
    如果数组有两个元素{1,2}， 那么有如下两种可能
    1                      2
     \                    /
      2                  1
    Count[2] = Count[0] * Count[1]   (1为根的情况)
               + Count[1] * Count[0]  (2为根的情况)

    再看一遍三个元素的数组，可以发现BST的取值方式如下：
    Count[3] = Count[0]*Count[2]  (1为根的情况)
               + Count[1]*Count[1]  (2为根的情况)
               + Count[2]*Count[0]  (3为根的情况)

    所以，由此观察，可以得出Count的递推公式为
    Count[i] = ∑ Count[0...k] * [ k+1....i]     0<=k<i-1
    问题至此划归为一维动态规划。
    以上截取自网上，大致想表达的就是
    count[n+1] = count[0]*count[n]+count[1]*count[n-1]+...+count[n-1]*count[1]+count[n]*count[0]
    上面想表达的是当有n+1个数字，先拿出一个数字作为根节点，
    以上面的表达式为例，count[0]*count[n]，表示左边0个结点，右边n个结点，以此来递归
    
    原始的递推式是： Ct+1 += Ci*Ct-i (0<= i <=t)
	现在令变量num=t+1，那么t=num-1
	所以原始递推式做变量替换得：Cnum += Ci*Cnum-1-i (0<= i <=num-1) 
	而num的取值范围是[1, n]因为C0已知。
*/

public class Solution{
	public int numTrees(int n){
		if(n == 0 || n == 1) return 1;
		int[] c = new int[n + 1];
		c[0] = 1;
		for(int num = 1; num <= n; num++){
			for(int i = 0; i <= num - 1; i++){
				c[num] += c[i]*c[(num - 1) - i];
			}
		}
		return c[n];
	}
}