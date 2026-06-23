//THIS IS NOT OPTIMAL SOLUTION (OPTIMAL:- Extended Moore's voting algorithm)

//use hashmap to store frequency of each element
//Any key with frequency n/3 add to list


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int target = n/3;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for(int key: map.keySet()){
            if(map.get(key) > target){
                list.add(key);
            }
        }
        return list;

    }
}


//OPTIMAL (Extended Moore's voting algorithm)

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {

            if (count1 > 0 && num == candidate1) {
                count1++;
            }
            else if (count2 > 0 && num == candidate2) {
                count2++;
            }
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            }
            else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }

        return ans;
    }
}