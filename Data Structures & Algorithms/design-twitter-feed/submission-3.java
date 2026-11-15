class Twitter {
    int count;
    Map<Integer, List<Integer>> userToTweetMap;
    Map<Integer, Integer> tweetCountMap;
    Map<Integer, Set<Integer>> followingMap;
    public Twitter() {
        count = 0;
        userToTweetMap = new HashMap<>();
        tweetCountMap = new HashMap<>();
        followingMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetCountMap.put(tweetId, count++);
        userToTweetMap.computeIfAbsent(userId, k->new ArrayList<>()).add(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> lruCache = new PriorityQueue<>((a,b)->Integer.compare(tweetCountMap.get(a),tweetCountMap.get(b)));
        List<Integer> allTweets = new LinkedList<>();
        if(userToTweetMap.containsKey(userId)){
            allTweets.addAll(userToTweetMap.get(userId));
        }
        Set<Integer> followees = followingMap.get(userId);
        if(followees != null && !followees.isEmpty()){
            for(int followeeId:followees){
                if(userToTweetMap.containsKey(followeeId)){
                    allTweets.addAll(userToTweetMap.get(followeeId));
                }
            }
        }
        for(int tweetId:allTweets){
            lruCache.offer(tweetId);
            if(lruCache.size()>10){
                lruCache.poll();
            }
        }
        allTweets.clear();
        while(!lruCache.isEmpty()){
            allTweets.addFirst(lruCache.poll());
        }
        //Collections.reverse(allTweets);
        return allTweets;
    }
    
    public void follow(int followerId, int followeeId) {
        if(isSameUser(followerId, followeeId)){
            return;
        }
        followingMap.computeIfAbsent(followerId, k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(isSameUser(followerId, followeeId)){
            return;
        }
        Set<Integer> followees = followingMap.get(followerId);
        if(followees == null || !followees.contains(followeeId)){
            return;
        }
        followees.remove(followeeId);
    }

    private boolean isSameUser(int followerId, int followeeId){
        return followerId == followeeId;
    }
}



/***


Initially I was thinking of having a static newsfeed
means that it will get calculated at the time when user posts it
Not when it is fetched

But I suppose for this design, its better to calculate the newsfeed


Map<UserId, List<TweetId>> tweets
Map<TweetId, TimeStamp> tweetTimeStamp

getNewsFeed 
= Add all tweets of this user
= Get All followees of this user
= Get all tweets of the followees
= Add them to a LRU cache
= If the heap size > 10, then poll from it

Follow - 
Map<UserId, Set<FolloweeId>>

Unfollow -

Remove the entry from follower map
*/
