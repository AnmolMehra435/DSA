//1. Start from number 1.
//
//2. At each number, make two choices:
//   • Pick it.
//   • Skip it.
//
//3. If picked:
//   • Add it to current list.
//   • Add its value to currentSum.
//   • Move to next number (index + 1).
//
//4. Backtrack:
//   • Remove the picked number.
//
//5. If skipped:
//   • Move to next number without changing currentSum.
//
//6. Base Cases:
//   • If current.size == k && currentSum == target → Store answer.
//   • If current.size > k || currentSum > target || index > 9 → Return.
//
//Time: O(2⁹) ≈ O(1)
//Space: O(k)

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int index = 1;
        List<Integer> current = new ArrayList<>();
        solve(current, index, n, k, 0);
        return result;
    }
    private void solve(List<Integer> current, int index, int n, int k, int currentSum){
        if(current.size() == k && currentSum == n){
            result.add(new ArrayList<>(current));
            return;
        }

        if(current.size() > k || currentSum > n || index > 9){
            return;
        }

        current.add(index);
        solve(current, index + 1, n, k, currentSum + index);
        current.remove(current.size() - 1);
        solve(current, index + 1, n, k, currentSum);
    }
}