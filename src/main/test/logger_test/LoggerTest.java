package logger_test;

import org.apache.log4j.Logger;



public class LoggerTest {

    private static final Logger LOGGER = Logger.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        LOGGER.trace("trace");
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.warn("warn");
        LOGGER.error("error");
        LOGGER.fatal("fatal");
    }
}
