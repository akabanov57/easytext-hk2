package javamodularity.easytext.algorithm.api;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface SyllableCounter {

  int countSyllables(String word);
}
