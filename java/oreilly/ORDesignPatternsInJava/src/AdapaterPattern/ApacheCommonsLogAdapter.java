package AdapaterPattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Niko on 3/1/2016.
 */
public class ApacheCommonsLogAdapter extends Logger {
    private Log logger = LogFactory.getLog(ApacheCommonsLogAdapter.class);

    @Override
    public void trace(String str) {
        logger.trace(str);
    }

    @Override
    public void debug(String str) {
        logger.debug(str);
    }

    @Override
    public void log(String str) {
        logger.info(str);
    }
}
