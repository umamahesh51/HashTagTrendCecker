package com.techmojo.twitter.hashtagtrend.utils;

import java.util.regex.Pattern;

public class HashTagUtils {
  private static Pattern hashTagPattern = Pattern.compile("#[a-zA-Z0-9]*"); //compilation is costly. So we do it only once.

  private HashTagUtils() {

  }

  public static Pattern getHashTagPattern() {
    return hashTagPattern;
  }
}
