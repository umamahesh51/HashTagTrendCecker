package com.techmojo.twitter.tweet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

import com.techmojo.twitter.hashtagtrend.utils.HashTagUtils;

public class TextTweetParser implements ITweetParser<String> {

  private static final String HASHTAG_START_SYMBOL = "#";

  public String getMessage(String data) {
    return data;
  }

  public List<String> getHashTags(String data) {
    if (data.contains(HASHTAG_START_SYMBOL)) {
      List<String> hasTags = new ArrayList<>();
      Matcher matcher = HashTagUtils.getHashTagPattern().matcher(data);
      while (matcher.find()) {
        int start = matcher.start();
        int end = matcher.end();
        hasTags.add(data.substring(start + 1, end));
      }
      return hasTags;
    }
    return Collections.emptyList();
  }

}
