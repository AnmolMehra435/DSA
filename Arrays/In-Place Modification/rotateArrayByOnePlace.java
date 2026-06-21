//store last elment shift rest by one then put last in first
//this is right rotate by one

class Solution {
    public void rotate(int[] arr) {
        // code here
        int temp = arr[arr.length - 1];
        for(int i = arr.length - 1; i>=1; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }
}