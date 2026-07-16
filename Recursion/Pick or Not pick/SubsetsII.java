//ALGORITHM
// 1. Sort the array so duplicates are adjacent.
//
//2. Start recursion from index = 0 with an empty subset.
//
//3. Base Case:
//   - If index == n:
//       -> Add a copy of current subset.
//       -> Return.
//
//4. Pick the current element:
//   - Add nums[index].
//   - Recurse for index + 1.
//   - Backtrack by removing it.
//
//5. Don't Pick:
//   - Skip all consecutive duplicates of nums[index].
//   - Recurse from the first different element.
//
//6. Continue until all subsets are generated.

//Time Complexity: O(2^n × n)
//Space Complexity: O(n) (excluding output)

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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
        int next = index + 1;
        while(next < nums.length && nums[next] == nums[index]){
            next++;
        }
        solve(nums, next, current);
    }
}