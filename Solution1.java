class Solution {
    public  int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(hi - lo > 1){
            int mid = (hi + lo)/2;
            if(nums[mid] == target) return  mid;
            //right sorted portion
            if(nums[lo] <= nums[mid] ){
                if(nums[mid] > target && nums[lo] <= target) hi = mid -1;
                else lo = mid +1;
            }
            // left sorted portion
            else {
                if(nums[mid] < target && nums[hi] >= target) lo = mid +1;
                else hi = mid-1;
            }
        }

        if(nums[lo] == target) return lo;
        else if (nums[hi] == target) return hi;
        else return -1;
    }
}