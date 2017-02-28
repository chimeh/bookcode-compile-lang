import java.util.*;

public class CreateDotComTestDrive {

    public static void main (String[] args) {

        //Create a new DotComBust
        Test_DotComBust test = new Test_DotComBust();

        //Run the setUpGame() method
        test.setUpGame();

        //Check if Dot Coms have been created
        for (int x = 0; x < dotComsList.size; x++) {

            if (!dotComsList.get(x).isEmpty() ) {

                System.out.println("A Dot Com has been created!");

            }

        }

    }

}
