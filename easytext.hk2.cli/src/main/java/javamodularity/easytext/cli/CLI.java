package javamodularity.easytext.cli;

import static javamodularity.easytext.algorithm.api.Preprocessing.toSentences;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javamodularity.easytext.algorithm.api.Analyzer;

final class CLI {

  private final List<Analyzer> analyzers;

  CLI(List<Analyzer> analyzers) {
    this.analyzers = analyzers;
  }

  void analyze(String filename) throws IOException {
    if (filename.length() == 0) {
      System.out.println("Welcome to EasyText. Please provide a filename as input argument");
      return;
    }

    Path path = Paths.get(filename);
    System.out.println("Reading " + path);
    String text = new String(Files.readAllBytes(path), Charset.forName("UTF-8"));

    List<List<String>> sentences = toSentences(text);

    for (Analyzer analyzer : analyzers) {
      System.out.println(analyzer.getName() + ": " + analyzer.analyze(sentences));
    }
  }
}
