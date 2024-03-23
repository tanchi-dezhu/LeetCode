package leetcode.simple;

public class LeetCode_182
{
	public static String dynamicPassword(String password, int target)
	{
		String substring = password.substring(0, target);

		return password.substring(target) + substring;
	}

	public static void main(String[] args)
	{
		System.out.println(dynamicPassword("12345678", 4));
	}
}
