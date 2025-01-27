class Solution {
    static String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans; // Return an empty list for an empty input
        }
        generateCombinations(digits, "", ans);
        return ans;
    }

    public static void generateCombinations(String ques, String currentCombination, ArrayList<String> result) {
        if (ques.length() == 0) {
            result.add(currentCombination); // Add the completed combination to the result list
            return;
        }

        char ch = ques.charAt(0); // Get the first character of the input
        String possibleLetters = map[ch - '0']; // Get the corresponding letters for the digit

        for (int i = 0; i < possibleLetters.length(); i++) {
            generateCombinations(ques.substring(1), currentCombination + possibleLetters.charAt(i), result);
        }
    }
}