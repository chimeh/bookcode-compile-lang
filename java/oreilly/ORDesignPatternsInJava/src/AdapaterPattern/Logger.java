package AdapaterPattern;

/**
 * Created by Niko on 3/1/2016.
 */
public abstract class Logger {
    public abstract void trace(String str);
    public abstract void debug(String str);
    public abstract void log(String str);

    public static Logger create() {
//        return new LoggerImpl();
        return new ApacheCommonsLogAdapter();
    }
}
