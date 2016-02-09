/*
	代码量很小，但是理解其中每一部的意思并不简单，重点是要将题目想象成是一道fibonacci数列。
	当第一步是走1格的时候，剩余n-1格楼梯然后进行递归；当第一步是走2格的时候，剩余n-2格楼梯进行递归
	因为只有这两种最开始的走法，所以两种走法相加理应就是最后的解。
	若还能走3格，那就多加一个stepThree = 1。第一步多一种选择，剩余n-3进行递归，然后这三种方法相加。
	下面的for循环内的思路(假定发生的时候为n=n的时候)：
	1. result(n-1时候所要求的最后结果) = 第一步走的是一格(n-1的时候) + 第一步走的是两格(n-1时候)
	2. stepTwo(n的时候的n-2)则相对n-1时候的n-1的走法(n-1-1)
	3. stepOne(n的时候的n-1)则相对变成了n-1时候全部的走法之和
	2和3是本题最核心思想的步骤，也是递归算法实现的关键：相对性 ---- 用先前产生的结果，根据n的变化套入stepOne和stepTwo
*/

public class Solution{
	public int climbStairs(int n) {
	    if(n == 0 || n == 1 || n == 2) return n;
        int stepOne = 1, stepTwo = 1;
        int result = 0;
        for(int i = 2;i <= n; i++){
            result = stepOne + stepTwo;	
            stepTwo = stepOne;
            stepOne = result;
        }
    return result;
    }
}