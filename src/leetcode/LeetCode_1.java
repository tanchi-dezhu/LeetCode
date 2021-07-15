package leetcode;

public class LeetCode_1 {
    public int[] twoSum(int[] nums, int target) {
        int arry[]=new int[2];
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            for(int j=i+1;j<nums.length;j++){
                int count=0;
                int b=nums[j];
                count=a+b;
                if(count==target) {
                    arry[0]=i;
                    arry[1]=j;
                    return arry;
                }else{
                    arry[0]=0;
                    arry[1]=0;
                }
            }
        }
        return arry;
    }
    public static void main(String args[]){
        LeetCode_1 leetCode_one=new LeetCode_1();
        int[] num=new int[]{15,28,36};
        int[] end=leetCode_one.twoSum(num,51);
    }
}
