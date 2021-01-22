package com.techmojo.twitter.tweet;


import java.util.Collections;
import java.util.List;

public class DefaultTweetParser implements ITweetParser<Object> {

  public String getMessage(Object data) {
    return data.toString();
  }

  public List<String> getHashTags(Object data) {
    return Collections.emptyList();
  }

}
