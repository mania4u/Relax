public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";
        if(n == 1) return "1";
        String pre = countAndSay(n - 1);
        int length = pre.length();
        int from = 0, to = 0;
        StringBuilder sb = new StringBuilder();
        while(to < length){
            while(to + 1< length && pre.charAt(to) == pre.charAt(to + 1)) to++;
            sb.append(to - from + 1).append(pre.charAt(from));
            from = to + 1;
            to = from;
        }
        return sb.toString();
    }
}