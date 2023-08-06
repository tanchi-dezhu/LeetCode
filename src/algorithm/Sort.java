package algorithm;

/**
 * 默认排序
 */
public class Sort
{
	public static void Sort(int[] params)
	{
		for (int i = 0; i < params.length; i++)
		{
			for (int j = 0; j < params.length; j++)
			{
				if (params[i] < params[j])
				{
					int temp = params[j];
					params[j] = params[i];
					params[i] = temp;
				}
			}
		}

	}

	public static void main(String[] args)
	{
		int[] params = new int[]{57, 68, 59, 52};

		Sort(params);

		for (int param : params)
		{
			System.out.println(param);
		}
	}

}
