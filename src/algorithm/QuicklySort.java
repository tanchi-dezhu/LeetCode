package algorithm;

/**
 * 分治算法
 */
public class QuicklySort
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
		int pivot = left;//基准元素，左边界
		int index = pivot + 1;//基准元素下一个元素
		for (int i = index; i <= right; i++)
		{
			//如果下个元素小于基准元素则换位置
			if (nums[i] < nums[pivot])
			{
				swap(nums, i, index);
				index++;//计算换了多少次，由于是从1开始，所以下面 对换位置的时候，要-1才是索引位置
			}
		}
		swap(nums, pivot, index - 1);
		return index - 1;
	}

	private void swap(int[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


	public static void main(String[] args)
	{
		QuicklySort quicklySort = new QuicklySort();
		int[] params = new int[]{57, 68, 59, 52, 12, 21, 108, 210};

		quicklySort.quickSort(params, 0, params.length - 1);

		for (int param : params)
		{
			System.out.println(param);
		}
	}
}
