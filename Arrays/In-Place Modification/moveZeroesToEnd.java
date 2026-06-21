//use read write pointer

//ALGO
// 1 traverse array if non zero put in array write pos
// 2 fill the remaining places with zero

class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int num: nums){
            if(num != 0){
                nums[count++] = num;
            }
        }

        for(int i = count; i<nums.length; i++){
            nums[count++] = 0;
        }
    }
}