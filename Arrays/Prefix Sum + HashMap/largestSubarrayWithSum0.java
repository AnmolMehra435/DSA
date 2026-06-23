//Algorithm

//HashMap(prefixSum, firstOccurenceIndex)

//Traverse if sum = 0, max = i +1
//if sum is already in the map then found subarray, update max
//if sum not in map then put it
//return max



class Solution {
    int maxLength(int arr[]) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];

            if(sum == 0){
                max = i + 1;
            }

            if(map.containsKey(sum)){
                max = Math.max(max, i - map.get(sum));
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return max;
    }
}