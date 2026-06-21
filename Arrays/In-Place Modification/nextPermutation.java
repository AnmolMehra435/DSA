//this is the example of strict in place modification

//ALGO
// 1- first traverse from right to left and find break point (arr[i] < arr[i+1])
// 2- if pivot is less than 0 that is no such break point exists then reverse the arr and return
// 3- swap the pivot element with the just greator element on the right side of the pivot
// 4- now reverse the right side array from pivot and return


class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = n - 2;
        for(int i = n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                break;
            }else{
                pivot--;
            }
        }

        if(pivot < 0){
            int left = 0;
            int right = n-1;
            while(left<right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }

            return;
        }

        for(int i = n-1; i>pivot; i--){
            if(nums[i] > nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        int left = pivot+1;
        int right = n-1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}