package singleton;

public class ChocolateCauldron {

    private boolean empty;
    private boolean boiled;

    public ChocolateCauldron() {
        empty = true;
        boiled = false;
    }

    public void fill(){
        if (isEmpty()){
            empty = false;
            boiled = false;
            System.out.println("Cauldron if filled by mix of milk and chocolate");
        }
    }

    public void pour(){
        if (!isEmpty() && isBoiled()){
            System.out.println("Mix is pour out of cauldron");
            empty = true;
        }
    }

    public void boil(){
        if (!isEmpty() && !isBoiled()){
            System.out.println("Mix is boiled");
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
