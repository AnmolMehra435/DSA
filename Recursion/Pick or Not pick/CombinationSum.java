//Algorithm:
//
//1. Start recursion from index 0 with currentSum = 0 and an empty combination.
//2. If currentSum equals the target:
//      - Add the current combination to the result.
//      - Return.
//3. If currentSum exceeds the target or all elements are processed, return.
//4. Include the current element:
//      - Add it to the current combination.
//      - Add its value to currentSum.
//      - Recurse with the same index (element can be reused).
//5. Backtrack:
//      - Remove the last element.
//      - Subtract its value from currentSum.
//6. Exclude the current element:
//      - Recurse with the next index.

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        solve(candidates, target, 0, 0, current);
        return result;
    }

    public void solve(int[] candidates, int target, int currentSum, int index, List<Integer> current){
        if(currentSum == target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(currentSum > target || index == candidates.length){
            return;
        }

        currentSum += candidates[index];
        current.add(candidates[index]);
        solve(candidates, target, currentSum, index, current);
        current.remove(current.size() - 1 );
        currentSum -= candidates[index];
        solve(candidates, target, currentSum, index + 1, current);
    }
}