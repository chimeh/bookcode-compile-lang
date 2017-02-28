public class finishGameTestDriveHigh {

    public static void main (String[] args) {

        DotComBust dcbt = new DotComBust();

        int guessNum = 35;

        String result = dcbt.finishGame(guessNum);

        String testResult = "Failed";

        if (result.equals("Game Over." + "Need to work on your aim there, kiddo.  Come back when you've had more practice.") {

            testResult = "Passed";

        }

        System.out.println(dcbt.finishGame(guessNum);

        System.out.println(testResult);

    }

}
