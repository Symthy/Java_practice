package logbacktest.layerone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogOne {
  private final Logger LOGGER = LoggerFactory.getLogger(getClass());
  private final static String NAME = "Layer 1: ";

  public void outputLog() throws Exception {
    LOGGER.trace(NAME + "Trace");
    LOGGER.debug(NAME + "Debug");
    LOGGER.info(NAME + "Info");
    LOGGER.warn(NAME + "Warn");
    LOGGER.error(NAME + "Error");
    throw new Exception("test");
  }
}
