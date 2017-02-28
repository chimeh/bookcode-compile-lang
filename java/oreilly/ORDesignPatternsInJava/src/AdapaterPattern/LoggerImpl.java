package AdapaterPattern;

/**
 * Created by Niko on 3/1/2016.
 */
public class LoggerImpl extends Logger {
    @Override
    public void trace(String str) {
        System.out.print("TRACE: ");
        System.out.println(str);
    }

    @Override
    public void debug(String str) {
        System.out.print("Debug: ");
        System.out.println(str);
    }

    @Override
    public void log(String str) {
        System.out.print("Log: ");
        System.out.println(str);
    }
}
