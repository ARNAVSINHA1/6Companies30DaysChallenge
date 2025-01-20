class Solution {
public:
    int peak(MountainArray& mountainArr) {
        int start = 0, end = mountainArr.length() - 1, ans;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int a = mountainArr.get(mid), b = mountainArr.get(mid + 1);
            if (a < b) {
                start = mid + 1;
            } else if (a > b) {
                ans = mid;
                end = mid;
            }
        }
        return ans;
    }

    int binarysearch(int start, int end, MountainArray& mountainArr,
                     int target) {
        bool isAscending = mountainArr.get(start) < mountainArr.get(end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midvalue = mountainArr.get(mid);
            if (midvalue == target) {
                return mid;
            }
            if (isAscending) {

                if (midvalue < target)
                    start = mid + 1;

                else
                    end = mid - 1;

            } else {
                if (midvalue < target)
                    end = mid - 1;

                else
                    start = mid + 1;
            }
        }
        return -1;
    }
    int findInMountainArray(int target, MountainArray& mountainArr) {
        int p = peak(mountainArr);

        int ans1 = binarysearch(0, p, mountainArr, target);
        int ans2 =
            binarysearch(p + 1, mountainArr.length() - 1, mountainArr, target);
        if ((ans1) != (-1)) {
            return ans1;
        }

        return ans2;
        //    return mountainArr.get();
    }
};