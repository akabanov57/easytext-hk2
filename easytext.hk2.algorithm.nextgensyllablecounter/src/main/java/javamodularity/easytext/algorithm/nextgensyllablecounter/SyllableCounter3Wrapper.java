package javamodularity.easytext.algorithm.nextgensyllablecounter;

import org.jvnet.hk2.annotations.Service;

import jakarta.inject.Singleton;
import javamodularity.easytext.algorithm.api.SyllableCounter;

@Service(name = "nextgen")
@Singleton
final class SyllableCounter3Wrapper implements SyllableCounter {

  private final eu.crydee.syllablecounter.SyllableCounter counter =
      new eu.crydee.syllablecounter.SyllableCounter();

  @Override
  public int countSyllables(String word) {
    return counter.count(word);
  }
}
