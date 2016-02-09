/*
    这题的解法就是让数组俩俩进行拼接，组成一个数并进行比较，取得最大的那个数字
    重点在于题目中Comparator的使用，Comparator可以把他当作是一种规则
    代码里的s1=str1+str2, s2=str2+str1，就是相互拼接的意思
    关于compareTo的返回值，详情可以参考：http://blog.csdn.net/ysf871104/article/details/7779441
    compareTo()是一种可以从字符的从左到右进行比较大小的方式
    如果第一个字符和参数的第一个字符相等,则以第二个字符和参数的第二个字符做比较,
    以此类推,直至比较的字符或被比较的字符有一方。全比较完,这时就比较字符的长度. 
    其实拼接最大数字，比的无非是最大位数上字符的大小
    若给出数组[321,121,46,9] 这边又需要注意保存在里的是String数组，而非int数组
    所以用arrays.sort()排序的时候，不能把他们看成是我们普通意义上的integer
    这边在sort()方法内，添加了Comparator的规则，这
    样排序的时候就按照最高位数的从小到大进行排列
    sort()之后，[321,121,46,9]，返回的是[121,321,46,9]
*/

public class Solution{
    public String largestNumber(int[] nums){
        if(nums == null || nums.length == 0)
            return "";
        String[] snum = new String[nums.length];
        // 将int数组转换成string数组
        for(int i = 0; i < nums.length; i++)
            snum[i] = nums[i] + "";

        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2);
            }
        };

        Arrays.sort(snum, comp);
        if(snum[snum.length - 1].charAt(0) == '0')  // 防止["0", "0"]这种情况下报错
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : snum)
            sb.insert(0, s)     // 逆序输出
        return sb.toString();
    }
}