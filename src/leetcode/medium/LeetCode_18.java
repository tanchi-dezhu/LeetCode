package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jun
 * @date 2021年05月31日 21:11
 */
public class LeetCode_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {//不够四个数，自然无意义
            return quadruplets;
        }
        Arrays.sort(nums);//同样先从小到大排序
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            // 找a，与上一个数相同，跳过，否则就重复了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 如果从这里开始的连续四个数就已经比目标大了，那说明不会存在这样的四个数，因为此时已经是最小了
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //如果当前数和后三个数相加都比目标小，那说明肯定找不到a为当前数的四个数组合，因为此时是a固定后的最大值
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            //找b，后面两个数要留给c和d，因此小于length-2
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    //找b，与上一个b相同，跳过，否则会有重复
                    continue;
                }
                //当前四个数相加都大于目标，那么不存在四个数相加等于目标，因为此时已经是最小了
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                //如果当前a和b和后两个数相加都比目标小，那说明肯定找不到a，b为当前数的四个数组合，因为此时是a，b固定后的最大值
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                //找c和d
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //如果下一个c与当前c相同，那么要跳过下一个c
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;//这时还只是移动到下一个c
                        }
                        left++;//这才是跳出了下一个c
                        //如果d与上一个d相同，跳过
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;//这时还只是移动到下一个d
                        }
                        right--;//这才是跳出了下一个d
                    } else if (sum < target) {//此时要让c增大，d已经到最大了
                        left++;
                    } else {//此时要让d减小，c已经到最小了
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1, 0, 1, 2, -3};
        List<List<Integer>> list = fourSum(nums, 0);
        for (List<Integer> integerList : list) {
            System.out.println(integerList);
        }
    }
}
