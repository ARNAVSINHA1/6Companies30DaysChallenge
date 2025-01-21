class Solution {
public:
    vector<int> findOccurrences(const string& text, const string& pattern) {
        vector<int> occurrences;
        int pos = text.find(pattern, 0);
        while (pos != string::npos) {
            occurrences.push_back(pos);
            pos = text.find(pattern, pos + 1);
        }
        return occurrences;
    }
    
    vector<int> beautifulIndices(string s, string a, string b, int k) {
        vector<int> indices_a = findOccurrences(s, a);
        vector<int> indices_b = findOccurrences(s, b);
        vector<int> result;
        int j = 0;
        for (int i : indices_a) {
            while (j < indices_b.size() && indices_b[j] < i - k) {
                j++;
            }
            if (j < indices_b.size() && indices_b[j] <= i + k) {
                result.push_back(i);
            }
        }

        return result;
    }
};