//ALGORITHM
//Step 1: Initialize
//  Create a HashMap map to store:
//  prefixSum → first index where it occurred
//  Initialize:
//  sum = 0
//  maxLen = 0
//Step 2: Traverse the array
//  For each index i from 0 to n - 1:
//  a) Update prefix sum
//        sum = sum + arr[i]
//   b) Check if the entire subarray from index 0 to i has sum k
//        If:
//           sum == k
//             then:
//                maxLen = i + 1
//         because the subarray starts from index 0.
//    c) Check for a previous prefix sum
//          Compute:
//          required = sum - k
//             If required exists in the HashMap:
//                 currentLength = i - map.get(required)
//             Update:
//                  maxLen = max(maxLen, currentLength)
//              Reason:
//                 currentPrefix - oldPrefix = k
//            which means the subarray between those two indices has sum k.
//     d) Store the current prefix sum
//          If the current prefix sum is not already present in the HashMap:
//            map.put(sum, i)
//          Store only the first occurrence because it gives the longest possible subarray length.
//        Step 3: Return answer
//           After traversing the entire array:
//                return maxLen



public int longestSubarray(int[] arr, int k) {

    HashMap<Integer,Integer> map = new HashMap<>();

    int sum = 0;
    int maxLen = 0;

    for(int i=0;i<arr.length;i++){

        sum += arr[i];

        if(sum == k)
            maxLen = i + 1;

        if(map.containsKey(sum - k))
            maxLen = Math.max(maxLen,
                    i - map.get(sum-k));

        if(!map.containsKey(sum))
            map.put(sum,i);
    }

    return maxLen;
}