//Algorithm:
//
//1. Sort the array to group duplicate elements together.
//2. Start recursion from index 0 with currentSum = 0 and an empty combination.
//3. If currentSum equals the target:
//      - Add the current combination to the result.
//      - Return.
//4. If currentSum exceeds the target or all elements are processed, return.
//5. Include the current element:
//      - Add it to the combination.
//      - Recurse with index + 1 (each element can be used only once).
//6. Backtrack by removing the last element.
//7. Skip all consecutive duplicate elements.
//8. Exclude the current element:
//      - Recurse from the next distinct element.


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
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

        current.add(candidates[index]);
        solve(candidates, target, currentSum + candidates[index], index + 1, current);
        current.remove(current.size() - 1);

        int next = index + 1;
        while(next < candidates.length && candidates[next] == candidates[index]){
            next++;
        }

        solve(candidates, target, currentSum, next, current);
    }
}