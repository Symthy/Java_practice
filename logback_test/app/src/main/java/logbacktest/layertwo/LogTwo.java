package logbacktest.layertwo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTwo {
  private final Logger LOGGER = LoggerFactory.getLogger(getClass());
  private final static String NAME = "Layer 2: ";

  public void outputLog() {
    LOGGER.trace(NAME + "Trace");
    LOGGER.debug(NAME + "Debug");
    LOGGER.info(NAME + "Info");
    LOGGER.warn(NAME + "Warn");
    LOGGER.error(NAME + "Error");
  }
}
