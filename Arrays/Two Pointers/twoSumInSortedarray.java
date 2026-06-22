//Two sum problem with sorted array


//ALGO
// 1- Use two pointers left and right when thier sum is greator than target move right else move left


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left<right){
            if(nums[left] + nums[right] == target){
                return new int[]{left, right};
            }else if(nums[left] + nums[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{};
    }
}