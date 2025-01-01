class Solution {
 public:
  string longestPrefix(string s) {
    constexpr int kBase = 26, kMod = 1'000'000'007;
    const int n = s.length();
    int max = 0,i,j;
    long pow = 1,pref=0,suff = 0;
    for (i=0,j=n-1;i<n-1;++i,--j) {
      pref=(pref*kBase+v(s[i]))%kMod;
      suff=(v(s[j])*pow+suff)%kMod;
      pow=pow*kBase%kMod;
      if(pref==suff) max=i+1;
    }
    return s.substr(0,max);
  }
 private:
  int v(char c) {
    return c-'a';
  }
};
