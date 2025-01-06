class Solution {
    public long maximumSubarraySum(final int[] NUMBERS, final int TARGET_NUMBER) {
        System.gc();
        int maximumNumber = 0;
        for (final int NUMBER : NUMBERS)
            maximumNumber = Math.max(maximumNumber, NUMBER);
        final int[] COUNTS = new int[maximumNumber + 1];
        int duplicatesCount = 0;
        long maximumSum = 0,
                currentSum = 0;
        for (int index = 0; index < TARGET_NUMBER; index++) {
            if (COUNTS[NUMBERS[index]] >= 1)
                duplicatesCount++;
            COUNTS[NUMBERS[index]]++;
            currentSum += NUMBERS[index];
        }
        if (duplicatesCount == 0)
            maximumSum = currentSum;
        for (int index = TARGET_NUMBER; index < NUMBERS.length; index++) {
            if (COUNTS[NUMBERS[index]] >= 1)
                duplicatesCount++;
            COUNTS[NUMBERS[index]]++;
            currentSum += NUMBERS[index];
            if (COUNTS[NUMBERS[index - TARGET_NUMBER]] > 1)
                duplicatesCount--;
            COUNTS[NUMBERS[index - TARGET_NUMBER]]--;
            currentSum -= NUMBERS[index - TARGET_NUMBER];
            if (duplicatesCount == 0)
                maximumSum = Math.max(maximumSum, currentSum);
        }
        return maximumSum;
    }
}
