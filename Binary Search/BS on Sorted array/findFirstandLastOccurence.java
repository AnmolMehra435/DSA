//Find First Occurrence:
//
//1. Initialize:
//   low = 0, high = n - 1, ans = -1
//
//2. While (low <= high):
//   - mid = low + (high - low) / 2
//   - If nums[mid] == target:
//       ans = mid
//       high = mid - 1
//   - Else if nums[mid] < target:
//       low = mid + 1
//   - Else:
//       high = mid - 1
//
//3. Return ans
//
//
//Find Last Occurrence:
//
//1. Initialize:
//   low = 0, high = n - 1, ans = -1
//
//2. While (low <= high):
//   - mid = low + (high - low) / 2
//   - If nums[mid] == target:
//       ans = mid
//       low = mid + 1
//   - Else if nums[mid] > target:
//       high = mid - 1
//   - Else:
//       low = mid + 1
//
//3. Return ans


//This algorithm and this code solve the problem in T.C :- O(logN)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int arr[] = new int[2];

        arr[0] = firstOccurence(low, high, nums, target);
        arr[1] = lastOccurence(low, high, nums, target);
        return arr;
    }

    public int firstOccurence(int low, int high, int[] nums, int target){
        int ans = -1;
        while(low<=high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                ans = mid;
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    public int lastOccurence(int low, int high, int[] nums, int target){
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                ans = mid;
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}


//This algorithm written and designed by me solve the problem in T.C :- O(logN+K), but worst O(N)

//Algorithm:
//
//1. Perform Binary Search to find any occurrence of target.
//2. If target is found at mid:
//   - Move left from mid until a different element is found.
//   - Move right from mid until a different element is found.
//   - Store these indices as the first and last occurrence.
//3. If target is not found, return [-1, -1].

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int[] ans = {-1, -1};

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {

                low = mid;
                while (low - 1 >= 0 && nums[low - 1] == target) {
                    low--;
                }

                high = mid;
                while (high + 1 < nums.length && nums[high + 1] == target) {
                    high++;
                }

                ans[0] = low;
                ans[1] = high;
                break;

            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}