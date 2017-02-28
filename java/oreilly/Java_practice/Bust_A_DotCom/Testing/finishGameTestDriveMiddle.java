public class finishGameTestDriveMiddle {

    public static void main (String[] args) {

        DotComBust dcbt = new DotComBust();

        int guessNum = 27;

        String result = dcbt.finishGame(guessNum);

        String testResult = "Failed";

        if (result.equals("Game Over." + "Hm, glass half-full, glass half-empty.  Which way do you drink?") {

            testResult = "Passed";

        }

        System.out.println(dcbt.finishGame(guessNum);

        System.out.println(testResult);

    }

}
