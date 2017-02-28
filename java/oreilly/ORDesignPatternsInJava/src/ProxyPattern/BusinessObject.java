package ProxyPattern;

/**
 * Created by Niko on 27/12/2015.
 */
public interface BusinessObject {
    void sayHi();

    public static BusinessObject create(){
        return new BusinessObjectProxy(new BusinessObjectImplementation());
    }
}
