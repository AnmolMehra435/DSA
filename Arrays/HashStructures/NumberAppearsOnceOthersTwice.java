// THIS IS NOT THE OPTIMAL SOLUTION (OPTIMAL = XOR)

//Use a hashmap to store the frequency of each element
//Return the element with frequency = 1

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key: map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }
        return 0;
    }
}

//OPTIMAL

class Solution{
    public int singleNumber(int[] nums){
        int ans = 0;
        for(int num: nums){
            ans = ans ^ num;
        }
        return ans;
    }
}