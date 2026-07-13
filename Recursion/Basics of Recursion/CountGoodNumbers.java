//Algorithm (Recursive - Count Good Numbers)
//
//1. Count the number of even and odd indices:
//   - even = (n + 1) / 2
//   - odd = n / 2
//
//2. Compute:
//   - evenWays = 5^even using recursive fast exponentiation.
//   - oddWays = 4^odd using recursive fast exponentiation.
//
//3. Return:
//   - (evenWays × oddWays) % MOD
//
//Recursive Fast Exponentiation:
//1. Base Case:
//   - If exponent == 0, return 1.
//2. Compute:
//   - half = power(base, exponent / 2)
//3. If exponent is even:
//   - Return (half × half) % MOD.
//4. If exponent is odd:
//   - Return (base × (half × half % MOD)) % MOD.
//
//Time Complexity: O(log n)
//Space Complexity: O(log n) (Recursion Stack)

class Solution {
    long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n /2;

        long evenWays = power(5, even);
        long oddWays = power(4, odd);

        return (int)((evenWays * oddWays) % MOD);
    }

    private long power(long x, long n){
        if(n == 0){
            return 1;
        }

        long half = power(x, n/2);

        if(n % 2 == 0){
            return (half * half) % MOD;
        }
        return (x * ((half * half) % MOD)) % MOD;
    }
}