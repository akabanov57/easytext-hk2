module easytext.gui {
    requires javafx.graphics;
    requires transitive javafx.controls;
    requires easytext.algorithm.api;
    requires org.glassfish.hk2.api;
    opens javamodularity.easytext.gui to javafx.graphics;
}
