package algorithm;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch
{
	public static int search(int[] params, int left, int right, int param)
	{
		Arrays.sort(params);

		int mid = (left + right) / 2;

		int num = params[mid];

		if (num == param)
		{
			return mid;
		}

		return num < param ? search(params, mid + 1, right, param) : search(params, left, mid, param);
	}

	public static void main(String[] args)
	{
		int[] params = new int[]{1, 4, 10, 16, 17, 18, 23, 29, 33, 40, 50, 51};


		for (int param : params)
		{
			int search = search(params, 0, params.length - 1, param);
			System.out.println(search);
		}
	}
}
