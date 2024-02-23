package helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Logs {
    private static final Logger logger = LogManager.getLogger(Logs.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}
