class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        // radix sort each trimmmed and save to hashmap
        int strlen = nums[0].length();
        HashMap<Integer, Integer[]> map = new HashMap<>();
        for(int i = 1; i<=strlen; i++){
            countingSort(map, nums, i);
        }
        int[] res = new int[queries.length];
        int j = 0;
        for(int[] q : queries){
            int k = q[0];
            int trim = q[1];
            // System.out.println(trim);
            res[j] = map.get(trim)[k-1];
            j++;
        }
        return res;
    }
    private void countingSort(HashMap<Integer, Integer[]> map, String[] nums, int index){
        int[] trimmed = new int[nums.length];
        int strlen = nums[0].length();
        Integer[] sortIndices;
        if(index == 1){
            sortIndices = new Integer[nums.length];
            for(int i = 0; i<nums.length; i++){
                sortIndices[i] = i;
            }
        }
        else{
            sortIndices = map.get(index-1);
        }
        // System.out.println(sortIndices);
        int[] counts = new int[10];
        // trim nums
        for(int i = 0; i < nums.length; i++){
            trimmed[i] = nums[i].charAt(strlen-index) - '0';
            // System.out.println(trimmed[i]);
            counts[trimmed[i]]++;
        }
        int[] acc = new int[10];
        for(int i = 1; i < 10; i++){
            acc[i] = acc[i-1] + counts[i-1];
        }
        Integer[] newSortIndices = new Integer[nums.length];
        for(Integer i : sortIndices){
            int num = trimmed[i];
            newSortIndices[acc[num]] = i;
            acc[num]++;
        }
        // for(Integer i : newSortIndices){ System.out.println(i); }
        map.put(index, newSortIndices);
    }
}
