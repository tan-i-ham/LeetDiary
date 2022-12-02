// create a map that keep what a user follow, 
//      key is the userId, value is the list of id that user followed , e.g. { 1: [3,4]}
// create a map that keep what a user post 
//      key is the userId, value is the list of tweetid that user posted , e.g. { 1: [1,5,6]}
// //create a map that keep a user's top10
//      //key is the userId, value is a queue that store 10 elements only , e.g. { 1: [1,5,6]}
class Twitter {
    Map<Integer, Set<Integer>> followIdByUid;
    Map<Integer, List<int[]>> postsByUid;
    int count;
    public Twitter() {
        followIdByUid = new HashMap<>();
        postsByUid = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweets = postsByUid.getOrDefault(userId, new ArrayList<>());
        tweets.add(new int[]{count++, tweetId});
        postsByUid.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> following = followIdByUid.get(userId);
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>( (a,b) -> (b[0] - a[0])); // sort by count
        if(following != null){
            for(int fId: following){
                List<int[]> posts = postsByUid.get(fId);
                if(posts == null){
                    continue;
                }
                for(int[] ele: posts){
                    maxHeap.add(ele);
                }
            }
        }
        List<int[]> selfPosts = postsByUid.get(userId);
        if(selfPosts != null){        
            for(int[] ele: selfPosts){
                maxHeap.add(ele);
            }
        }      
        List<Integer> res = new ArrayList<>();
        int i=0;
        while(i < 10 && !maxHeap.isEmpty()){
            res.add(maxHeap.poll()[1]);
            i++;
        }
        
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> following = followIdByUid.getOrDefault(followerId, new HashSet<>());
        following.add(followeeId);
        followIdByUid.put(followerId, following);        
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> following = followIdByUid.getOrDefault(followerId, new HashSet<>());
        following.remove(followeeId);
        followIdByUid.put(followerId, following);
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