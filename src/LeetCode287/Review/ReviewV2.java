package LeetCode287.Review;

public class ReviewV2 {
    // Brute force
    // nums = [6,3,1,4,2,4,5]
    // We creare a HashSet our HashSet will look like this {6,3,1,4,2}
    // Then, we found that 4 is already there but this is not allowed
    // Better approach
    // We can use two pointers (slow and faster)
    // First we will see that there is a loop
    // In the place both pointers are together, we keep our fast
    // Now we do one jump for both pointer, they will meet with each other in the repeated character
    // slow = nums[0] = 6, fast = nums[nums[0]] = nums[6] = 5
    // 1. slow = nums[6] (5), fast = nums[nums[5]] = nums[4] (2)
    // 2. slow = nums[5] (4), fast = nums[nums[2]] = nums[1] (3)
    // 3. slow = nums[4] (2), fast = nums[nums[3]] = nums[2] (1)
    // 4. slow = nums[2] (1), fast = nums[nums[1]] = nums[3] (4)
    // 5. slow = nums[1] (3), fast = nums[nums[4]] = nums[2] (1)
    // 6. slow = nums[3] (4), fast = nums[nums[1]] = nums[3] (4) <-- MEET
    // slow = 0 (reset), fast remains at 4
    // 1. slow = nums[0] (6), fast = nums[4] (2)
    // 2. slow = nums[6] (5), fast = nums[2] (1)
    // 3. slow = nums[5] (4), fast = nums[1] (3)
    // 4. slow = nums[4] (2), fast = nums[3] (4)  <-- MEET AGAIN
    public int findDuplicate(int[] nums) {
    }
}
