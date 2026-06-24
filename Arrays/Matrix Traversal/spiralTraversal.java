//Algorithm (4-Step)

//1. Traverse from left → right on top row, then top++.
//2. Traverse from top → bottom on right column, then right--.
//3. If top <= bottom, traverse from right → left on bottom row, then bottom--.
//4. If left <= right, traverse from bottom → top on left column, then left++.


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int left = 0;
        int right = n-1;
        int bottom = m-1;

        ArrayList<Integer> result = new ArrayList<>();

        while(top <= bottom && left <= right){
            for(int i = left; i<=right; i++){
                result.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i = right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i = bottom; i>=top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}