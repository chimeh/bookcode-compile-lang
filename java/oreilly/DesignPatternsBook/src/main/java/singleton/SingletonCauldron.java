package singleton;

public class SingletonCauldron {
    private boolean empty;
    private boolean boiled;

    private static SingletonCauldron instance;

    private SingletonCauldron() {
        empty = true;
        boiled = false;
    }

    public static synchronized SingletonCauldron getInstance(){
        if (instance == null){
            instance = new SingletonCauldron();
        }
        return instance;
    }

    public void fill(){
        if (isEmpty()){
            this.setEmpty(false);
            this.setBoiled(false);
            System.out.println("Cauldron if filled by mix of milk and chocolate");
        }
    }

    public void pour(){
        if (!isEmpty() && isBoiled()){
            System.out.println("Mix is pour out of cauldron");
            this.setEmpty(true);
        }
    }

    public void boil(){
        if (!isEmpty() && !isBoiled()){
            System.out.println("Mix is boiled");
            this.setBoiled(true);
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void setBoiled(boolean boiled) {
        this.boiled = boiled;
    }
}
