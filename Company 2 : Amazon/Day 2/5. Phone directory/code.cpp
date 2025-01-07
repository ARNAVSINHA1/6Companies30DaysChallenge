#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_set>
#include <sstream>

using namespace std;

class TrieNode {
public:
    TrieNode* arr[26] = {nullptr};
    bool isEnd = false;
    vector<string> words;

    TrieNode() {}
};

class Trie {
public:
    TrieNode* root;

    Trie() {
        root = new TrieNode();
    }

    void insert(const string& s) {
        TrieNode* curr = root;
        for (char ch : s) {
            if (curr->arr[ch - 'a'] == nullptr) {
                curr->arr[ch - 'a'] = new TrieNode();
            }
            curr = curr->arr[ch - 'a'];
            curr->words.push_back(s);
        }
        curr->isEnd = true;
    }

    vector<string> getWords(const string& prefix) {
        TrieNode* curr = root;
        for (char ch : prefix) {
            if (curr->arr[ch - 'a'] == nullptr) return {};
            curr = curr->arr[ch - 'a'];
        }
        return curr->words;
    }
};

class Solution {
public:
    static vector<vector<string>> displayContacts(int n, string contact[], string s) {
        vector<vector<string>> result;
        Trie trie;
        for (int i = 0; i < n; i++) {
            trie.insert(contact[i]);
        }

        for (int i = 1; i <= s.length(); i++) {
            vector<string> list = trie.getWords(s.substr(0, i));
            sort(list.begin(), list.end());
            unordered_set<string> uniqueWords(list.begin(), list.end());
            list.assign(uniqueWords.begin(), uniqueWords.end());
            if (list.empty()) {
                list.push_back("0");
            }
            result.push_back(list);
        }
        return result;
    }
};

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t-- > 0) {
        int n;
        cin >> n;
        cin.ignore();
        string contact[n];
        for (int i = 0; i < n; i++) {
            getline(cin, contact[i]);
        }
        string s;
        getline(cin, s);

        Solution ob;
        vector<vector<string>> ans = ob.displayContacts(n, contact, s);
        for (const auto& list : ans) {
            for (const auto& word : list) {
                cout << word << " ";
            }
            cout << endl;
        }
        cout << "~" << endl;
    }
    return 0;
}

