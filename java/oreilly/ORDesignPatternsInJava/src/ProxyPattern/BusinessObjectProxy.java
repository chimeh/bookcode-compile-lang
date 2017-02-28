package ProxyPattern;

/**
 * Created by Niko on 27/12/2015.
 */
public class BusinessObjectProxy implements BusinessObject {

    private final BusinessObject target;

    public BusinessObjectProxy(BusinessObject target){
        this.target = target;
    }
    @Override
    public void sayHi() {
        System.out.println("about to call real... ");
        this.target.sayHi();
        System.out.println("completed call to real...");
    }
}
