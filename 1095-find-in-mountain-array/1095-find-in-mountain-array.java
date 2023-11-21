/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0, end = mountainArr.length() - 1;
        
        int peak = -1;
        while (start < end) {
            int mid = (end + start)/2;
            if (mountainArr.get(mid) < mountainArr.get(mid+1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
            peak = end;
        }
        
        start = 0;
        end = peak;
        while (start <= end) {
            int mid = (end + start)/2;
            if (mountainArr.get(mid) < target) {
                start = mid + 1;
            } else if (mountainArr.get(mid) > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        
        start = peak + 1;
        end = mountainArr.length() - 1;
        while (start <= end) {
            int mid = (end + start)/2;
            if (mountainArr.get(mid) < target) {
                end = mid - 1;
            } else if (mountainArr.get(mid) > target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        
        return -1;
        
    }
}
    