package javamodularity.easytext.algorithm.kincaid;

import java.util.List;

import org.jvnet.hk2.annotations.Service;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import javamodularity.easytext.algorithm.api.Analyzer;
import javamodularity.easytext.algorithm.api.SyllableCounter;

@Service
@Singleton
final class KincaidAnalyzer implements Analyzer {

  private final SyllableCounter syllableCounter;

  @Inject
  KincaidAnalyzer(@Named("nextgen") SyllableCounter syllableCounter) {
    this.syllableCounter = syllableCounter;
  }

  public String getName() {
    return "Flesch-Kincaid";
  }

  public double analyze(List<List<String>> sentences) {
    float totalsentences = sentences.size();
    float totalwords = sentences.stream().mapToInt(sentence -> sentence.size()).sum();
    float totalsyllables =
        sentences.stream()
            .flatMapToInt(
                sentence ->
                    sentence.stream().mapToInt(word -> syllableCounter.countSyllables(word)))
            .sum();
    return 206.835 - 1.015 * (totalwords / totalsentences) - 84.6 * (totalsyllables / totalwords);
  }
}
