module easytext.algorithm.coleman {
  requires easytext.algorithm.api;
  requires org.glassfish.hk2.api;
  requires jakarta.inject;
  opens javamodularity.easytext.algorithm.coleman to org.glassfish.hk2.locator,org.glassfish.hk2.utilities;
}
