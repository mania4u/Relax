/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

将一个字符串以“之”字型并横向一行行输出。
*/

public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || nRows <= 0)    // 判断字符串是否为空和纵向的行数是否异常
            return "";
        if (nRows == 1)     // 如果nRow = 1， 也就是字符串本身并输出
            return s;
        StringBuilder res = new StringBuilder();    
        // 也可以用String加上"+"来连接String的方法，但这样容易产生太多对象。StringBuilder只会有一个对象，所以最好用StringBuilder
        int size = 2 * nRows - 2;   // 这个size可以理解成每个ZigZag的
        for (int i = 0; i < nRows; i++) {   // 表示从上至下，纵向的循环
            for (int j = i; j < s.length(); j += size) {        // 表示从左至右，横向的循环
                res.append(s.charAt(j));  // 添加字母 **注意 append()存在于StringBuilder，不存在于String
                if (i != 0 && i != nRows - 1 && j + size - 2 * i < s.length())  
                // 前两个条件指除去初始行和最终行，最后个条件指嵌在在"Z"的两根“柱子||”之间的那个字母
                    res.append(s.charAt(j + size - 2 * i));     // 添加字母
                }
            }
            return res.toString();  // 将StringBuilder产生的对象，String化
        ｝
        public static void main(String []args)｛
            convert("abcdefghi", 3);
            System.out.println(convert("abcdefghi", 3));
    }
}