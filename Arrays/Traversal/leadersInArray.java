//A leader is greater than all the element from its right
//traverse from right to left and maintain a max seen so far

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();

        result.add(arr[arr.length-1]);
        int max = arr[arr.length - 1];

        for(int i = arr.length-2; i>=0; i--){
            if(arr[i] >= max){
                result.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(result);
        return result;
    }
}