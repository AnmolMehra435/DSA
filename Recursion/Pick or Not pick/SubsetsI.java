//1. Start from index = 0 with an empty subset.
//
//2. Base Case:
//   - If index == n:
//       -> Add a copy of current subset to answer.
//       -> Return.
//
//3. Pick the current element:
//   - Add nums[index] to current.
//   - Recurse for index + 1.
//
//4. Backtrack:
//   - Remove the last added element.
//
//5. Don't Pick the current element:
//   - Recurse for index + 1.
//
//6. Continue until all elements are processed.

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> current = new ArrayList<>();
        solve(nums, 0, current);
        return result;
    }
    private void solve(int[] nums, int index, List<Integer> current){
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        solve(nums, index + 1, current);
        current.remove(current.size() - 1);
        solve(nums, index + 1, current);
    }
}