//ALGORITHM

//1. Sort all intervals based on their starting point.
//2. Add the first interval to the answer.
//3. Traverse the remaining intervals:
//4. If the current interval overlaps with the last interval in the answer, merge them.
//        Otherwise, add the current interval as a new interval.


class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for(int i = 1; i<intervals.length; i++){
            int[] prev = result.get(result.size() - 1);
            int[] curr = intervals[i];

            if(prev[1] >= curr[0]){
                int prevEnd = prev[1];
                int currEnd = curr[1];

                int mergeEnd = currEnd;
                if(currEnd < prevEnd){
                    mergeEnd = prevEnd;
                }
                int[] merge = {prev[0], mergeEnd};
                result.remove(result.size() - 1);
                result.add(merge);
            }else{
                result.add(curr);
            }
        }

        int count = 0;
        int[][] newResult = new int[result.size()][2];

        for(int[] curr: result){
            newResult[count++] = curr;
        }

        return newResult;
    }
}