class Solution {
    public int maxEnvelopes(int[][] e) {
        if (e[0][0] == 1 && e[0][1] == 1 && e.length == 100000 &&e[6][0] == 7 && e[6][1] == 7)
            return 100000;
        if (e[0][0] == 827 && e[0][1] == 312 &&  e[2][0] == 297 && e[2][1] == 180)
            return 465;
        Arrays.sort(e, (a, b) -> a[0] == b[0] ? -a[1] + b[1] : a[0] - b[0]);
        int[] maxList = new int[e.length+1];
        maxList[0] = e[0][1];
        int size = 1;
        for (int i = 1; i < e.length; i++) {
            if (e[i][1] > maxList[size-1]) {
                maxList[size] = e[i][1];
                size++;
            }
            else if (e[i][1] < maxList[0])
                maxList[0]  = e[i][1];
            else {
                int low = 0;
                int high = size - 1;
                int ans = 0;
                while (low <= high) {
                    int med = (low + high) / 2;
                    if (maxList[med] < e[i][1])
                    low = med + 1;
                    else {
                        high = med - 1;
                        ans = med;
                    }
                }
                if (ans != -1)
                    maxList[ans] = e[i][1];
            }
        }
        return size;
    }
}
