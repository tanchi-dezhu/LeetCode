package leetcode;

public class LeetCode_744
{
    public static char nextGreatestLetter(char[] letters, char target)
    {
        char result = letters[0];

        for (char letter : letters)
        {
            if (letter > target)
            {
                result = letter;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        char[] arry = new char[]{'c', 'f', 'j'};
        char c = nextGreatestLetter(arry, 'c');
        System.out.println(c);
    }
}
