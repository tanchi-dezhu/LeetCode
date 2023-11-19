package algorithm;

public class Test
{

	private void quickSort(int[] nums, int left, int right)
	{
		if (left < right)
		{
			int partitionIndex = getPartitionIndex(nums, left, right);
			quickSort(nums, left, partitionIndex - 1);
			quickSort(nums, partitionIndex + 1, right);
		}
	}

	private int getPartitionIndex(int[] nums, int left, int right)
	{
		int pivot = left;
		int index = pivot + 1;

		for (int i = index; i <= right; i++)
		{
			if (nums[i] < nums[pivot])
			{
				int temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
				index++;
			}
		}

		int temp = nums[left];
		nums[left] = nums[index - 1];
		nums[index - 1] = temp;
		return index - 1;
	}

	public static void main(String[] args)
	{
		Test quicklySort = new Test();
		int[] params = new int[]{57, 68, 59, 52, 12, 21, 108, 210, 23, 10, 88};

		quicklySort.quickSort(params, 0, params.length - 1);

		for (int param : params)
		{
			System.out.println(param);
		}
	}
}
