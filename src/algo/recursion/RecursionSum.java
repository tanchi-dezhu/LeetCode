package algo.recursion;

public class RecursionSum
{

	private static int rs(int n)
	{
		if (n == 1)
		{
			return 1;
		}

		int sum = n + rs(n - 1);

		return sum;
	}

	public static void main(String[] args)
	{
		System.out.println(rs(100));
	}
}
