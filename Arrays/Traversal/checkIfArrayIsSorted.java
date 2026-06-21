//every element should satisfy arr[i] <= arr[i+1]

class Solution {
    public boolean isSorted(int[] arr) {
        // code here
        boolean result = true;
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                result = false;
                break;
            }
        }
        return result;
    }
}