class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        // List to store the result
        List<Integer> result = new ArrayList<>();
        // Find the first occurrences of strings 'a' and 'b' in 's'
        int a_pos = s.indexOf(a); 
        int b_pos = s.indexOf(b);
        // Loop until we run out of occurrences for either 'a' or 'b'
        while (a_pos >= 0 && b_pos >= 0) {
            // If the distance between positions is within the allowed range (<= k)
            if (Math.abs(a_pos - b_pos) <= k) {
                result.add(a_pos); // Add the index of 'a' to the result
                a_pos = s.indexOf(a, a_pos + 1); // Move to the next occurrence of 'a'
            } 
            // If the position of 'b' is less than 'a', move to the next occurrence of 'b'
            else if (b_pos < a_pos) {
                b_pos = s.indexOf(b, b_pos + 1);
            } 
            // Otherwise, move to the next occurrence of 'a' and reset 'b' position
            else {
                a_pos = s.indexOf(a, a_pos + 1);
                b_pos = s.indexOf(b);
            }
        }
        return result; // Return the list of beautiful indices
    }
}