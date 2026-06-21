//maintain two variable and obtain them with two individual pass

class Solution {
    public int missingNumber(int[] nums) {
        int arraySum = 0;
        for(int num: nums){
            arraySum += num;
        }

        int actualSum = 0;
        for(int i = 0; i<=nums.length;i++){
            actualSum += i;
        }

        return actualSum - arraySum;
    }
}