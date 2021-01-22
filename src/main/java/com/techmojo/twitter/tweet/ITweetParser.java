package com.techmojo.twitter.tweet;

import java.util.List;

/**
 * 
 * @author utumma
 * This Interface is to provide extensibility if in future we want to get details from other formats of data than text
 * @param <T>
 */
public interface ITweetParser<T> {
  String getMessage(T data);

  List<String> getHashTags(T data);
}
