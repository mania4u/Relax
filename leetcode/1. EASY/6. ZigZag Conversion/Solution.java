/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

��һ���ַ����ԡ�֮�����Ͳ�����һ���������
*/

public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || nRows <= 0)    // �ж��ַ����Ƿ�Ϊ�պ�����������Ƿ��쳣
            return "";
        if (nRows == 1)     // ���nRow = 1�� Ҳ�����ַ����������
            return s;
        StringBuilder res = new StringBuilder();    
        // Ҳ������String����"+"������String�ķ��������������ײ���̫�����StringBuilderֻ����һ���������������StringBuilder
        int size = 2 * nRows - 2;   // ���size��������ÿ��ZigZag��
        for (int i = 0; i < nRows; i++) {   // ��ʾ�������£������ѭ��
            for (int j = i; j < s.length(); j += size) {        // ��ʾ�������ң������ѭ��
                res.append(s.charAt(j));  // �����ĸ **ע�� append()������StringBuilder����������String
                if (i != 0 && i != nRows - 1 && j + size - 2 * i < s.length())  
                // ǰ��������ָ��ȥ��ʼ�к������У���������ָǶ����"Z"������������||��֮����Ǹ���ĸ
                    res.append(s.charAt(j + size - 2 * i));     // �����ĸ
                }
            }
            return res.toString();  // ��StringBuilder�����Ķ���String��
        ��
        public static void main(String []args)��
            convert("abcdefghi", 3);
            System.out.println(convert("abcdefghi", 3));
    }
}