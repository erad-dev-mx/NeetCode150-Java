package LeetCode355;

import java.util.List;

// Twitter class: follow(), unfollow(), getNF(), postTweet()

// For follow() and unfollow()
// For each User we can create a HashSet of all the people that user follows
// class User - int userId, teet - follow(), unfollow(), post() - HashSet: userIds

// For postTweet()
// class Tweet - int id, timestamp, User user - postTweet(tid, uid)

// For generateNewsFeed()
// [Erick] -> is following 10 people <- [Tweet]
// We can go to User then people he/she follow, then check tweeet, now we get most recent 10
// To order the tweets we can use a Heap/PriorityQueue

// Mapping Structure - HashMap
// | UserId | User |
class Twitter {

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
    }
    
    public void follow(int followerId, int followeeId) {
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */