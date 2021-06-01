
public class LeetCode_Six {
    public String convert(String s, int numRows) {
//        判断是否为空，以及行数是否位1
        if (s == null || s.length() == 0 || numRows <= 1) return s;
//        创建对应行数的StringBuilder
        StringBuilder[] stringBuilder = new StringBuilder[numRows];
//        遍历创建StringBuilder
        for (int a = 0; a < numRows; a++) {
            stringBuilder[a] = new StringBuilder();
        }
        int div = 1;
        int index = 0;
        StringBuilder str = new StringBuilder();
//        遍历String
        for (char c : s.toCharArray()) {
//            由于是N形，所以用index表示下标，div表示是否到指定的行数
//            1、到达指定行数就往回添加
            stringBuilder[index].append(c);
            index += div;
            if (index == 0 || index == numRows - 1) div = -div;
        }
//        把添加完的StringBuilder数组添加到新的StringBuilder里面
        for (int i = 0; i < numRows; i++) {
            str.append(stringBuilder[i]);
        }
        return str.toString();
    }

    public static void main(String args[]) {
        LeetCode_Six leetCode_six = new LeetCode_Six();
        System.out.println(leetCode_six.convert("LEETCODEISHIRING", 3));
    }
}
