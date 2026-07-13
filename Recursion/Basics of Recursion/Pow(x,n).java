//Algorithm (Recursive - Fast Power / Binary Exponentiation)
//
//1. Convert the exponent (n) to long to avoid overflow.
//2. If n is negative:
//   - Replace x with 1/x.
//   - Make n positive.
//3. Call the recursive function power(x, n).
//
//Recursive Function:
//1. Base Case:
//   - If n == 0, return 1.
//2. Recursively compute:
//   - half = power(x, n / 2)
//3. If n is even:
//   - Return half × half.
//4. If n is odd:
//   - Return x × half × half.
//
//Time Complexity: O(log n)
//Space Complexity: O(log n) (Recursion Stack)


class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            x = 1 / x;
            N = -N;
        }

        return power(x, N);
    }

    private double power(double x, long n){
        if(n == 0){
            return 1;
        }

        double half = power(x, n/2);

        if(n % 2 == 0){
            return half * half;
        }
        return x * half * half;
    }
}