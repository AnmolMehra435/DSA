//Algorihm

//1. Initialize total = 0.
//2. Traverse the string from left to right.
//3. For each Roman character, get its integer value.
//4. If the current value is smaller than the next value, subtract it from total.
//5. Otherwise, add it to total.
//6. Return total.


class Solution {
    public int romanToInt(String s) {
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = value(s.charAt(i));

            if (i < s.length() - 1 &&
                    current < value(s.charAt(i + 1))) {
                total -= current;
            } else {
                total += current;
            }
        }

        return total;
    }

    private int value(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}