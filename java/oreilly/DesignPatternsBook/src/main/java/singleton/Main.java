package singleton;

public class Main {

    public static void main(String[] args) {
        /*
        MyClass class1 = MyClass.getInstance();
        MyClass class2 = MyClass.getInstance();

        System.out.println(class1);
        System.out.println(class2);
        */

        SingletonCauldron cauldron = SingletonCauldron.getInstance();
        cauldron.fill();
        cauldron.boil();
        cauldron.pour();
    }
}
