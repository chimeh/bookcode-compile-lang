import java.util.ArrayList;

public class DotComTestDriveKill {

    public static void main (String[] args) {

        DotCom dot = new DotCom();

        ArrayList<String> locations = new ArrayList<String>();

        String[] locs = {"2","3","4"};

        for(int x = 0; x < 3; x++) {

            locations.add(locs[x]);

        }

        dot.setLocationCells(locations);

        for(int x = 0; x < 3; x++) {

            String userGuess = locs[x];

            String result = dot.checkYourself(userGuess);

            String testResult = "Failed";

            if (result.equals("Kill") ) {

                testResult = "Passed";

            }

            System.out.println(result);

            System.out.println(testResult);

        }

    }

}
