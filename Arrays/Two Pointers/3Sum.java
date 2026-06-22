// We sort the array fix one element and apply 2Sum repeatedly

//Algorithm
//1- Sort the array.
//2- Iterate i from 0 to n - 3.
//3- Skip duplicates for i.
//   Set:
//   left = i + 1
//   right = n - 1
//4- While left < right:
//   Compute:
//   sum = nums[i] + nums[left] + nums[right]
//   If sum == 0:
//   Add the triplet.
//5- Skip duplicates for left and right.
//   Move both pointers.
//   If sum < 0:
//   left++;
//   Else:
//   right--;


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i<nums.length - 2; i++){

            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }

                    while(right > left && nums[right] == nums[right - 1]){
                        right--;
                    }

                    left++;
                    right--;
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }
}