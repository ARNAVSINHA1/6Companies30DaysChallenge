class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {

        bool valid[305] = {false};
        for (int i = 0; i < s.size(); i++) {

            for (int j = 0; j < wordDict.size(); j++) {
                int k = i - wordDict[j].size() + 1;
                if (k >= 0 && s.substr(k, wordDict[j].size()) == wordDict[j] &&
                    (k == 0 || valid[k - 1] == true)) {
                    valid[i] = true;
                    break;
                }
            }
        }

        return valid[s.size() - 1];
    }
};
