//Algorithm

//1. Start from the top-right corner of the matrix.
//2. If current element is 1:
//      - Update answer as current row.
//      - Move left (j--), since this row may contain more 1s.
//3. If current element is 0:
//      - Move down (i++), since all elements to the left are also 0.
//4. Continue until indices go out of bounds.
//5. Return the stored row index (or -1 if no 1 is found).
//
//Time Complexity: O(m + n)
//Space Complexity: O(1)


class Solution {
    public int rowWithMax1s(int[][] arr) {
        // code here
        int m = arr.length;
        int n = arr[0].length;

        int ans = -1;

        int i = 0;
        int j = n - 1;

        while(i<m && j>=0){
            if(arr[i][j] == 1){
                ans = i;
                j--;
            }else{
                i++;
            }
        }

        return ans;
    }
};