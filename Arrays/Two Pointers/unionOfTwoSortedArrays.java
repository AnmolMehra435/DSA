// use two pointers from the same direction

//ALGO
// 1- while any of the pointers not equal to their array length, compare both elements with each other and the last
//    element in the list and put in list
// 2- put the remaining elements at the end by comparing with the last element of the list




class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();

        int aIdx = 0;
        int bIdx = 0;

        while(aIdx != a.length && bIdx != b.length){
            int first = a[aIdx];
            int second = b[bIdx];

            int candidate = -1;

            if(first < second){
                candidate = first;
                aIdx++;
            }else if(second < first){
                candidate = second;
                bIdx++;
            }else if(first == second){
                candidate = first;
                aIdx++;
                bIdx++;
            }


            if(list.size() == 0){
                list.add(candidate);
            }else{
                int last = list.get(list.size() - 1);
                if(candidate == last){
                    continue;
                }else{
                    list.add(candidate);
                }
            }
        }

        while(aIdx != a.length){
            if(list.size() == 0 || list.get(list.size() - 1) != a[aIdx]){
                list.add(a[aIdx]);
            }
            aIdx++;
        }

        while(bIdx != b.length){
            if(list.size() == 0 || list.get(list.size() - 1) != b[bIdx]){
                list.add(b[bIdx]);
            }
            bIdx++;
        }


        return list;

    }
}
