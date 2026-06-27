//Algorithm

//1. If students > number of books, return -1.
//
//2. Set:
//      low = maximum pages in a single book
//      high = sum of all pages
//      ans = -1
//
//3. While low <= high:
//      mid = low + (high - low) / 2
//
//      If books can be allocated using at most
//      k students with maxPages = mid:
//            ans = mid
//            high = mid - 1      // try smaller answer
//      Else:
//            low = mid + 1       // increase allowed pages
//
//4. Return ans.
//
//
//Possible(maxPages):
//    students = 1
//    currentPages = 0
//
//    Traverse all books:
//         If currentPages + book <= maxPages:
//                currentPages += book
//         Else:
//                students++
//                currentPages = book
//
//    Return (students <= k)

class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        if(k > arr.length){
            return -1;
        }

        int low = -1;
        int high = 0;
        for(int pages: arr){
            low = Math.max(low, pages);
            high += pages;
        }

        int ans = -1;

        while(low<=high){
            int mid = low + (high - low) / 2;

            if(students(arr, k, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean students(int[] arr, int k, int maxPages){
        int countStudent = 1;
        int pages = 0;

        for(int i = 0; i<arr.length; i++){
            if(pages + arr[i] <= maxPages){
                pages += arr[i];
            }else{
                countStudent++;
                pages = arr[i];
            }
        }

        return countStudent <= k;
    }
}