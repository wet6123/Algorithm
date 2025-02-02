class Twitter {
    private class Tweet {
        int tweetId;
        int userId;

        Tweet (int tweetId, int userId) {
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }

    private LinkedList<Tweet> tweets;
    private Map<Integer, Set<Integer>> follows;

    public Twitter() {
        tweets = new LinkedList<>();
        follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.addFirst(new Tweet(tweetId, userId));
        follow(userId, userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        
        if (!follows.containsKey(userId)) {
            return feed;
        }
        
        Set<Integer> followees = follows.get(userId);
        int count = 0;
        
        for (Tweet tweet : tweets) {
            if (followees.contains(tweet.userId)) {
                feed.add(tweet.tweetId);
                count++;
                if (count == 10) break;
            }
        }
        
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        follows.get(followerId).remove(followeeId);
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