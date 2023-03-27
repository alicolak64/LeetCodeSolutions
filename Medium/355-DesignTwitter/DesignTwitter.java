import java.util.*;

public class DesignTwitter {

    /*

    Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

    postTweet(userId, tweetId): Compose a new tweet.
    getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
    follow(followerId, followeeId): Follower follows a followee.
    unfollow(followerId, followeeId): Follower unfollows a followee.

    Example:

    Twitter twitter = new Twitter();

    // User 1 posts a new tweet (id = 5).
    twitter.postTweet(1, 5);

    // User 1's news feed should return a list with 1 tweet id -> [5].
    twitter.getNewsFeed(1);

    // User 1 follows user 2.
    twitter.follow(1, 2);

    // User 2 posts a new tweet (id = 6).
    twitter.postTweet(2, 6);

    // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
    // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    twitter.getNewsFeed(1);

    // User 1 unfollows user 2.
    twitter.unfollow(1, 2);

    // User 1's news feed should return a list with 1 tweet id -> [5],
    // since user 1 is no longer following user 2.
    twitter.getNewsFeed(1);

    */

    // Link : https://leetcode.com/problems/design-twitter/

    public static void main(String[] args) {

        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        System.out.println(twitter.getNewsFeed(1));

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        System.out.println(twitter.getNewsFeed(1));

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(1));

    }

    static class Twitter {

        private final HashMap<Integer, HashSet<Integer>> follows;
        private final HashMap<Integer, LinkedList<Tweet>> tweets;
        private int time;

        public Twitter() {
            follows = new HashMap<>();
            tweets = new HashMap<>();
            time = 0;
        }

        public void postTweet(int userId, int tweetId) {

            if (!tweets.containsKey(userId))
                tweets.put(userId, new LinkedList<>());

            tweets.get(userId).add(0, new Tweet(tweetId, userId, time++));

            if (!follows.containsKey(userId)) {
                follows.put(userId, new HashSet<>());
                follows.get(userId).add(userId);
            }

        }

        public List<Integer> getNewsFeed(int userId) {

            List<Integer> result = new LinkedList<>();
            PriorityQueue<Tweet> queue = new PriorityQueue<>();

            if (!follows.containsKey(userId))
                return result;


            HashSet<Integer> followed = follows.get(userId);
            HashMap<Integer, Integer> map = new HashMap<>();

            for (Integer i : followed) {

                if (tweets.containsKey(i)) {
                    Tweet tweet = tweets.get(i).get(0);
                    queue.add(tweet);
                    map.put(tweet.userId, 1);
                }

            }
            while (queue.size() > 0 && result.size() < 10) {

                Tweet tweet = queue.poll();
                result.add(tweet.tweetId);
                int next = map.get(tweet.userId);

                map.put(tweet.userId, next + 1);

                if (next < tweets.get(tweet.userId).size())
                    queue.add(tweets.get(tweet.userId).get(next));

            }

            return result;

        }

        public void follow(int followerId, int followeeId) {

            if (!follows.containsKey(followerId)) {
                follows.put(followerId, new HashSet<>());
                follows.get(followerId).add(followerId);
            }

            follows.get(followerId).add(followeeId);

        }

        public void unfollow(int followerId, int followeeId) {

            if (followerId == followeeId)
                return;

            if (follows.containsKey(followerId))
                follows.get(followerId).remove(followeeId);

        }

        private static class Tweet implements Comparable<Tweet> {
            private final int tweetId;
            private final int time;
            private final int userId;

            public Tweet(int tweetId, int userId, int timestamp) {
                this.tweetId = tweetId;
                this.time = timestamp;
                this.userId = userId;
            }

            @Override
            public int compareTo(Tweet t2) {
                return t2.time - this.time;
            }

        }

    }

}
