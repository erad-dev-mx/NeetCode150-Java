package LeetCode239.Review;

public class ReviewV2 {
    /*
    nums = [1, 3, -1, -3, 5, 3], k = 3
    Result array size: nums.length - k + 1 = 4

    i=0 | val=1  | dq=[0] (val:1)          | res=[]
    i=1 | val=3  | 3 > dq.last(1), dq=[1]  | res=[]
    i=2 | val=-1 | -1 < dq.last(3), dq=[1,2]| res=[3]  <-- Complete window [1,3,-1]
    i=3 | val=-3 | -3 < dq.last(-1),dq=[1,2,3]| res=[3,3]
    i=4 | val=5  | 5 > all, dq=[4]         | res=[3,3,5]
    i=5 | val=3  | 3 < dq.last(5), dq=[4,5]| res=[3,3,5,5]
    */

    // nums = [1, 2, 3], k=2
    // i=0: dq[0]
    // i=1: 2 > 1 -> dq[1], res[2]
    // i=2: 3 > 2 -> dq[2], res[2, 3]
    public int[] maxSlidingWindow(int[] nums, int k) {

    }
}
