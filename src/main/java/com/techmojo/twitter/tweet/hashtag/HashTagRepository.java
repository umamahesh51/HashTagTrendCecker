package com.techmojo.twitter.tweet.hashtag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashTagRepository {
  private static final Map<String, Integer> HASH_TAGS = new HashMap<>();

  private static final class InstanceHolder {
    private static final HashTagRepository instance = new HashTagRepository();
  }

  private HashTagRepository() {
  }

  public static HashTagRepository getInstance() {
    return InstanceHolder.instance;
  }

  public boolean addHasTag(String hashTag) {
    Integer existingValue = HASH_TAGS.get(hashTag);
    if (existingValue != null) {
      return HASH_TAGS.put(hashTag, existingValue.intValue() + 1) != null;
    } else {
      return HASH_TAGS.put(hashTag, 1) != null;
    }
  }

  public void addHashTags(Collection<String> hashTags) {
    if (hashTags == null || hashTags.isEmpty()) {
      return;
    }
    Iterator<String> iterator = hashTags.iterator();
    while (iterator.hasNext()) {
      addHasTag(iterator.next());
    }
  }

  public boolean removeHashTag(String hashTag) {
    return HASH_TAGS.remove(hashTag) != null;
  }

  public List<String> getTrendingHashTags(int upperBoundOfRequiredHashTags) {
    Map<String, Integer> sortedmap = sortHashMapByValues(HASH_TAGS);
    Set<String> allHashTagsInSortedOrder = sortedmap.keySet();
    int count = 0;
    List<String> trendingHashTags = new LinkedList<>();
    for (Iterator<String> i = allHashTagsInSortedOrder.iterator(); count++ < upperBoundOfRequiredHashTags
        && i.hasNext();) {
      trendingHashTags.add(i.next());
    }
    return trendingHashTags;
  }

  public List<String> getAllHashTags() {
    return getTrendingHashTags(HASH_TAGS.keySet().size());
  }
  
  /**
   * This method will sort the given map keys based on the Values
   * @param actualMap
   * @return sorted Linked Hash Map
   */
  public Map<String, Integer> sortHashMapByValues(Map<String, Integer> actualMap) {
    List<String> mapKeys = new ArrayList<>(actualMap.keySet());
    List<Integer> mapValues = new ArrayList<>(actualMap.values());
    Collections.sort(mapValues, (a, b) -> b - a);
    Collections.sort(mapKeys);

    LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

    Iterator<Integer> valueIt = mapValues.iterator();
    while (valueIt.hasNext()) {
      Integer val = valueIt.next();
      Iterator<String> keyIt = mapKeys.iterator();

      while (keyIt.hasNext()) {
        String key = keyIt.next();
        Integer comp1 = actualMap.get(key);
        Integer comp2 = val;

        if (comp1.equals(comp2)) {
          keyIt.remove();
          sortedMap.put(key, val);
          break;
        }
      }
    }
    return sortedMap;
  }
}
