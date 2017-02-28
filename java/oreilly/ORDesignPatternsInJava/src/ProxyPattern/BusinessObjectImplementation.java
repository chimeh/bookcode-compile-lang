package ProxyPattern;

/**
 * Created by Niko on 27/12/2015.
 */
public class BusinessObjectImplementation implements BusinessObject {
    @Override
    public void sayHi() {
        System.out.println("Hello! Have a nice day!");
    }
}
