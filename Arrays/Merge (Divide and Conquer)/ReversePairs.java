//Algorithm

//1. Use Merge Sort to recursively divide the array into two halves.
//
//2. Recursively count reverse pairs in:
//   - Left half
//   - Right half
//
//3. Before merging the two sorted halves, count cross reverse pairs:
//
//   Initialize:
//       right = mid + 1
//
//   For every element 'left' from low to mid:
//
//       While right <= high and
//             nums[left] > 2 * nums[right]:
//             right++
//
//       All elements from (mid + 1) to (right - 1)
//       form reverse pairs with nums[left].
//
//       Add:
//           right - (mid + 1)
//       to the count.
//
//4. Merge the two sorted halves using the normal Merge Sort merge step.
//
//5. Return:
//       leftCount + rightCount + crossCount


class Solution {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {

        if (low >= high)
            return 0;

        int mid = low + (high - low) / 2;

        int count = 0;

        count += mergeSort(nums, low, mid);

        count += mergeSort(nums, mid + 1, high);

        count += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {

        int count = 0;
        int right = mid + 1;

        for (int left = low; left <= mid; left++) {

            while (right <= high &&
                    (long) nums[left] > 2L * nums[right]) {
                right++;
            }

            count += right - (mid + 1);
        }

        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }
    }
}