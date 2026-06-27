//ALgorithm

//1. Set:
//      low = maximum board length
//      high = sum of all board lengths
//      ans = -1
//
//2. While low <= high:
//      mid = low + (high - low) / 2
//
//      If all boards can be painted by at most k painters
//      such that no painter paints more than mid units:
//            ans = mid
//            high = mid - 1      // try smaller maximum time
//      Else:
//            low = mid + 1       // increase allowed time
//
//3. Return ans.
//
//
//Possible(maxTime):
//    painters = 1
//    currentTime = first board
//
//    Traverse remaining boards:
//         If currentTime + current board > maxTime:
//                painters++
//                currentTime = current board
//         Else:
//                currentTime += current board
//
//    Return (painters <= k)

class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int low = -1;
        int high = 0;

        for(int num: arr){
            low = Math.max(low, num);
            high += num;
        }

        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(subarray(arr, k, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean subarray(int[] arr, int k, int maxSum){
        int total = 1;
        int current = arr[0];

        for(int i = 1; i<arr.length; i++){
            if(current + arr[i] > maxSum){
                total++;
                current = arr[i];
            }else{
                current += arr[i];
            }
        }

        return total <= k;
    }
}
