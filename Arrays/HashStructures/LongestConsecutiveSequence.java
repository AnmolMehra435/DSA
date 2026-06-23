//Put all elements into a HashSet for O(1) lookup.
//For each number, check if it is the start of a sequence by verifying that num - 1 is not in the set.
//If it is the start, keep extending the sequence (num + 1, num + 2, ...).
//Track the maximum length.


class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        int maxLen = 0;
        for(int num: set){
            if(!set.contains(num - 1)){
                int currentNum = num;
                int currentLen = 1;

                while(set.contains(currentNum + 1)){
                    currentNum++;
                    currentLen++;
                }

                maxLen = Math.max(maxLen, currentLen);
            }
        }

        return maxLen;

    }
}