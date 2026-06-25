
//This is the optimal solution TC:- O(logN)

//Algorithm:
//
//1. Find the first occurrence of target using Binary Search:
//   - If arr[mid] >= target, search left half.
//   - If arr[mid] == target, store mid as answer.
//
//2. Find the last occurrence of target using Binary Search:
//   - If arr[mid] <= target, search right half.
//   - If arr[mid] == target, store mid as answer.
//
//3. If the target is not found (last occurrence = -1), return 0.
//
//4. Otherwise, return:
//   count = lastOccurrence - firstOccurrence + 1


class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int first = firstOccurence(arr, target);
        int last = lastOccurence(arr, target);

        return last == -1? 0: last - first + 1;
    }

    public int firstOccurence(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) /2;

            if(arr[mid] >= target){
                if(arr[mid] == target){
                    ans = mid;
                }

                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int lastOccurence(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] <= target){
                if(arr[mid] == target){
                    ans = mid;
                }

                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }
}


//This is not optimal but designe by my TC :- O(logN+K) worst, O(N)

class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int low = 0;
        int high = arr.length - 1;
        int ans = 0;

        while(low<=high){
            int mid = low + (high - low) /2;
            if(arr[mid] == target){
                ans++;
                low = mid;
                while(low - 1 >= 0 && arr[low-1] == target){
                    ans++;
                    low--;
                }
                high = mid;
                while(high + 1< arr.length && arr[high + 1] == target){
                    ans++;
                    high++;
                }

                break;
            }else if(arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}
