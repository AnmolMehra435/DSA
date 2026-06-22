//Three Pointers use

//ALGO
//1- intialize i from the end of nums1 ele
//2- initialize j from the end of nums2 ele
//3- initialize k from the actual end of nums1
//4- compare the elements and put the larger element at the end of nums1


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[k--] = nums1[i];
                i--;
            }else{
                nums1[k--] = nums2[j];
                j--;
            }
        }

        while(i >= 0){
            nums1[k--] = nums1[i--];
        }
        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
}