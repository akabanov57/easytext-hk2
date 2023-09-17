package javamodularity.easytext.cli;

import java.io.IOException;
import java.lang.annotation.Annotation;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

import javamodularity.easytext.algorithm.api.Analyzer;

class Main {

  public static void main(String... args) throws IOException {
    ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
    CLI cli = new CLI(locator.getAllServices(Analyzer.class, new Annotation[0]));
    cli.analyze(args[0]);
    locator.shutdown();
  }
}
