//Algorithm: Count Subarrays with Given XOR = K (Optimal)
//
//1. Initialize:
//        - Create a HashMap to store: prefixXor -> frequency
//   - Insert (0, 1) into the map.
//        - Initialize:
//             xr = 0
//             count = 0
//
//2. Traverse the array:
//     - For each element, update the prefix XOR:
//          xr = xr ^ arr[i]
//
//3. Find the required prefix XOR:
//    - required = xr ^ k
//      - If 'required' exists in the map,
//          add its frequency to count.
//
//4. Store the current prefix XOR:
//        - map.put(xr, map.getOrDefault(xr, 0) + 1)
//
//5. Return count.


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int currXor = 0;
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            currXor = currXor ^ arr[i];

            if(currXor == k){
                count++;
            }

            if(map.containsKey(currXor ^ k)){
                count += map.get(currXor ^ k);
            }

            map.put(currXor, map.getOrDefault(currXor, 0) + 1);
        }

        return count;
    }
}