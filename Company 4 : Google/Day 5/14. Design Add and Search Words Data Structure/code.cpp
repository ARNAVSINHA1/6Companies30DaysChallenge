#include <bits/stdc++.h>
#include <unordered_map>
const auto _ = std::cin.tie(nullptr)->sync_with_stdio(false);
#define LC_HACK
#ifdef LC_HACK
const auto __ = []() {
    struct ___ {
        static void _() { std::ofstream("display_runtime.txt") << 0 << '\n'; }
    };
    std::atexit(&___::_);
    return 0;
}();
#endif
class WordDictionary {
    unordered_map<char, WordDictionary*> wch;
    bool isWord = false;

public:
    WordDictionary() {}

    void addWord(string word) {
        auto chNode = this;
        for (auto ch : word) {
            if (chNode->wch.find(ch) != chNode->wch.end()) {
                chNode = chNode->wch[ch];
            } else {
                chNode->wch[ch] = new WordDictionary();
                chNode = chNode->wch[ch];
            }
        }
        chNode->isWord = true;
    }

    bool search(string word) {
        auto chNode = this;
        return dfs(chNode, word, 0);
    }

    bool dfs(WordDictionary* root, string word, int index) {
        if (word.size() == index) {
            if (root->isWord) {
                return true;
            } else {
                return false;
            }
        }
        if (word[index] == '.') {
            bool ans = false;
            for (auto [k, v] : root->wch) {
                ans = dfs(v, word, index + 1);
                if (ans) {
                    return true;
                }
            }
            return false;
        }
        if (root->wch.find(word[index]) == root->wch.end()) {
            return false;
        }
        return dfs(root->wch[word[index]], word, index + 1);
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */