//Algorithm

//1. If lengths of both strings are different, return false.
//
//2. Create two HashMaps:
//      - map1 for mapping characters from s → t.
//      - map2 for mapping characters from t → s.
//
//3. Traverse both strings simultaneously:
//      - If ch1 is already mapped and mapping != ch2, return false.
//      - If ch2 is already mapped and mapping != ch1, return false.
//      - Otherwise, store both mappings.
//
//4. If traversal completes without conflicts, return true.

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map1.containsKey(ch1)){
                if(map1.get(ch1) != ch2){
                    return false;
                }
            }else{
                map1.put(ch1, ch2);
            }

            if(map2.containsKey(ch2)){
                if(map2.get(ch2) != ch1){
                    return false;
                }
            }else{
                map2.put(ch2, ch1);
            }
        }
        return true;
    }
}