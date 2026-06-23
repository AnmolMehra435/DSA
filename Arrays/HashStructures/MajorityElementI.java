//THIS IS NOT OPTIMAL SOLUTION (OPTIMAL:- Moore's voting algorithm)

//Use a hashmap to count frequency of each element
//return the key with the most frequency


class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = nums[0];
        for(int key: map.keySet()){
            if(map.get(key) > map.get(max)){
                max = key;
            }
        }
        return max;
    }
}

//OPTIMAL (Moore's Voting algo)

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == candidate){
                count++;
            }else{
                count--;
            }

            if(count == 0){
                candidate = nums[i];
                count = 1;
            }
        }

        return candidate;
    }
}