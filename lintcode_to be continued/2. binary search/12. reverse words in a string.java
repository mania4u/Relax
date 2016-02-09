// 熟悉字符串常用的几个方法，将字符串化作字符串数组
// 通过构造StringBuilder来使用一些String内部不能实现的方法

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if(s == null || s.length() == 0)
            return "";

        String[] array = s.split(" ");      // 关键函数split()
        StringBuilder sb = new StringBuilder();
        for(int i = array.length - 1; i >= 0; i--){
            if(!array[i].equals("")){
                sb.append(array[i]).append(" ");
            }
        }

        if(sb.length() == 0){
            return "";   
        }else{
            return sb.substring(0, sb.length() - 1);    
            // 上面最后一个循环会多一个“ ”，用这个就都排除了
        }
    }
}
