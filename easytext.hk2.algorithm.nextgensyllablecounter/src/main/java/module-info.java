module easytext.algorithm.nextgensyllablecounter {
  requires easytext.algorithm.api;
  requires jakarta.inject;
  requires syllable.counter;
  requires org.glassfish.hk2.api;
  opens javamodularity.easytext.algorithm.nextgensyllablecounter to org.glassfish.hk2.locator,org.glassfish.hk2.utilities;
}
