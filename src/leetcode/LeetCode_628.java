package leetcode;

public class LeetCode_628
{
    public static int calPoints(String[] ops)
    {
        int[] tempArry = new int[ops.length];
        if (ops[0] == "D" || ops[0] == "C")
        {
            return 0;
        }

        int i = 0;
        for (String op : ops)
        {
            switch (op)
            {
                case "D":
                    tempArry[i] = tempArry[i - 1] * 2;
                    i++;
                    break;
                case "C":
                    tempArry[i - 1] = 0;
                    i--;
                    break;
                case "+":
                    tempArry[i] = tempArry[i - 2] + tempArry[i - 1];
                    i++;
                    break;
                default:
                    tempArry[i] = Integer.valueOf(op);
                    i++;
                    break;
            }
        }
        int count = 0;
        for (int index = 0; index < tempArry.length; index++)
        {
            count += tempArry[index];
        }
        return count;
    }

    public static void main(String[] args)
    {
        String[] arry = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(arry));
    }
}
