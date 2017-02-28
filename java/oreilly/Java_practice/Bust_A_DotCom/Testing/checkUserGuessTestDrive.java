import java.util.*;

public class checkUserGuessTestDrive {

    public static void main (String[] args) {

        DotCom tester = new DotCom();

        tester.setName("Test");

        String[] locs = {"B4","C4","D4"};

        for(int x = 0; x < 3; x++) {

            tester.setLocationCells.add(locs[x]);

        }

        DotComBust bustTest = new DotComBust();

        String result = bustTest.checkUserGuess("C4");

        String testResult = "Failed";

        if (result.equals("Hit.") ) {

            testResult = "Passed";

        }

        System.out.println(result);

        System.out.println(testResult);

    }

}


