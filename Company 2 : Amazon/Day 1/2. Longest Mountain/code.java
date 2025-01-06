class Solution {
    public static int longestMountain(int[] arr) {
        // Wrapper method to start the recursive process
        return findLongestMountain(arr, 0, arr.length - 1);
    }

    private static int findLongestMountain(int[] arr, int start, int end) {
        // Base case: need at least 3 elements to form a mountain
        if (end - start < 2) {
            return 0;
        }

        // Divide array into two halves
        int mid = (start + end) / 2;

        // Find longest mountain in left half, right half, and spanning the mid point
        int longestLeft = findLongestMountain(arr, start, mid);
        int longestRight = findLongestMountain(arr, mid, end);
        int longestAtMid = findMountainAtPeak(arr, mid);

        // Return the maximum length among all three possibilities
        return Math.max(longestLeft, Math.max(longestRight, longestAtMid));
    }

    private static int findMountainAtPeak(int[] arr, int peakIndex) {
        // Verify if current point is actually a peak
        if (arr[peakIndex] <= arr[peakIndex - 1] || arr[peakIndex] <= arr[peakIndex + 1]) {
            return 0;
        }

        // Extend mountain to left while strictly increasing
        int left = peakIndex;
        while (left > 0 && arr[left - 1] < arr[left]) {
            left--;
        }

        // Extend mountain to right while strictly decreasing
        int right = peakIndex;
        while (right < arr.length - 1 && arr[right + 1] < arr[right]) {
            right++;
        }

        // Calculate total length of mountain
        return right - left + 1;
    }
}
