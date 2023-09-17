package javamodularity.easytext.algorithm.coleman;

import java.util.List;

import org.jvnet.hk2.annotations.Service;

import jakarta.inject.Singleton;
import javamodularity.easytext.algorithm.api.Analyzer;

@Service
@Singleton
final class ColemanAnalyzer implements Analyzer {

  public String getName() {
    return "Coleman-Liau";
  }

  public double analyze(List<List<String>> sentences) {
    float totalsentences = sentences.size();
    float words = sentences.stream().mapToInt(sentence -> sentence.size()).sum();
    float letters =
        sentences.stream()
            .flatMapToInt(sentence -> sentence.stream().mapToInt(word -> word.length()))
            .sum();

    return 0.0588 * (letters / (words / 100)) - 0.296 * (totalsentences / (words / 100)) - 15.8;
  }
}
