module easytext.algorithm.kincaid {
    requires easytext.algorithm.api;
    requires jakarta.inject;
    requires org.glassfish.hk2.api;
    opens javamodularity.easytext.algorithm.kincaid to org.glassfish.hk2.locator,org.glassfish.hk2.utilities;
}
