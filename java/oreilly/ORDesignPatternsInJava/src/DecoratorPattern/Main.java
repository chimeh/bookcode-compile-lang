package DecoratorPattern;

public class Main {
    public static void main(String[] args){
        GraphicalComponent tf = constructAndersenPoem();
        tf = new BorderDecorator(tf);
        tf.paint();

        System.out.println();
        GraphicalComponent tf2 = construct2Lines();
        tf2 = new BorderDecorator(tf2);
        tf2.paint();
    }

    public static GraphicalComponent constructAndersenPoem(){
        GraphicalComponent tf = new TextField();
        tf = tf.addContent("To move, to breathe, to fly, to float");
        tf = tf.addContent("To gain all while you give");
        tf = tf.addContent("--H.C. Andersen");
        return tf;
    }

    public static GraphicalComponent construct2Lines(){
        GraphicalComponent tf = new TextField();
        tf = tf.addContent("To move, to breathe, to fly, to float");
        tf = tf.addContent("--H.C. Andersen");
        return tf;
    }
}
