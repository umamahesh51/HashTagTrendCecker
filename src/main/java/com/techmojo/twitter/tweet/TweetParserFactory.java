package com.techmojo.twitter.tweet;

public class TweetParserFactory {
  private static final class InstanceHolder {
    private static final TweetParserFactory instance = new TweetParserFactory();
  }

  private TweetParserFactory() {

  }

  public static TweetParserFactory getInstance() {
    return InstanceHolder.instance;
  }

  public ITweetParser<?> getParser(Object data) {
    if (data instanceof String) {
      return new TextTweetParser();
    }
    return new DefaultTweetParser();
  }
}
