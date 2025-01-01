class Solution {
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        int g = numsDivide[0];
        for (int i : numsDivide) {
            g = gcd(g, i);
        }
        int minOp = 0;
        int smallest = INT_MAX;
        for (int num : nums) {
            if (g % num == 0) {
                smallest = min(smallest, num);
            }
        }
        for (int num : nums) {
            if (num < smallest) {
                ++minOp;
            }
        }
        return smallest == INT_MAX ? -1 : minOp;
    }
    int min(int a , int b){
        return (a>b)?b:a;
    }
    int gcd(int a, int b) {
        while (b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
};
