// 贪心算法
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int max = 0;    // 用来标记当前能跳到最大位置
        int n = A.length;
        int[] dp = new int[n];  // 用来存储每个数组位置能跳到最大的位置
        for(int i = 0; i < n - 1; i++){     
        // 注意是“能够跳到”最后一个数组的位置而不是要“跳过”，循环只要看到倒数第二个数组对应的dp值
            dp[i] = i + A[i];   // 每个
            if(dp[i] > max){    // 用来更新当前能跳到最大的位置
                max = dp[i];
                if(i < max)
            }
            if(i == max){       
            // 关键点，什么时候会产生死循环，只有一种情况
            // 当最大位置max的坐标和循环的i已经相等
            // 那就说明到当前位置已经是死循环
                return false;
            }
        }
        return true; 
    }
}
