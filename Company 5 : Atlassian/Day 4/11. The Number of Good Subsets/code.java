class Solution {
    static int MOD = 1_000_000_000 + 7;
    static List<Integer> excludes = new ArrayList<>();
    static List<Integer>[] factors = new List[31];
    static List<int[]> coprimes_pmt = new ArrayList<>();
    static {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        int[] masks = new int[31];
        for (int i = 4; i <= 30; i++) {
            if (i % 4 == 0 || i % 9 == 0 || i % 25 == 0) {
                excludes.add(i);
                continue;
            }
            if (primes.contains(i))
                continue;
            for (int j = 0; j < primes.size(); j++)
                if (i % primes.get(j) == 0) {
                    if (factors[i] == null)
                        factors[i] = new ArrayList<>();
                    factors[i].add(primes.get(j));
                    masks[i] |= (1 << j);
                }
        }
        buildCoprimes(0, masks, 0, new int[]{});
    }
    static void buildCoprimes(int mask, int[] masks, int num, int[] prev) {
        for (; num < masks.length; num++)
            if (masks[num] > 0 && (mask & masks[num]) == 0) {
                int[] arr = Arrays.copyOf(prev, prev.length + 1);
                arr[prev.length] = num;
                coprimes_pmt.add(arr);
                buildCoprimes(mask | masks[num], masks, num + 1, arr);
            }
    }
    public int numberOfGoodSubsets(int[] nums) {
        int[] prime_count = new int[31], composite_count = new int[31];
        for (int num : nums)
            prime_count[num]++;
        for (int ex : excludes)
            prime_count[ex] = 0;
        for (int i = 0; i < prime_count.length; i++)
            if (factors[i] != null) {
                composite_count[i] = prime_count[i];
                prime_count[i] = 0;
            }
        long result = sum(prime_count, null);
        for (int[] coprimes : coprimes_pmt) {
            long count_mul = 1;
            for (int composite : coprimes)
                count_mul *= composite_count[composite];
            if (count_mul > 0)
                result = (result + (sum(prime_count, coprimes) + 1) * count_mul) % MOD;
        }
        while (prime_count[1] > 0) {
            result = (result * 2) % MOD;
            prime_count[1]--;
        }
        return (int) result;
    }
    int sum(int[] prime_count, int[] coprimes) {
        int[] dp = Arrays.copyOf(prime_count, prime_count.length);
        if (coprimes != null)
            for (int composite : coprimes)
                for (int factor : factors[composite])
                    dp[factor] = 0;
        for (int i = 3; i <= 29 ; i++)
            dp[i] = (int) ((dp[i - 1] + 1L * dp[i - 1] * dp[i] + dp[i]) % MOD);
        return dp[29];
    }
}