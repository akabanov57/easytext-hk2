package javamodularity.easytext.algorithm.api;

import java.util.List;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface Analyzer {

  String getName();

  double analyze(List<List<String>> text);
}
