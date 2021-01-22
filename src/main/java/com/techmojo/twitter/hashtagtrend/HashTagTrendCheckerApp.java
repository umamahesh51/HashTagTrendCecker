package com.techmojo.twitter.hashtagtrend;

import java.util.List;

import com.techmojo.twitter.hashtagtrend.utils.LogUtils;
import com.techmojo.twitter.tweet.ITweetParser;
import com.techmojo.twitter.tweet.TweetParserFactory;
import com.techmojo.twitter.tweet.hashtag.HashTagRepository;

/**
 * 
 * @author utumma
 * This is a Twitter HashTag Trend checker. It takes tweets as input and maintains the number of occurrences of each hashtag.
 * When queried about the top N Hashtags it will retrieve them from maintained cache by sorting them based on the number of occurrences.
 */
public class HashTagTrendCheckerApp {
  public void addTweet(String tweet) {
    @SuppressWarnings("unchecked")
    ITweetParser<String> parser = (ITweetParser<String>) TweetParserFactory.getInstance().getParser(tweet);
    List<String> hashTags = parser.getHashTags(tweet);
    HashTagRepository.getInstance().addHashTags(hashTags);
  }

  public List<String> getTrendingHashTags(int n) {
    return HashTagRepository.getInstance().getTrendingHashTags(n);
  }

  public static void main(String[] args) {
    HashTagTrendCheckerApp app = new HashTagTrendCheckerApp();
    //Single HashTags
    app.addTweet("Worlds best cricketer is #sachin");
    app.addTweet("Worlds best cricketer is #lara");
    app.addTweet("Worlds best cricketer is #sachin");
    app.addTweet("Worlds best cricketer is #kohli");
    app.addTweet("Worlds best cricketer is #sachin");
    app.addTweet("Worlds best cricketer is #Root");
    app.addTweet("Worlds best cricketer is #sachin");
    app.addTweet("Worlds best cricketer is #smith");
    app.addTweet("Worlds best cricketer is #sachin");
    app.addTweet("Worlds best cricketer is #williamson");
    app.addTweet("Worlds best cricketer is #bumrah");
    app.addTweet("Worlds best cricketer is #sachin");
    app.addTweet("Worlds best cricketer is #bumrah");
    app.addTweet("Worlds best cricketer is #sachin");
    app.addTweet("Worlds best cricketer is #Dhoni");
    app.addTweet("Worlds best cricketer is #sachin");
    app.addTweet("Worlds best cricketer is #Dhoni");
    app.addTweet("Worlds best cricketer is #Dhoni");
    app.addTweet("Worlds best cricketer is #Dhoni");
    app.addTweet("Worlds best cricketer is #Sehwag");
    app.addTweet("Worlds best cricketer is #Dhoni");
    app.addTweet("Worlds best cricketer is #Anderson");

    //Adding Tweet with Multiple HashTags
    app.addTweet("Carpediem - seize the day. #motivation #morningmotivation");
    
    //Log Top 10 Trending HashTags
    List<String> trendingHashTags = app.getTrendingHashTags(10);
    app.logHashTags(trendingHashTags);
    
    LogUtils.logMessage("------");
    
    //Log All HashTags
    app.logHashTags(HashTagRepository.getInstance().getAllHashTags());
  }

  private void logHashTags(List<String> trendingHashTags) {
    for (int i = 0; i < trendingHashTags.size(); i++) {
      LogUtils.logMessage(i + 1 + "." + trendingHashTags.get(i));
    }
  }
}
