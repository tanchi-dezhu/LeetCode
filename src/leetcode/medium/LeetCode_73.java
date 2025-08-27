package leetcode.medium;

import java.util.HashMap;

public class LeetCode_73
{
	public static void setZeroes(int[][] matrix)
	{
        if (matrix == null || matrix.length == 0)
        {
            return;
        }

        int rowLength = matrix.length;
        int lieLength = matrix[0].length;


        HashMap<Integer, int[]> zeroMap = new HashMap<>();
        int index = 0;
        for (int row = 0; row < rowLength; row++)
        {
            for (int lie = 0; lie < lieLength; lie++)
            {
                int value = matrix[row][lie];
                if (value != 0)
                {
                    continue;
                }
                zeroMap.put(index++, new int[]{row, lie});
            }
        }

        for (Integer key : zeroMap.keySet())
        {
            int[] rowAndLie = zeroMap.get(key);
            int zeroRow = rowAndLie[0];
            int zeroLie = rowAndLie[1];

            for (int tempLie = 0; tempLie < lieLength; tempLie++)
            {
                matrix[zeroRow][tempLie] = 0;
            }

            for (int tempRow = 0; tempRow < rowLength; tempRow++)
            {
                matrix[tempRow][zeroLie] = 0;
            }
        }

        System.out.println(matrix);
    }

	public static void main(String[] args)
	{
		int[][] params = {
				{0, 1, 2, 0},
				{3, 4, 5, 2},
				{1, 3, 1, 5}
		};

		setZeroes(params);

		for (int row = 0; row < params.length; row++)
		{
			int[] lies = params[row];
			for (int lie : lies)
			{
				System.out.println(lie);
			}
		}
	}
}
