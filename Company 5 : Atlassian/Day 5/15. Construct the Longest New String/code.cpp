class Solution {
public:
    int longestString(int x, int y, int z) {
        const int mn = min(x, y);
        if (x == y)
            return (mn * 2 + z) * 2;
        return (mn * 2 + 1 + z) * 2;
    }
};