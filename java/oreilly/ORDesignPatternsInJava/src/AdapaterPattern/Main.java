package AdapaterPattern;

/**
 * Created by Niko on 3/1/2016.
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.create();
        logger.debug("debug msg");
        logger.trace("trace msg");
        logger.log("log msg");
    }
}
