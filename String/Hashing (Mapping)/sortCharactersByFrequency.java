//Algorithm

//1. Create a HashMap to store the frequency of each character.
//
//2. Traverse the string and count the frequency of every character.
//
//3. Create an array of lists (buckets) of size n + 1, where index i stores characters having frequency i.
//
//4. Traverse the HashMap:
//      - Get the frequency of each character.
//      - Add the character to bucket[frequency].
//
//5. Traverse the buckets from highest frequency to lowest:
//      - For each character in the bucket, append it to the result frequency times.
//
//6. Return the final string.

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        List<Character>[] bucket = new ArrayList[s.length() + 1];

        for(char ch: map.keySet()){
            int freq = map.get(ch);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(ch);
        }

        StringBuilder result = new StringBuilder();

        for(int i = s.length(); i>=1; i--){
            if(bucket[i] != null){
                for(int j = 0; j<bucket[i].size(); j++){
                    for(int k = 0; k<i; k++){
                        result.append(bucket[i].get(j));
                    }
                }
            }
        }
        return result.toString();
    }
}