class Twitter {
    public class Info implements Comparable<Info>{
        int time;
        int tweetId;

        Info(int time,int tweetId){
            this.time=time;
            this.tweetId=tweetId;
        }
        @Override
        public int compareTo(Info i){
            return this.time-i.time;
        }
    }

    private HashMap<Integer,Set<Integer>> map;
    private HashMap<Integer,List<Info>> posts;
    private static int count=0;
    public Twitter() {
        count=0;
        map = new HashMap<>();
        posts= new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId))map.put(userId,new HashSet<>());
        map.get(userId).add(userId);
        Info post = new Info(count++,tweetId);
        List<Info> ll = posts.getOrDefault(userId,new ArrayList<>());
        ll.add(0,post);
        posts.put(userId,ll);
        // System.out.println(posts);
        return;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!map.containsKey(userId)) return new LinkedList<>();
        PriorityQueue<Info> feed = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
        map.get(userId).stream()
            .filter(f -> posts.containsKey(f))
            .forEach(f -> posts.get(f).forEach(feed::add));
        List<Integer> res = new LinkedList<>();
        while (feed.size() > 0 && res.size() < 10) res.add(feed.poll().tweetId);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {

        Set<Integer> al = map.getOrDefault(followerId,new HashSet<>());
        al.add(followeeId);
        map.put(followerId,al);
        // System.out.println(map);
        return;
    }
    
    public void unfollow(int followerId, int followeeId) {
        map.get(followerId).remove(followeeId);
                System.out.println(map);
                return;
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