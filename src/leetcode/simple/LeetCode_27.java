package leetcode.simple;

public class LeetCode_27
{
    public static int removeElement(int[] nums, int val)
    {
//        Arrays.sort(nums);
//        List<Integer> collect = Arrays.stream(nums)
//                .filter(a -> a != val).boxed()
//                .collect(Collectors.toList());
//        nums = collect.stream().mapToInt(Integer::valueOf).toArray();
//        for (int i = 0; i < nums.length; i++)
//        {
//            System.out.println(nums[i]);
//        }
//        return collect.size();

        int left = 0;
        int right = nums.length - 1;
        while (left < right)
        {
            if (nums[left] == val && nums[right] == val)
            {
                right--;
            }
            if (nums[left] == val && nums[right] != val)
            {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
                left++;
            }
            if (nums[left] != val && nums[right] == val)
            {
                left++;
                right--;
            }
            if (nums[left] != val && nums[right] != val)
            {
                left++;
            }
        }
        while (left == right)
        {
            if (nums[left] == val) return left;
            if (nums[left] != val) return left + 1;
        }
        return left;
    }

    public static void main(String[] args)
    {
        int[] arrys = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(arrys, 2));

    }
}
