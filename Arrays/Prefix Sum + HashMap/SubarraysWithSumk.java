//Algorithm
//1. Create a HashMap.
//        prefixSum → frequency
//    Insert:
//        map.put(0,1);
//    Initialize:
//       sum = 0
//       count = 0
//2. Traverse the array:
//    For each element:
//      a) Update prefix sum:
//           sum += nums[i];
//      b) Check:
//           sum - k
//              If present in map:
//                 count += map.get(sum - k);
//                       because each occurrence creates a valid subarray.
//      c) Store current prefix:
//        map.put(sum, map.getOrDefault(sum,0)+1);
//3. return count


class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];

            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}