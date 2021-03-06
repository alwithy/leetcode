import java.util.*;

public class Q0355_DesignTwitter {
    static class Twitter {
        //key为用户id，value为用户关注列表
        private HashMap<Integer, HashSet<Integer>> follows;
        //key为用户,value为用户最近的10条推特，存储格式为[time, tweetId, userId]
        private HashMap<Integer, List<int[]>> tweets;
        //时间
        int time;

        /** Initialize your data structure here. */
        public Twitter() {
            follows = new HashMap<>();
            tweets = new HashMap<>();
            time = 0;
        }

        private void checkUserId(int userId) {
            if (!follows.containsKey(userId)) {
                follows.put(userId, new HashSet<>());
                tweets.put(userId, new LinkedList<>());
            }
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            checkUserId(userId);
            int[] tweet = new int[]{time++, tweetId, userId};
            List<int[]> list = tweets.get(userId);
            if (list.size() == 10) {
                list.remove(9);
            }
            list.add(0, tweet);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            checkUserId(userId);
            //合并k个有序的链表
            List<Integer> res = new ArrayList<>();
            //大根堆，time大的排在堆顶
            PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });


            //key为userId,value为tweet列表对应index
            HashMap<Integer, Integer> indexes = new HashMap<>();
            HashSet<Integer> set = follows.get(userId);
            for (int user : set) {
                if (!tweets.get(user).isEmpty()) {
                    heap.add(tweets.get(user).get(0));
                    indexes.put(user, 1);
                }
            }

            //把自己的tweet也放入堆
            if (!tweets.get(userId).isEmpty()) {
                heap.add(tweets.get(userId).get(0));
                indexes.put(userId, 1);
            }

            while (res.size() < 10 && !heap.isEmpty()) {
                int[] tweet = heap.poll();
                res.add(tweet[1]);
                int user = tweet[2];

                int index = indexes.get(user);
                List<int[]> list = tweets.get(user);
                if (index < list.size()) {
                    heap.add(list.get(index));
                    indexes.put(user, index + 1);
                }
            }

            return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            checkUserId(followerId);
            checkUserId(followeeId);
            if (followeeId == followerId) {
                return;
            }
            follows.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            checkUserId(followerId);
            checkUserId(followeeId);
            follows.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter tw = new Twitter();

        tw.postTweet(1, 5);

        List list1 = tw.getNewsFeed(1);

        tw.follow(1, 2);

        tw.postTweet(2, 6);

        List list2 = tw.getNewsFeed(1);

        tw.unfollow(1, 2);

        List list3 = tw.getNewsFeed(1);
    }
}
