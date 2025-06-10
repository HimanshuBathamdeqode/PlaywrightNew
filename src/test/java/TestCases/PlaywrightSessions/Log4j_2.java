package TestCases.PlaywrightSessions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log4j_2 {
    public static void main(String[] args) {
        Logger log = LogManager.getLogger(Log4j_2.class.getName());

        log.error("Test Error new");
        log.info("This is an information log");
        log.debug("This is a debug log");
    }
}
