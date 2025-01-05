class Solution1 {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        // Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq1.add(nums[i]);
        }
        for (int i = 1; i < n; i += 2) {
            nums[i] = pq1.peek();
            pq1.poll();
        }
        for (int i = 0; i < n; i += 2) {
            nums[i] = pq1.peek();
            pq1.poll();
        }
    }
}

class Solution {
    public void wiggleSort1(int[] nums) {
        int n = nums.length - 1;
        // copy values to new array
        int[] newarr = nums.clone();
        // sort new array
        Arrays.sort(newarr);
        // old arr=1,5,1,1,6,4
        // new arr=1,1,1,4,5,6
        // now lets apply odd position and even position
        // odd position
        for (int i = 1; i < nums.length; i += 2)
            nums[i] = newarr[n--];
        // even position
        for (int i = 0; i < nums.length; i += 2)
            nums[i] = newarr[n--];
    }

    // count sort
    public void wiggleSort(int[] nums) {
        // 0 <= nums[i] <= 5000
        // min = 0, max = 5000
        // fill max available value on even positions then on odd positions

        int[] bucket = new int[5001];

        for (int i : nums)
            bucket[i]++;

        int max = 5000;
        boolean firstPass = true;
        for (int i = 1; i < nums.length; i += 2) {

            while (bucket[max] == 0)
                max--;

            nums[i] = max;
            bucket[max]--;

            if (firstPass && i + 2 >= nums.length) {
                i = -2; // want to set i = 0 but since at the end it does i+2 so making it i = -2 to get
                        // resultant = 0
                firstPass = false;
            }
        }

    }
}
