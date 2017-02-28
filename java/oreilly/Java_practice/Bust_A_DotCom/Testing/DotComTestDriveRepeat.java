import java.util.ArrayList;

public class DotComTestDriveRepeat {

    public static void main (String[] args) {

        DotCom dot = new DotCom();

        ArrayList<String> locations = new ArrayList<String>();

        String[] locs = {"2","3","4"};

        for(int x = 0; x < 3; x++) {

            locations.add(locs[x]);

        }

        dot.setLocationCells(locations);

        for(int x = 0; x < 2; x++) {

            String userGuess = "2";

            String result = dot.checkYourself(userGuess);

            String testResult = "Failed";

            if (result.equals("Miss") ) {

                testResult = "Passed";

            }

            System.out.println(result);

            System.out.println(testResult);

        }

    }

}
