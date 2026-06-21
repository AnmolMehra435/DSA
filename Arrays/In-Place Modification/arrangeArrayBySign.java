//this is not strict in place modification problem

//ALGO
// 1- create an empty arr and pos and neg idx
// 2- traverse through original array and put neg element in neg idx and pos in pos
// 3- update both the pointers whichever used by +2 places

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int neg = 1;
        int[] result = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            if(nums[i] >= 0){
                result[pos] = nums[i];
                pos += 2;
            }else{
                result[neg] = nums[i];
                neg += 2;
            }
        }
        return result;
    }
}