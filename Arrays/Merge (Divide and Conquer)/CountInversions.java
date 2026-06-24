//Algorithm

//1. Divide the array recursively using Merge Sort.
//2. Count inversions in the left half.
//3. Count inversions in the right half.
//4. During merge, if left[i] > right[j], add (mid - i + 1).
//5. Return left + right + merge inversions.


class Solution {

    public int inversionCount(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int mergeSort(int[] arr, int low, int high) {

        if (low >= high)
            return 0;

        int mid = low + (high - low) / 2;

        int count = 0;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);

        return count;
    }

    private int merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;
        int count = 0;

        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                count += (mid - left + 1);

                temp[k++] = arr[right++];
            }
        }

        while (left <= mid)
            temp[k++] = arr[left++];

        while (right <= high)
            temp[k++] = arr[right++];

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return count;
    }
}