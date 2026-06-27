//Algotihm

//1. Sort the stalls array.
//
//2. Set:
//   low = 1
//   high = last stall - first stall
//   ans = -1
//
//3. While low <= high:
//      mid = low + (high - low) / 2
//
//      If it is possible to place all k cows with
//      minimum distance = mid:
//            ans = mid
//            low = mid + 1      // try larger distance
//      Else:
//            high = mid - 1     // try smaller distance
//
//4. Return ans.
//
//
//Possible(dist):
//    Place first cow at first stall.
//    remaining = k - 1
//    lastPlaced = first stall
//
//    Traverse remaining stalls:
//         If current stall - lastPlaced >= dist:
//                place cow
//                remaining--
//                lastPlaced = current stall
//
//    Return (remaining <= 0)

class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(countDist(stalls, k, mid)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean countDist(int[] stalls, int k, int dist){
        int total = k - 1;
        int current = stalls[0];

        for(int i = 1; i<stalls.length; i++){
            if(stalls[i] - current >= dist){
                total--;
                current = stalls[i];
            }
        }

        return total <= 0;
    }
}