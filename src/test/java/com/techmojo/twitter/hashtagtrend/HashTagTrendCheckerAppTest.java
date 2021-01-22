package com.techmojo.twitter.hashtagtrend;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class HashTagTrendCheckerAppTest extends TestCase {
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public HashTagTrendCheckerAppTest(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(HashTagTrendCheckerAppTest.class);
  }

  /**
   * Rigourous Test :-)
   */
  public void testApp() {
    HashTagTrendCheckerApp hashTagTrendCheckerApp = new HashTagTrendCheckerApp();
    hashTagTrendCheckerApp.addTweet("hey this is a test tweet. #Twitter");
    assertTrue(hashTagTrendCheckerApp.getTrendingHashTags(5).contains("Twitter"));
    hashTagTrendCheckerApp.addTweet("hey this is a test tweet. #FB");
    hashTagTrendCheckerApp.addTweet("hey this is a test tweet. #Insta");
    hashTagTrendCheckerApp.addTweet("hey this is a test tweet of me. #Twitter");
    assertTrue(hashTagTrendCheckerApp.getTrendingHashTags(1).contains("Twitter"));
    assertFalse(hashTagTrendCheckerApp.getTrendingHashTags(1).contains("FB")); // When Top 1 is Queried others shouldn't be there
    hashTagTrendCheckerApp.addTweet("hey this is a test tweet with two hashTags. #Twitter #Test");
    assertTrue(hashTagTrendCheckerApp.getTrendingHashTags(5).contains("Test")); 
  }
}
