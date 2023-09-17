package javamodularity.easytext.gui;

import java.lang.annotation.Annotation;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

import javafx.application.Application;
import javafx.stage.Stage;
import javamodularity.easytext.algorithm.api.Analyzer;

public final class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
    ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
    EasyTextUI eas = new EasyTextUI(locator.getAllServices(Analyzer.class, new Annotation[0]));
    primaryStage.setTitle("EasyText");
    primaryStage.setScene(eas);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
