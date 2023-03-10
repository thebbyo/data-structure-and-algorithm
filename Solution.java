class Solution {
    public static int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while (hi - lo > 1){
            int mid = (hi + lo)/2;
            //left portion
            if(nums[lo] <= nums[mid]){
                if(nums[lo] > nums[hi]) lo = mid;
                else hi = mid;
            }
            else {
                if(nums[lo] <= nums[hi]) lo = mid;
                else hi =  mid;
            }
        }
        if(nums[lo] > nums[hi]) return nums[hi];
        else return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = {9,0,1,2,3,4,5,6,7,8};
        System.out.println(findMin(nums));
    }
}