public class Solution{
    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        dfs(res, tmp, k, n, 1);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tmp, int k, int n, int pos){
        if(k == 0){    
            if(n == 0)  
                res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = pos; i <= n / k && i < 10; i++){
            // 添加的数首先小于10，因为给的范围就是[1,9]
            // i<=n/k先转换成i*k<=n这样比较好理解，
            // 一共有k个数字，若都为i，乘积则为i*k，
            // 然而这是不可能的，因为i是每次递增的
            tmp.add(i);
            dfs(res, tmp, k - 1, n - i, i + 1);
            tmp.remove(tmp.size() - 1);     
        }
    }
}